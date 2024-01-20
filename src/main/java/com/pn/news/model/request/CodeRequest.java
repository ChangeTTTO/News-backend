package com.pn.news.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 验证码请求参数
 * <p>
 * 也可以复用User模型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeRequest {
    private String phone;
    private String email;

    /**
     * 如果发送频繁了，也可以要求发送验证码时，传递图形验证码
     */
    private String code;

}
