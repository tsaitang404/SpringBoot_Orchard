package com.xdz.orchard.controller;


import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import com.xdz.orchard.entity.Employee;
import com.xdz.orchard.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 员工(Employee)表控制层
 *
 * @author xdz
 * @since 2024-06-20 16:15:53
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeService employeeService;

    /**
     * 查询全部
     *
     * @return
     */
    @GetMapping("/findAll")
    public HttpResponse<List<Employee>> findAll() {
        List<Employee> employeeList = employeeService.list();
        return ResultBuilder.success(employeeList, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping("/findByPage")
    public HttpResponse<Page<Employee>> findByPage(
            Employee employee,
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize) {
        Page<Employee> employeePage = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>(employee);
        employeePage = employeeService.page(employeePage, wrapper);
        return ResultBuilder.success(employeePage, ResultCode.QUERY_SUCCESS);
    }

    /**
     * 加载数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/load/{id}")
    public HttpResponse<Employee> load(@PathVariable Integer id) {
        return ResultBuilder.success(employeeService.getById(id), ResultCode.QUERY_SUCCESS);
    }

    /**
     * 添加数据
     *
     * @param employee
     * @return
     */
    @PostMapping("/add")
    public HttpResponse add(@RequestBody Employee employee) {
        employeeService.save(employee);
        return ResultBuilder.success(true, ResultCode.SAVE_SUCCESS);
    }

    /**
     * 更新数据
     *
     * @param employee
     * @return
     */
    @PutMapping("/update")
    public HttpResponse update(@RequestBody Employee employee) {
        employeeService.updateById(employee);
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
        employeeService.removeById(id);
        return ResultBuilder.success(true, ResultCode.DELETE_SUCCESS);
    }
}
