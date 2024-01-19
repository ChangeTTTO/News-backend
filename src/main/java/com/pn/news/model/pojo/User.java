package com.pn.news.model.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

@TableName("user")
public class User {

    /**
     * 主键ID
      */
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 昵称
     */
   /* @NotBlank(message = "昵称不能为空")
    @Length(min = 1, max = 15, message = "昵称长度必须为1~15位")*/
    private String nickname;

    /**
     * 头像
     */
    private String icon;

    /**
     * 描述
     */
    private String detail;

    /**
     * 性别
     * <p>
     * 不能为空
     * 默认为0：保密；1：男；2：女
     */
    private Integer gender;

    /**
     * 出生日志
     * <p>
     * 格式为yyyy-MM-dd格式
     * 真实项目中建议使用日期格式
     */
    private String birthday;

    /**
     * 手机号
     * <p>
     * 不可以为空
     * 手机号正则表达式
     * 移动：134 135 136 137 138 139 147 150 151 152 157 158 159 178 182 183 184 187 188 198
     * 联通：130 131 132 145 155 156 166 171 175 176 185 186
     * 电信：133 149 153 173 177 180 181 189 199
     * 虚拟运营商: 170
     */
    /*@NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$", message = "手机号格式不正确")*/
    private String phone;

    /**
     * 邮箱
     */
   /* @NotBlank(message = "邮箱不能为空")
    @Pattern(regexp = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?", message = "邮箱格式不正确")*/
    private String email;

    /**
     * 密码
     * 进行脱敏处理
     */
    @NotBlank(message = "密码不能为空")
   // @Length(min = 6, max = 20, message = "密码长度必须为6~20位")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)  //脱敏，不返回给前端
    private String password;

    /**
     * 第三方登录QQId加密后值，aes算法加密
     */
    private String qqId;

    /**
     * 第三方登录微信id加密后值，aes算法加密
     */
//    @TableField("wexin_id")
    private String wechatId;

    /**
     * 状态
     * 1：正常；0：禁用
     */
    private Boolean status;

    /**
     * 内部备注，后台使用
     */
    private String note;

    /**
     * 创建日期
     * <p>
     * 数据库自动更新
     */
    private Date createdAt;

    /**
     * 更新日期
     */
    private Date updatedAt;

    /**
     * 登录平台
     * 取值constant中的平台
     */
    @TableField(exist = false)
    private byte platform;

    /**
     * 验证码
     */
    @TableField(exist = false)
    private String code;

    /**
     * 邮箱确认标记
     * 默认0:没有验证
     * 1:验证了
     * 其他值：验证中
     */
    private String emailConfirm;

    /**
     * 是否禁用了
     * @return
     */
    @JsonIgnore //前后端交互当作没有这个字段，数据库也不存在
    public boolean isDisable() {
        return !status;
    }

}