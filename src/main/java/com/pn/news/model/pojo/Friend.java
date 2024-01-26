package com.pn.news.model.pojo;

import lombok.Data;

/**
 * 好友模型
 */
@Data
public class Friend extends Common {
    /**
     * 当前用户id
     */
    private Long i;

    /**
     * 对方id
     */
    private Long you;
}

