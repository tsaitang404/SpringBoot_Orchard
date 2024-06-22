package com.xdz.orchard.controller;


import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import com.xdz.orchard.entity.DiseaseRecord;
import com.xdz.orchard.service.DiseaseRecordService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 病害记录(DiseaseRecord)表控制层
 *
 * @author xdz
 * @since 2024-06-20 16:15:22
 */
@RestController
@RequestMapping("diseaseRecord")
public class DiseaseRecordController {
    /**
     * 服务对象
     */
    @Resource
    private DiseaseRecordService diseaseRecordService;

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("/findAll")
    public HttpResponse<List<DiseaseRecord>> findAll() {
        List<DiseaseRecord> diseaseRecordList = diseaseRecordService.list();
        return ResultBuilder.success(diseaseRecordList, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/findByPage")
    public HttpResponse<Page<DiseaseRecord>> findByPage(
            DiseaseRecord diseaseRecord,
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize) {
        Page<DiseaseRecord> diseaseRecordPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<DiseaseRecord> wrapper = new LambdaQueryWrapper<>(diseaseRecord);
        diseaseRecordPage = diseaseRecordService.page(diseaseRecordPage, wrapper);
        return ResultBuilder.success(diseaseRecordPage, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 加载数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/load/{id}")
    public HttpResponse<DiseaseRecord> load(@PathVariable Integer id) {
        return ResultBuilder.success(diseaseRecordService.getById(id), ResultCode.QUERY_SUCCESS);
    }

    /**
     * 添加数据
     *
     * @param diseaseRecord
     * @return
     */
    @PostMapping("/add")
    public HttpResponse add(@RequestBody DiseaseRecord diseaseRecord) {
        diseaseRecordService.save(diseaseRecord);
        return ResultBuilder.success(true, ResultCode.SAVE_SUCCESS);
    }

    /**
     * 更新数据
     *
     * @param diseaseRecord
     * @return
     */
    @PutMapping("/update")
    public HttpResponse update(@RequestBody DiseaseRecord diseaseRecord) {
        diseaseRecordService.updateById(diseaseRecord);
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
        diseaseRecordService.removeById(id);
        return ResultBuilder.success(true, ResultCode.DELETE_SUCCESS);
    }
}
