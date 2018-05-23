package com.ceruto.app.mapper;

import com.ceruto.app.model.AppUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserMapper {
    public AppUser getAppUserInfo(@Param("login_name") String userName,
                                  @Param("password") String userPassword) ;
}
