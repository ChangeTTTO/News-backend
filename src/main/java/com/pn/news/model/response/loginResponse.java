package com.pn.news.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录后，返回用户token模型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class loginResponse {
 private Long userId;
 private String token;
}
