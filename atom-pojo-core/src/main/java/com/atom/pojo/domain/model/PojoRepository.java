package com.atom.pojo.domain.model;

import com.atom.pojo.model.Pojo;

/**
 * Pojo Repository
 * <p>
 * Created by Atom on 2017/4/8.
 */
public interface PojoRepository {


    /**
     * 插入
     *
     * @param pojo Simple Object
     * @return ID
     */
    Pojo save(Pojo pojo);

    /**
     * 主键查询
     *
     * @param id ID
     * @return Simple Object
     */
    Pojo findOne(Long id);
}
