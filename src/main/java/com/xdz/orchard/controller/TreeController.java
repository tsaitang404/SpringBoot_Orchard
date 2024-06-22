package com.xdz.orchard.controller;


import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import com.xdz.orchard.entity.Tree;
import com.xdz.orchard.service.TreeService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 果树(Tree)表控制层
 *
 * @author xdz
 * @since 2024-06-20 15:45:33
 */
@RestController
@RequestMapping("tree")
public class TreeController {
    /**
     * 服务对象
     */
    @Resource
    private TreeService treeService;

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("/findAll")
    public HttpResponse<List<Tree>> findAll() {
        List<Tree> treeList = treeService.list();
        return ResultBuilder.success(treeList, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/findByPage")
    public HttpResponse<Page<Tree>> findByPage(
            Tree tree,
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize) {
        Page<Tree> treePage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Tree> wrapper = new LambdaQueryWrapper<>(tree);
        treePage = treeService.page(treePage, wrapper);
        return ResultBuilder.success(treePage, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 加载数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/load/{id}")
    public HttpResponse<Tree> load(@PathVariable Integer id) {
        return ResultBuilder.success(treeService.getById(id), ResultCode.QUERY_SUCCESS);
    }

    /**
     * 添加数据
     *
     * @param tree
     * @return
     */
    @PostMapping("/add")
    public HttpResponse add(@RequestBody Tree tree) {
        treeService.save(tree);
        return ResultBuilder.success(true, ResultCode.SAVE_SUCCESS);
    }

    /**
     * 更新数据
     *
     * @param tree
     * @return
     */
    @PutMapping("/update")
    public HttpResponse update(@RequestBody Tree tree) {
        treeService.updateById(tree);
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
        treeService.removeById(id);
        return ResultBuilder.success(true, ResultCode.DELETE_SUCCESS);
    }
}
