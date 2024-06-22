package com.xdz.orchard.controller;


import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import com.xdz.orchard.entity.PruningRecord;
import com.xdz.orchard.service.PruningRecordService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 修剪记录(PruningRecord)表控制层
 *
 * @author xdz
 * @since 2024-06-20 16:35:18
 */
@RestController
@RequestMapping("pruningRecord")
public class PruningRecordController {
    /**
     * 服务对象
     */
    @Resource
    private PruningRecordService pruningRecordService;

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("/findAll")
    public HttpResponse<List<PruningRecord>> findAll() {
        List<PruningRecord> pruningRecordList = pruningRecordService.list();
        return ResultBuilder.success(pruningRecordList, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/findByPage")
    public HttpResponse<Page<PruningRecord>> findByPage(
            PruningRecord pruningRecord,
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize) {
        Page<PruningRecord> pruningRecordPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<PruningRecord> wrapper = new LambdaQueryWrapper<>(pruningRecord);
        pruningRecordPage = pruningRecordService.page(pruningRecordPage, wrapper);
        return ResultBuilder.success(pruningRecordPage, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 加载数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/load/{id}")
    public HttpResponse<PruningRecord> load(@PathVariable Integer id) {
        return ResultBuilder.success(pruningRecordService.getById(id), ResultCode.QUERY_SUCCESS);
    }

    /**
     * 添加数据
     *
     * @param pruningRecord
     * @return
     */
    @PostMapping("/add")
    public HttpResponse add(@RequestBody PruningRecord pruningRecord) {
        pruningRecordService.save(pruningRecord);
        return ResultBuilder.success(true, ResultCode.SAVE_SUCCESS);
    }

    /**
     * 更新数据
     *
     * @param pruningRecord
     * @return
     */
    @PutMapping("/update")
    public HttpResponse update(@RequestBody PruningRecord pruningRecord) {
        pruningRecordService.updateById(pruningRecord);
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
        pruningRecordService.removeById(id);
        return ResultBuilder.success(true, ResultCode.DELETE_SUCCESS);
    }
}
