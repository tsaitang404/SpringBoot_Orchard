package com.xdz.orchard.auth;




import com.xdz.orchard.entity.Admin;
import com.xdz.orchard.entity.LoginUser;
import com.xdz.orchard.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken ) authentication;
        Admin user = (Admin) token.getPrincipal();
        LoginUser userDetails = null;

        if (Objects.nonNull(user.getUsername())&&Objects.nonNull(user.getPassword())){
             userDetails = (LoginUser) userDetailsService.loadUserByUsername(user.getUsername());
            if (Objects.isNull(userDetails)){
                throw new UsernameNotFoundException("用户不存在");
            }else if (!userDetails.isEnabled()){
                throw new BadCredentialsException("账号已被禁用");
            }
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (!encoder.matches(user.getPassword(),userDetails.getPassword())){
                throw new BadCredentialsException("密码错误");
            }
        }
        return new UsernamePasswordAuthenticationToken(userDetails,userDetails.getPassword(),userDetails.getAuthorities());
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
