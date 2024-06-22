package com.xdz.orchard.utils;

public class ResultBuilder {
    //成功，不返回具体数据
    public static <T> HttpResponse<T> successNoData(ResultCode code){
        HttpResponse<T> result = new HttpResponse<T>();
        result.setCode(code.getCode());
        result.setMessage(code.getMessage());
        return result;
    }
    //成功，返回数据
    public static <T> HttpResponse<T> success(T t, ResultCode code){
        HttpResponse<T> result = new HttpResponse<T>();
        result.setCode(code.getCode());
        result.setMessage(code.getMessage());
        result.setData(t);
        return result;
    }

    //失败，返回失败信息
    public static <T> HttpResponse<T> faile(ResultCode code){
        HttpResponse<T> result = new HttpResponse<T>();
        result.setCode(code.getCode());
        result.setMessage(code.getMessage());
        return result;
    }
}