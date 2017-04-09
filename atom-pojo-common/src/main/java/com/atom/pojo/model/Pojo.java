package com.atom.pojo.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * POJO
 * <p>
 * Created by Atom on 2017/4/8.
 */

@Data
public class Pojo implements Serializable {

    /**
     * ID
     */
    private Long id;
    /**
     * 账户ID
     */
    private Long accountId;
    /**
     * 名字
     */
    private String name;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
}
