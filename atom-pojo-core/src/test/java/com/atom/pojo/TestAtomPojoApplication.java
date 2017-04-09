package com.atom.pojo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * AtomPojoTest Application
 * <p>
 * Created by Atom on 2017/4/8.
 */
@SpringBootApplication
@ImportResource("/atom/pojo/appContext-domain.xml")
@PropertySource("/application.properties")
@MapperScan("com.atom.pojo.domain.model.mapper")
public class TestAtomPojoApplication {

}
