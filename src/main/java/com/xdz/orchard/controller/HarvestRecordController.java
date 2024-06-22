package com.xdz.orchard.controller;


import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import com.xdz.orchard.entity.HarvestRecord;
import com.xdz.orchard.service.HarvestRecordService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 采摘记录(HarvestRecord)表控制层
 *
 * @author xdz
 * @since 2024-06-20 16:15:55
 */
@RestController
@RequestMapping("harvestRecord")
public class HarvestRecordController {
    /**
     * 服务对象
     */
    @Resource
    private HarvestRecordService harvestRecordService;

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("/findAll")
    public HttpResponse<List<HarvestRecord>> findAll() {
        List<HarvestRecord> harvestRecordList = harvestRecordService.list();
        return ResultBuilder.success(harvestRecordList, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/findByPage")
    public HttpResponse<Page<HarvestRecord>> findByPage(
            HarvestRecord harvestRecord,
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize) {
        Page<HarvestRecord> harvestRecordPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<HarvestRecord> wrapper = new LambdaQueryWrapper<>(harvestRecord);
        harvestRecordPage = harvestRecordService.page(harvestRecordPage, wrapper);
        return ResultBuilder.success(harvestRecordPage, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 加载数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/load/{id}")
    public HttpResponse<HarvestRecord> load(@PathVariable Integer id) {
        return ResultBuilder.success(harvestRecordService.getById(id), ResultCode.QUERY_SUCCESS);
    }

    /**
     * 添加数据
     *
     * @param harvestRecord
     * @return
     */
    @PostMapping("/add")
    public HttpResponse add(@RequestBody HarvestRecord harvestRecord) {
        harvestRecordService.save(harvestRecord);
        return ResultBuilder.success(true, ResultCode.SAVE_SUCCESS);
    }

    /**
     * 更新数据
     *
     * @param harvestRecord
     * @return
     */
    @PutMapping("/update")
    public HttpResponse update(@RequestBody HarvestRecord harvestRecord) {
        harvestRecordService.updateById(harvestRecord);
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
        harvestRecordService.removeById(id);
        return ResultBuilder.success(true, ResultCode.DELETE_SUCCESS);
    }
}
