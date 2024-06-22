package com.xdz.orchard.controller;


import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import com.xdz.orchard.entity.IrrigationRecord;
import com.xdz.orchard.service.IrrigationRecordService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 灌溉记录(IrrigationRecord)表控制层
 *
 * @author xdz
 * @since 2024-06-20 16:15:56
 */
@RestController
@RequestMapping("irrigationRecord")
public class IrrigationRecordController {
    /**
     * 服务对象
     */
    @Resource
    private IrrigationRecordService irrigationRecordService;

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("/findAll")
    public HttpResponse<List<IrrigationRecord>> findAll() {
        List<IrrigationRecord> irrigationRecordList = irrigationRecordService.list();
        return ResultBuilder.success(irrigationRecordList, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/findByPage")
    public HttpResponse<Page<IrrigationRecord>> findByPage(
            IrrigationRecord irrigationRecord,
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize) {
        Page<IrrigationRecord> irrigationRecordPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<IrrigationRecord> wrapper = new LambdaQueryWrapper<>(irrigationRecord);
        irrigationRecordPage = irrigationRecordService.page(irrigationRecordPage, wrapper);
        return ResultBuilder.success(irrigationRecordPage, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 加载数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/load/{id}")
    public HttpResponse<IrrigationRecord> load(@PathVariable Integer id) {
        return ResultBuilder.success(irrigationRecordService.getById(id), ResultCode.QUERY_SUCCESS);
    }

    /**
     * 添加数据
     *
     * @param irrigationRecord
     * @return
     */
    @PostMapping("/add")
    public HttpResponse add(@RequestBody IrrigationRecord irrigationRecord) {
        irrigationRecordService.save(irrigationRecord);
        return ResultBuilder.success(true, ResultCode.SAVE_SUCCESS);
    }

    /**
     * 更新数据
     *
     * @param irrigationRecord
     * @return
     */
    @PutMapping("/update")
    public HttpResponse update(@RequestBody IrrigationRecord irrigationRecord) {
        irrigationRecordService.updateById(irrigationRecord);
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
        irrigationRecordService.removeById(id);
        return ResultBuilder.success(true, ResultCode.DELETE_SUCCESS);
    }
}
