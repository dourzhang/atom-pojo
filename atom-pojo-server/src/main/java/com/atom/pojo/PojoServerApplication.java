package com.atom.pojo;

import org.mvnsearch.spring.boot.dubbo.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Pojo Server Application
 * <p>
 * Created by Atom on 2017/4/9.
 */
@SpringBootApplication
@EnableDubboConfiguration("com.atom.pojo.provider")
@ComponentScan("com.atom.pojo")
@EnableDiscoveryClient
@MapperScan("com.atom.pojo.domain.model.mapper")
public class PojoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PojoServerApplication.class, args);
    }
}
