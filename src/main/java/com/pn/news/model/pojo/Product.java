package com.pn.news.model.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;
@Data
public class Product extends Common {
    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空")
    @Length(min = 1, max = 100, message = "标题长度必须为1~100位")
    private String title;

    /**
     * 封面
     * <p>
     * 多张图片地址以英文逗号分割存储
     */
    @NotBlank(message = "封面不能为空")
    private String icon;

    /**
     * 价格
     */
    @NotNull(message = "价格不能为空")
    private int price;

    /**
     * 亮点
     * <p>
     * 真实项目中，如果有特别需求，也可以实现为列表
     * 我们这里主要讲解商城核心逻辑，所以这里就简单实现了
     */
    @NotBlank(message = "亮点不能为空")
    private String highlight;

    /**
     * 详情
     * <p>
     * HTML格式化富文本
     */
    @NotBlank(message = "详情不能为空")
    private String detail;

    /**
     * 用户id
     */
    private String userId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String stock;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String spec;

    @TableField(exist = false)
    private List<Stock> stocks;

    @TableField(exist = false)
    private List<Spec> specs;

    public String[] getIcons() {
        if (icon != null) {
            return icon.split(",");
        }
        return null;
    }



}
