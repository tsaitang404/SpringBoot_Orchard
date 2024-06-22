package com.xdz.orchard.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xdz.orchard.entity.Admin;
import com.xdz.orchard.entity.LoginUser;
import com.xdz.orchard.mapper.AdminMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private AdminMapper adminMapper;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Admin::getUsername,username);
        Admin one = adminMapper.selectOne(wrapper);
        if (Objects.isNull(one)){
            return null;
        }else {
            return new LoginUser(one);
        }
    }
}
