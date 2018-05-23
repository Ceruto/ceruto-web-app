package com.ceruto.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 数据库配置类。
 * Created by Ceruto on 2017/3/29.
 */
@Component
@ConfigurationProperties(prefix="spring.datasource")
@Data
public class MySQLProperties {

    private String driver = "" ;

    private String url = "";

    private String username = "";

    private String password = "";

    private int initialSize;

    private int minIdle;

    private int maxActive;

    private int maxWait;

    private int timeBetweenEvictionRunsMillis;

    private int minEvictableIdleTimeMillis;

    private String validationQuery;

    private boolean testWhileIdle;

    private boolean testOnBorrow;

    private boolean testOnReturn;

    private boolean poolPreparedStatements;

    private String filters;


}
