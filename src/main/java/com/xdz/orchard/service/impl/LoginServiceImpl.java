package com.xdz.orchard.service.impl;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.xdz.orchard.entity.Admin;
import com.xdz.orchard.entity.LoginUser;
import com.xdz.orchard.service.AdminService;
import com.xdz.orchard.service.LoginService;
import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.JwtUtil;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private AdminService adminService;
    
    @Override
    public HttpResponse login(Admin user) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,null);
        Authentication authenticate = authenticationManager.authenticate(authentication);
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("登录失败");
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        Admin loginUserUser = loginUser.getAdmin();
        String jwt = JwtUtil.createJWT(loginUserUser.getId()+"",(long) (60*60*1000));
        String refJwt = JwtUtil.createJWT(loginUserUser.getId()+"", (long) ((30*60*1000)));
        DateTime dateTime = DateUtil.offsetMinute(new Date(), 60);
        String format = DateUtil.format(dateTime, "yyyy/MM/dd HH:mm:ss");
        Map<String, Object> map = new HashMap<>();
        map.put("accessToken",jwt);
        map.put("refreshToken",refJwt);
        map.put("expires",format);
        map.put("user",loginUserUser);
        map.put("roles", Collections.singletonList("管理员"));
        Admin admin = adminService.getById(loginUserUser.getId());
        admin.setToken(jwt);
        adminService.updateById(admin);
        return ResultBuilder.success(map, ResultCode.LOGIN_SUCCESS);
    }

    @Override
    public HttpResponse refreshToken(String refreshToken) {
        Claims claims = JwtUtil.parseJWT(refreshToken);
        if (Objects.isNull(claims)||JwtUtil.isTokenExpired(refreshToken)){
            throw new RuntimeException("用户未登录");
        }
        String role = claims.getSubject();
        String userId = claims.getId();
        Admin admin = adminService.getById(userId);
        if (Objects.isNull(admin)||admin.getToken()==null){
            throw new RuntimeException("用户未登录");
        }
        String jwt = JwtUtil.createJWT(userId+"",role, (long) (60*60*1000));
        String refJwt = JwtUtil.createJWT(userId+"",role, (long) ((30*60*1000)));
        DateTime dateTime = DateUtil.offsetMinute(new Date(), 60);
        String format = DateUtil.format(dateTime, "yyyy/MM/dd HH:mm:ss");
        Map<String, Object> map = new HashMap<>();
        map.put("accessToken",jwt);
        map.put("refreshToken",refJwt);
        map.put("expires",format);
        return ResultBuilder.success(map, ResultCode.LOGIN_SUCCESS);
    }


}
