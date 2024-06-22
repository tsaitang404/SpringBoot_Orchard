package com.xdz.orchard.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xdz.orchard.entity.Admin;
import com.xdz.orchard.mapper.AdminMapper;
import com.xdz.orchard.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * 管理员(Admin)表服务实现类
 *
 * @author xdz
 * @since 2023-04-29 19:47:07
 */
@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
