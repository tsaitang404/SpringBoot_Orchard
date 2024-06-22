package com.xdz.orchard.exception;


import com.xdz.orchard.utils.HttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public HttpResponse exceptionHandler(Exception e){
        HttpResponse<Object> response = new HttpResponse<>();
        response.setCode(50002);
        if ("用户未登录".equals(e.getMessage())){
            response.setCode(50001);
        }
        response.setMessage(e.getMessage());
        return response;
    }
 }
