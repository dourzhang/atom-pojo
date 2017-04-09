package com.atom.pojo.infrastructure.model;

import com.atom.pojo.domain.model.PojoRepository;
import com.atom.pojo.domain.model.mapper.PojoMapper;
import com.atom.pojo.model.Pojo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * PojoRepository Impl
 * <p>
 * Created by Atom on 2017/4/8.
 */
@Repository
public class PojoRepositoryImpl implements PojoRepository {

    @Resource
    private PojoMapper pojoMapper;

    @Override
    public Pojo save(Pojo pojo) {
        pojoMapper.insert(pojo);
        return pojo;
    }

    @Override
    public Pojo findOne(Long id) {
        return pojoMapper.selectOne(id);
    }
}
