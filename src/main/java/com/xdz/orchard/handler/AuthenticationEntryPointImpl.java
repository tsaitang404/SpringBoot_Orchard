package com.xdz.orchard.handler;

import com.alibaba.fastjson.JSON;
import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import com.xdz.orchard.utils.WebUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)  {
        String message = authException.getMessage();
        HttpResponse result = null;
        if (message.equals("用户未登录")){
            result  = ResultBuilder.faile(ResultCode.AGGINLOGIN);
        }else if (message.equals("用户不存在")){
            result  = ResultBuilder.faile(ResultCode.USER_NOT_EXIST);
        }else if (message.equals("用户名为空")){
            result  = ResultBuilder.faile(ResultCode.USER_NOT_EXIST);
        }else if (message.equals("账号已被禁用")){
            result  = ResultBuilder.faile(ResultCode.USER_ACCOUNT_FORBIDDEN);
        } else if ("Full authentication is required to access this resource".equals(message)) {
            result  = ResultBuilder.faile(ResultCode.AGGINLOGIN);
        } else {
            result = new HttpResponse();
            result.setMessage(message);
            result.setCode(60001);
        }
        String json = JSON.toJSONString(result);
        //处理异常
        WebUtils.renderString(response,json);
    }
}
