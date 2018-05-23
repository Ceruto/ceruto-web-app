package com.ceruto.app.service.impl;

import com.ceruto.app.mapper.AppUserMapper;
import com.ceruto.app.model.AppUser;
import com.ceruto.app.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserMapper appUserMapper;

    @Override
    public AppUser getAppUserInfo(String userName, String userPassword) {
        return appUserMapper.getAppUserInfo(userName,userPassword);
    }
}
