package com.xdz.orchard.controller;


import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import com.xdz.orchard.entity.WeedingRecord;
import com.xdz.orchard.service.WeedingRecordService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 除草记录(WeedingRecord)表控制层
 *
 * @author xdz
 * @since 2024-06-20 16:35:20
 */
@RestController
@RequestMapping("weedingRecord")
public class WeedingRecordController {
    /**
     * 服务对象
     */
    @Resource
    private WeedingRecordService weedingRecordService;

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("/findAll")
    public HttpResponse<List<WeedingRecord>> findAll() {
        List<WeedingRecord> weedingRecordList = weedingRecordService.list();
        return ResultBuilder.success(weedingRecordList, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/findByPage")
    public HttpResponse<Page<WeedingRecord>> findByPage(
            WeedingRecord weedingRecord,
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize) {
        Page<WeedingRecord> weedingRecordPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<WeedingRecord> wrapper = new LambdaQueryWrapper<>(weedingRecord);
        weedingRecordPage = weedingRecordService.page(weedingRecordPage, wrapper);
        return ResultBuilder.success(weedingRecordPage, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 加载数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/load/{id}")
    public HttpResponse<WeedingRecord> load(@PathVariable Integer id) {
        return ResultBuilder.success(weedingRecordService.getById(id), ResultCode.QUERY_SUCCESS);
    }

    /**
     * 添加数据
     *
     * @param weedingRecord
     * @return
     */
    @PostMapping("/add")
    public HttpResponse add(@RequestBody WeedingRecord weedingRecord) {
        weedingRecordService.save(weedingRecord);
        return ResultBuilder.success(true, ResultCode.SAVE_SUCCESS);
    }

    /**
     * 更新数据
     *
     * @param weedingRecord
     * @return
     */
    @PutMapping("/update")
    public HttpResponse update(@RequestBody WeedingRecord weedingRecord) {
        weedingRecordService.updateById(weedingRecord);
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
        weedingRecordService.removeById(id);
        return ResultBuilder.success(true, ResultCode.DELETE_SUCCESS);
    }
}
