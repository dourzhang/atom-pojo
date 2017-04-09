package com.atom.pojo.domain.model.mapper;

import com.atom.pojo.model.Pojo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.mapping.StatementType;

/**
 * Pojo Mapper
 * <p>
 * Created by Atom on 2017/4/8.
 */
public interface PojoMapper {

    /**
     * 插入
     *
     * @param pojo Simple Object
     * @return ID
     */
    @Insert("insert into pojo(account_id,name,status,created_at,updated_at) values (#{pojo.accountId},#{pojo.name},#{pojo.status},#{pojo.createdAt},#{pojo.updatedAt})")
    @SelectKey(before = false, keyProperty = "pojo.id", resultType = Long.class, statementType = StatementType.STATEMENT, statement = "SELECT LAST_INSERT_ID() AS id")
    Long insert(@Param("pojo") Pojo pojo);

    /**
     * 主键查询
     *
     * @param id ID
     * @return Simple Object
     */
    @Select("select id,account_id as accountId,name,status,created_at as createdAt,updated_at as updatedAt from pojo where id=#{id}")
    Pojo selectOne(@Param("id") Long id);
}
