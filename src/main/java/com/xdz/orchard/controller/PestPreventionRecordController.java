package com.xdz.orchard.controller;


import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import com.xdz.orchard.entity.PestPreventionRecord;
import com.xdz.orchard.service.PestPreventionRecordService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 防虫记录(PestPreventionRecord)表控制层
 *
 * @author xdz
 * @since 2024-06-20 16:15:57
 */
@RestController
@RequestMapping("pestPreventionRecord")
public class PestPreventionRecordController {
    /**
     * 服务对象
     */
    @Resource
    private PestPreventionRecordService pestPreventionRecordService;

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("/findAll")
    public HttpResponse<List<PestPreventionRecord>> findAll() {
        List<PestPreventionRecord> pestPreventionRecordList = pestPreventionRecordService.list();
        return ResultBuilder.success(pestPreventionRecordList, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/findByPage")
    public HttpResponse<Page<PestPreventionRecord>> findByPage(
            PestPreventionRecord pestPreventionRecord,
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize) {
        Page<PestPreventionRecord> pestPreventionRecordPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<PestPreventionRecord> wrapper = new LambdaQueryWrapper<>(pestPreventionRecord);
        pestPreventionRecordPage = pestPreventionRecordService.page(pestPreventionRecordPage, wrapper);
        return ResultBuilder.success(pestPreventionRecordPage, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 加载数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/load/{id}")
    public HttpResponse<PestPreventionRecord> load(@PathVariable Integer id) {
        return ResultBuilder.success(pestPreventionRecordService.getById(id), ResultCode.QUERY_SUCCESS);
    }

    /**
     * 添加数据
     *
     * @param pestPreventionRecord
     * @return
     */
    @PostMapping("/add")
    public HttpResponse add(@RequestBody PestPreventionRecord pestPreventionRecord) {
        pestPreventionRecordService.save(pestPreventionRecord);
        return ResultBuilder.success(true, ResultCode.SAVE_SUCCESS);
    }

    /**
     * 更新数据
     *
     * @param pestPreventionRecord
     * @return
     */
    @PutMapping("/update")
    public HttpResponse update(@RequestBody PestPreventionRecord pestPreventionRecord) {
        pestPreventionRecordService.updateById(pestPreventionRecord);
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
        pestPreventionRecordService.removeById(id);
        return ResultBuilder.success(true, ResultCode.DELETE_SUCCESS);
    }
}
