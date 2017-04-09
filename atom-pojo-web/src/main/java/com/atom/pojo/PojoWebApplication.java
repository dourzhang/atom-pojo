package com.atom.pojo;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Pojo Web Application
 * <p>
 * Created by Atom on 2017/4/9.
 */
@SpringBootApplication
@EnableAsync
@EnableJSONDoc
public class PojoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PojoWebApplication.class, args);
    }

}
