package com.ceruto.app.service;

import com.ceruto.app.model.AppUser;

public interface AppUserService {

    public AppUser getAppUserInfo(String userName, String userPassword);
}
