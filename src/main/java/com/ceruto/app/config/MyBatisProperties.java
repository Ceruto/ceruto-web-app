package com.ceruto.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Ceruto on 2017/3/29.
 */
@ConfigurationProperties(prefix="mybatis")
@Component
@Data
public class MyBatisProperties {

    private String typeAliasesPackage = "";

    private String mapperLocations = "";
}


