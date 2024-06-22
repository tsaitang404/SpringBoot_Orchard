package com.xdz.orchard.controller;


import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import com.xdz.orchard.entity.Visitor;
import com.xdz.orchard.service.VisitorService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 游客(Visitor)表控制层
 *
 * @author xdz
 * @since 2024-06-20 16:35:19
 */
@RestController
@RequestMapping("visitor")
public class VisitorController {
    /**
     * 服务对象
     */
    @Resource
    private VisitorService visitorService;

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("/findAll")
    public HttpResponse<List<Visitor>> findAll() {
        List<Visitor> visitorList = visitorService.list();
        return ResultBuilder.success(visitorList, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/findByPage")
    public HttpResponse<Page<Visitor>> findByPage(
            Visitor visitor,
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize) {
        Page<Visitor> visitorPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Visitor> wrapper = new LambdaQueryWrapper<>(visitor);
        visitorPage = visitorService.page(visitorPage, wrapper);
        return ResultBuilder.success(visitorPage, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 加载数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/load/{id}")
    public HttpResponse<Visitor> load(@PathVariable Integer id) {
        return ResultBuilder.success(visitorService.getById(id), ResultCode.QUERY_SUCCESS);
    }

    /**
     * 添加数据
     *
     * @param visitor
     * @return
     */
    @PostMapping("/add")
    public HttpResponse add(@RequestBody Visitor visitor) {
        visitorService.save(visitor);
        return ResultBuilder.success(true, ResultCode.SAVE_SUCCESS);
    }

    /**
     * 更新数据
     *
     * @param visitor
     * @return
     */
    @PutMapping("/update")
    public HttpResponse update(@RequestBody Visitor visitor) {
        visitorService.updateById(visitor);
        return ResultBuilder.success(true, ResultCode.UPDATE_SUCCESS);
    }

    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public HttpResponse delete(@PathVariable Integer id) {
        visitorService.removeById(id);
        return ResultBuilder.success(true, ResultCode.DELETE_SUCCESS);
    }
}
