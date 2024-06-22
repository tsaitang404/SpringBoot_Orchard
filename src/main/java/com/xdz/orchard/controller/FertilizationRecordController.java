package com.xdz.orchard.controller;


import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import com.xdz.orchard.entity.FertilizationRecord;
import com.xdz.orchard.service.FertilizationRecordService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 施肥记录(FertilizationRecord)表控制层
 *
 * @author xdz
 * @since 2024-06-20 16:15:53
 */
@RestController
@RequestMapping("fertilizationRecord")
public class FertilizationRecordController {
    /**
     * 服务对象
     */
    @Resource
    private FertilizationRecordService fertilizationRecordService;

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("/findAll")
    public HttpResponse<List<FertilizationRecord>> findAll() {
        List<FertilizationRecord> fertilizationRecordList = fertilizationRecordService.list();
        return ResultBuilder.success(fertilizationRecordList, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/findByPage")
    public HttpResponse<Page<FertilizationRecord>> findByPage(
            FertilizationRecord fertilizationRecord,
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize) {
        Page<FertilizationRecord> fertilizationRecordPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<FertilizationRecord> wrapper = new LambdaQueryWrapper<>(fertilizationRecord);
        fertilizationRecordPage = fertilizationRecordService.page(fertilizationRecordPage, wrapper);
        return ResultBuilder.success(fertilizationRecordPage, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 加载数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/load/{id}")
    public HttpResponse<FertilizationRecord> load(@PathVariable Integer id) {
        return ResultBuilder.success(fertilizationRecordService.getById(id), ResultCode.QUERY_SUCCESS);
    }

    /**
     * 添加数据
     *
     * @param fertilizationRecord
     * @return
     */
    @PostMapping("/add")
    public HttpResponse add(@RequestBody FertilizationRecord fertilizationRecord) {
        fertilizationRecordService.save(fertilizationRecord);
        return ResultBuilder.success(true, ResultCode.SAVE_SUCCESS);
    }

    /**
     * 更新数据
     *
     * @param fertilizationRecord
     * @return
     */
    @PutMapping("/update")
    public HttpResponse update(@RequestBody FertilizationRecord fertilizationRecord) {
        fertilizationRecordService.updateById(fertilizationRecord);
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
        fertilizationRecordService.removeById(id);
        return ResultBuilder.success(true, ResultCode.DELETE_SUCCESS);
    }
}
