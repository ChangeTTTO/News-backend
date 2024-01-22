package com.pn.news.model.pojo;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 
 * @TableName address
 */
@TableName(value ="address")
@Data
public class Address implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    @Length(min = 1, max = 3, message = "姓名长度必须为1~3位")
    private String name;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 省
     */
    private String province;

    /**
     * 省编码
     */
    private String provinceCode;

    /**
     * 市
     */
    private String city;

    /**
     * 市编码
     */
    private String cityCode;

    /**
     * 区
     */
    private String area;

    /**
     * 区编码
     */
    private String areaCode;

    /**
     * 剩余的地址部分
     */
    private String detail;

    /**
     * 是否是默认地址
     */

    private Integer defaultAddress;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public boolean idDefault() {
        return defaultAddress== 10;
    }
}