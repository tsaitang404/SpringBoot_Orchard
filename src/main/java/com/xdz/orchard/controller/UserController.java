package com.xdz.orchard.controller;

import com.xdz.orchard.entity.Admin;
import com.xdz.orchard.service.AdminService;
import com.xdz.orchard.service.LoginService;
import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private LoginService loginService;
    @Resource
    private AdminService adminService;

    @PostMapping("/login")
    public HttpResponse login(@RequestBody Admin admin){

        return loginService.login(admin);
    }
    @PutMapping("/update")
    public HttpResponse update(@RequestBody Admin user) {
        Admin admin = adminService.getById(user.getId());
        if (!user.getPassword().equals(admin.getPassword())) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
        }
        adminService.updateById(user);
        return ResultBuilder.successNoData(ResultCode.UPDATE_SUCCESS);
    }
    /**
     *
     * @param map
     * @return
     */
    @PostMapping("/refreshToken")
    public HttpResponse refreshToken(@RequestBody Map<String,String> map){
        String refreshToken = map.get("refreshToken");
        return loginService.refreshToken(refreshToken);
    }
}
