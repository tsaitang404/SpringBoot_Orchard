package com.xdz.orchard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xdz.orchard.mapper.EmployeeMapper;
import com.xdz.orchard.entity.Employee;
import com.xdz.orchard.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * 员工(Employee)表服务实现类
 *
 * @author xdz
 * @since 2024-06-20 16:15:53
 */
@Service("employeeService")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
