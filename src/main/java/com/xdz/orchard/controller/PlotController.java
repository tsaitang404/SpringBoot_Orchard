package com.xdz.orchard.controller;


import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import com.xdz.orchard.entity.Plot;
import com.xdz.orchard.service.PlotService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 地块(Plot)表控制层
 *
 * @author xdz
 * @since 2024-06-20 15:37:57
 */
@RestController
@RequestMapping("plot")
public class PlotController {
    /**
     * 服务对象
     */
    @Resource
    private PlotService plotService;

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("/findAll")
    public HttpResponse<List<Plot>> findAll() {
        List<Plot> plotList = plotService.list();
        return ResultBuilder.success(plotList, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/findByPage")
    public HttpResponse<Page<Plot>> findByPage(
            Plot plot,
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize) {
        Page<Plot> plotPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Plot> wrapper = new LambdaQueryWrapper<>(plot);
        plotPage = plotService.page(plotPage, wrapper);
        return ResultBuilder.success(plotPage, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 加载数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/load/{id}")
    public HttpResponse<Plot> load(@PathVariable Integer id) {
        return ResultBuilder.success(plotService.getById(id), ResultCode.QUERY_SUCCESS);
    }

    /**
     * 添加数据
     *
     * @param plot
     * @return
     */
    @PostMapping("/add")
    public HttpResponse add(@RequestBody Plot plot) {
        plotService.save(plot);
        return ResultBuilder.success(true, ResultCode.SAVE_SUCCESS);
    }

    /**
     * 更新数据
     *
     * @param plot
     * @return
     */
    @PutMapping("/update")
    public HttpResponse update(@RequestBody Plot plot) {
        plotService.updateById(plot);
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
        plotService.removeById(id);
        return ResultBuilder.success(true, ResultCode.DELETE_SUCCESS);
    }
}
