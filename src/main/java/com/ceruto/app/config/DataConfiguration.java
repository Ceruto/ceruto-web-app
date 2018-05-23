package com.ceruto.app.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.ceruto.app.mapper")
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass=true, exposeProxy=true)
public class DataConfiguration {

    @Autowired
    private MySQLProperties mySQLProperties;

    @Bean
    public ServletRegistrationBean druidServlet() {
        return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    
    
    /**
     * 代替spring本身的数据库连接池。
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个。
     * @return
     */
    @Bean
    public DataSource druidDataSource()throws Exception {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(mySQLProperties.getDriver());
        druidDataSource.setUrl(mySQLProperties.getUrl());
        druidDataSource.setUsername(mySQLProperties.getUsername());
        druidDataSource.setPassword(mySQLProperties.getPassword());

        //其他参数
        druidDataSource.setInitialSize(mySQLProperties.getInitialSize());
        druidDataSource.setMinIdle(mySQLProperties.getMinIdle());
        druidDataSource.setMaxActive(mySQLProperties.getMaxActive());
        druidDataSource.setMaxWait(mySQLProperties.getMaxWait());
        druidDataSource.setTimeBetweenEvictionRunsMillis(mySQLProperties.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(mySQLProperties.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(mySQLProperties.getValidationQuery());
        druidDataSource.setTestWhileIdle(mySQLProperties.isTestWhileIdle());
        druidDataSource.setTestOnBorrow(mySQLProperties.isTestOnBorrow());
        druidDataSource.setTestOnReturn(mySQLProperties.isTestOnReturn());
        druidDataSource.setPoolPreparedStatements(mySQLProperties.isPoolPreparedStatements());
        druidDataSource.setFilters(mySQLProperties.getFilters());
        return druidDataSource;

    }

}
