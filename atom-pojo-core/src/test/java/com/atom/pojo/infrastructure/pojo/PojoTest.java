package com.atom.pojo.infrastructure.pojo;

import com.atom.pojo.domain.model.PojoRepository;
import com.atom.pojo.infrastructure.PojoBaseTest;
import com.atom.pojo.model.Pojo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBean;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Pojo Test
 * <p>
 * Created by Atom on 2017/4/8.
 */
@DataSet("/database/dataset/pojo.xml")
@Rollback(value = false)
public class PojoTest extends PojoBaseTest {

    @SpringBean("pojoRepositoryImpl")
    private PojoRepository pojoRepository;

    @Test
    public void saveTest() {

        Pojo pojo = new Pojo();
        pojo.setAccountId(1L);
        pojo.setName("test");
        pojo.setStatus(0);
        pojo.setCreatedAt(LocalDateTime.now());
        pojo.setUpdatedAt(LocalDateTime.now());

        Pojo dbPojo = pojoRepository.save(pojo);

        Assert.assertNotNull(dbPojo);
    }

    @Test
    public void findTest() {

        Pojo dbPojo = pojoRepository.findOne(1L);

        assertThat(dbPojo).isNotNull();
    }

}
