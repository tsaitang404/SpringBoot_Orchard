package com.xdz.orchard.controller;


import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import com.xdz.orchard.entity.SoilManagementRecord;
import com.xdz.orchard.service.SoilManagementRecordService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 土壤管理记录(SoilManagementRecord)表控制层
 *
 * @author xdz
 * @since 2024-06-20 16:35:18
 */
@RestController
@RequestMapping("soilManagementRecord")
public class SoilManagementRecordController {
    /**
     * 服务对象
     */
    @Resource
    private SoilManagementRecordService soilManagementRecordService;

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("/findAll")
    public HttpResponse<List<SoilManagementRecord>> findAll() {
        List<SoilManagementRecord> soilManagementRecordList = soilManagementRecordService.list();
        return ResultBuilder.success(soilManagementRecordList, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/findByPage")
    public HttpResponse<Page<SoilManagementRecord>> findByPage(
            SoilManagementRecord soilManagementRecord,
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize) {
        Page<SoilManagementRecord> soilManagementRecordPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<SoilManagementRecord> wrapper = new LambdaQueryWrapper<>(soilManagementRecord);
        soilManagementRecordPage = soilManagementRecordService.page(soilManagementRecordPage, wrapper);
        return ResultBuilder.success(soilManagementRecordPage, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 加载数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/load/{id}")
    public HttpResponse<SoilManagementRecord> load(@PathVariable Integer id) {
        return ResultBuilder.success(soilManagementRecordService.getById(id), ResultCode.QUERY_SUCCESS);
    }

    /**
     * 添加数据
     *
     * @param soilManagementRecord
     * @return
     */
    @PostMapping("/add")
    public HttpResponse add(@RequestBody SoilManagementRecord soilManagementRecord) {
        soilManagementRecordService.save(soilManagementRecord);
        return ResultBuilder.success(true, ResultCode.SAVE_SUCCESS);
    }

    /**
     * 更新数据
     *
     * @param soilManagementRecord
     * @return
     */
    @PutMapping("/update")
    public HttpResponse update(@RequestBody SoilManagementRecord soilManagementRecord) {
        soilManagementRecordService.updateById(soilManagementRecord);
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
        soilManagementRecordService.removeById(id);
        return ResultBuilder.success(true, ResultCode.DELETE_SUCCESS);
    }
}
