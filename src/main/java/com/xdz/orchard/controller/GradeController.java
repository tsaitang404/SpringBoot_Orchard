package com.xdz.orchard.controller;


import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import com.xdz.orchard.entity.Grade;
import com.xdz.orchard.service.GradeService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 品级(Grade)表控制层
 *
 * @author xdz
 * @since 2024-06-20 16:15:54
 */
@RestController
@RequestMapping("grade")
public class GradeController {
    /**
     * 服务对象
     */
    @Resource
    private GradeService gradeService;

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("/findAll")
    public HttpResponse<List<Grade>> findAll() {
        List<Grade> gradeList = gradeService.list();
        return ResultBuilder.success(gradeList, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/findByPage")
    public HttpResponse<Page<Grade>> findByPage(
            Grade grade,
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize) {
        Page<Grade> gradePage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Grade> wrapper = new LambdaQueryWrapper<>(grade);
        gradePage = gradeService.page(gradePage, wrapper);
        return ResultBuilder.success(gradePage, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 加载数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/load/{id}")
    public HttpResponse<Grade> load(@PathVariable Integer id) {
        return ResultBuilder.success(gradeService.getById(id), ResultCode.QUERY_SUCCESS);
    }

    /**
     * 添加数据
     *
     * @param grade
     * @return
     */
    @PostMapping("/add")
    public HttpResponse add(@RequestBody Grade grade) {
        gradeService.save(grade);
        return ResultBuilder.success(true, ResultCode.SAVE_SUCCESS);
    }

    /**
     * 更新数据
     *
     * @param grade
     * @return
     */
    @PutMapping("/update")
    public HttpResponse update(@RequestBody Grade grade) {
        gradeService.updateById(grade);
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
        gradeService.removeById(id);
        return ResultBuilder.success(true, ResultCode.DELETE_SUCCESS);
    }
}
