package com.xdz.orchard.controller;


import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import com.xdz.orchard.entity.DiseasePreventionRecord;
import com.xdz.orchard.service.DiseasePreventionRecordService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 防病记录(DiseasePreventionRecord)表控制层
 *
 * @author xdz
 * @since 2024-06-20 15:58:44
 */
@RestController
@RequestMapping("diseasePreventionRecord")
public class DiseasePreventionRecordController {
    /**
     * 服务对象
     */
    @Resource
    private DiseasePreventionRecordService diseasePreventionRecordService;

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("/findAll")
    public HttpResponse<List<DiseasePreventionRecord>> findAll() {
        List<DiseasePreventionRecord> diseasePreventionRecordList = diseasePreventionRecordService.list();
        return ResultBuilder.success(diseasePreventionRecordList, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/findByPage")
    public HttpResponse<Page<DiseasePreventionRecord>> findByPage(
            DiseasePreventionRecord diseasePreventionRecord,
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize) {
        Page<DiseasePreventionRecord> diseasePreventionRecordPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<DiseasePreventionRecord> wrapper = new LambdaQueryWrapper<>(diseasePreventionRecord);
        diseasePreventionRecordPage = diseasePreventionRecordService.page(diseasePreventionRecordPage, wrapper);
        return ResultBuilder.success(diseasePreventionRecordPage, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 加载数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/load/{id}")
    public HttpResponse<DiseasePreventionRecord> load(@PathVariable Integer id) {
        return ResultBuilder.success(diseasePreventionRecordService.getById(id), ResultCode.QUERY_SUCCESS);
    }

    /**
     * 添加数据
     *
     * @param diseasePreventionRecord
     * @return
     */
    @PostMapping("/add")
    public HttpResponse add(@RequestBody DiseasePreventionRecord diseasePreventionRecord) {
        diseasePreventionRecordService.save(diseasePreventionRecord);
        return ResultBuilder.success(true, ResultCode.SAVE_SUCCESS);
    }

    /**
     * 更新数据
     *
     * @param diseasePreventionRecord
     * @return
     */
    @PutMapping("/update")
    public HttpResponse update(@RequestBody DiseasePreventionRecord diseasePreventionRecord) {
        diseasePreventionRecordService.updateById(diseasePreventionRecord);
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
        diseasePreventionRecordService.removeById(id);
        return ResultBuilder.success(true, ResultCode.DELETE_SUCCESS);
    }
}
