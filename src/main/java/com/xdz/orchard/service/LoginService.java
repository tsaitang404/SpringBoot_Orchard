package com.xdz.orchard.service;


import com.xdz.orchard.entity.Admin;
import com.xdz.orchard.utils.HttpResponse;

public interface LoginService {
    HttpResponse login(Admin user);

    HttpResponse refreshToken(String refreshToken);
}
