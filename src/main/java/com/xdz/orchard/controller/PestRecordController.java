package com.xdz.orchard.controller;


import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import com.xdz.orchard.entity.PestRecord;
import com.xdz.orchard.service.PestRecordService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 虫害记录(PestRecord)表控制层
 *
 * @author xdz
 * @since 2024-06-20 16:15:58
 */
@RestController
@RequestMapping("pestRecord")
public class PestRecordController {
    /**
     * 服务对象
     */
    @Resource
    private PestRecordService pestRecordService;

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("/findAll")
    public HttpResponse<List<PestRecord>> findAll() {
        List<PestRecord> pestRecordList = pestRecordService.list();
        return ResultBuilder.success(pestRecordList, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/findByPage")
    public HttpResponse<Page<PestRecord>> findByPage(
            PestRecord pestRecord,
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize) {
        Page<PestRecord> pestRecordPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<PestRecord> wrapper = new LambdaQueryWrapper<>(pestRecord);
        pestRecordPage = pestRecordService.page(pestRecordPage, wrapper);
        return ResultBuilder.success(pestRecordPage, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 加载数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/load/{id}")
    public HttpResponse<PestRecord> load(@PathVariable Integer id) {
        return ResultBuilder.success(pestRecordService.getById(id), ResultCode.QUERY_SUCCESS);
    }

    /**
     * 添加数据
     *
     * @param pestRecord
     * @return
     */
    @PostMapping("/add")
    public HttpResponse add(@RequestBody PestRecord pestRecord) {
        pestRecordService.save(pestRecord);
        return ResultBuilder.success(true, ResultCode.SAVE_SUCCESS);
    }

    /**
     * 更新数据
     *
     * @param pestRecord
     * @return
     */
    @PutMapping("/update")
    public HttpResponse update(@RequestBody PestRecord pestRecord) {
        pestRecordService.updateById(pestRecord);
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
        pestRecordService.removeById(id);
        return ResultBuilder.success(true, ResultCode.DELETE_SUCCESS);
    }
}
