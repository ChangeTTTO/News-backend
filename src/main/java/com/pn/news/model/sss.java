package com.pn.news.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class sss {
    /**
     * 昵称
     */
    private String nickname;

    /**
     * 密码
     * 脱敏处理
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    /**
     * qq登录加密后值
     */
    private String qqId;
    /**
     * 微信ID
     */
    private String wechatId;
    /**
     * 性别，不能为空
     * 默认为0:保密，1:男,2:女
     */
    private int gender;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 描述
     */
    private String describe;

    /**
     * 生日
     * yyyy-MM-dd
     */
    private String birthday;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户状态
     */
    private boolean status;

    /**
     * 备注，内部使用
     */
    private String note;

    /**
     * 是否禁用了
     */
    @JsonIgnore
    public boolean isDisable(){return !status;}
}
