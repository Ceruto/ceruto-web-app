package com.ceruto.app.controller;


import com.ceruto.app.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class AppLoginController {

    @Autowired
    private AppUserService appUserService;

    /**
     * demo登录请求
     */
    @RequestMapping(value = "/demo/{name}/{password}",method = RequestMethod.POST)
    public Object dkLogin(@PathVariable(value = "name") String name,
                          @PathVariable(value = "password") String password){
        return appUserService.getAppUserInfo(name,password);
    }
}
