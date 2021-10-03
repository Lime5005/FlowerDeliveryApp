package com.lime.flowerdeliver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
//
//@Configuration
//public class MyConfig {
//
//    @Bean
//    @ConfigurationProperties(prefix = "com.lime.datasource")
//    public DataSource getDatasource() {
//        DataSourceBuilder dsb = DataSourceBuilder.create();
//        dsb.url("jdbc:mysql://localhost:3306/flowerdb");
//        return dsb.build();
//    }
//
//}
