package com.xdz.orchard.filter;


import com.xdz.orchard.entity.Admin;
import com.xdz.orchard.entity.LoginUser;
import com.xdz.orchard.service.AdminService;
import com.xdz.orchard.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Resource
    AdminService adminService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取Token
        String token = request.getHeader("Authorization");


        if (!StringUtils.hasText(token)) {
            //放行
            filterChain.doFilter(request, response);
            return;
        }

        Claims claims = JwtUtil.parseJWT(token);

        if (Objects.isNull(claims)||JwtUtil.isTokenExpired(token)){
            throw new RuntimeException("用户未登录");
        }

        String id = claims.getSubject();
        Admin loginUser = adminService.getById(id);
        if (Objects.isNull(loginUser)||loginUser.getToken()==null){
            throw new RuntimeException("用户未登录");
        }
        //存入SecurityHolder
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(new LoginUser(loginUser),null, AuthorityUtils.commaSeparatedStringToAuthorityList("管理员"));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //放行
        filterChain.doFilter(request, response);
    }
}
