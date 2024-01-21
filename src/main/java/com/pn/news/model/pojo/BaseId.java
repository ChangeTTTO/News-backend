package com.pn.news.model.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用id模型
 */
@Data
public class BaseId implements Serializable {
    /**
     * 数据id
     * 数据库是bigint，代码中之所以写字符串，是为了处理更通用
     */
    private String id;


}
