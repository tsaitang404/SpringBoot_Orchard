package com.xdz.orchard.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xdz.orchard.entity.Admin;
import com.xdz.orchard.service.AdminService;
import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 管理员(Admin)表控制层
 *
 * @author xdz
 * @since 2023-04-29 19:47:08
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("/findAll")
    public HttpResponse<List<Admin>> findAll() {
        List<Admin> adminList = adminService.list();
        return ResultBuilder.success(adminList, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/findByPage")
    public HttpResponse<Page<Admin>> findByPage(
            Admin admin,
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize) {
        Page<Admin> adminPage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>(admin);
        adminPage = adminService.page(adminPage, wrapper);
        return ResultBuilder.success(adminPage, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 加载数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/load")
    public HttpResponse<Admin> load(Integer id) {
        return ResultBuilder.success(adminService.getById(id), ResultCode.QUERY_SUCCESS);
    }

    /**
     * 添加数据
     *
     * @param admin
     * @return
     */
    @PostMapping("/add")
    public HttpResponse add(@RequestBody Admin admin) {
        adminService.save(admin);
        return ResultBuilder.successNoData(ResultCode.SAVE_SUCCESS);
    }

    /**
     * 更新数据
     *
     * @param admin
     * @return
     */
    @PutMapping("/update")
    public HttpResponse update(@RequestBody Admin admin) {
        adminService.updateById(admin);
        return ResultBuilder.successNoData(ResultCode.UPDATE_SUCCESS);
    }

    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public HttpResponse delete(@PathVariable Integer id) {
        adminService.removeById(id);
        return ResultBuilder.successNoData(ResultCode.DELETE_SUCCESS);
    }
}
