
DROP TABLE IF EXISTS pojo;
CREATE TABLE pojo (
  id            BIGINT(20)      NOT     NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
  account_id    BIGINT(20)      NOT     NULL COMMENT '账户ID',
  name          VARCHAR(64)     NOT     NULL COMMENT '名字',
  status        TINYINT(4)      DEFAULT NULL COMMENT '状态',
  created_at    DATETIME        DEFAULT NULL COMMENT '创建时间',
  updated_at    DATETIME        DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
