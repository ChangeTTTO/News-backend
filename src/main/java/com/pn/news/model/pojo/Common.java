package com.pn.news.model.pojo;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * 与业务相关的通用模型
 */
@Data
public class Common extends BaseId {

    /**
     * 创建时间
     * 通过MySQL机制去更新
     * 导入sql包
     */
    @TableField(insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private Date createdAt;

    /**
     * 更新时间
     */
    @TableField(insertStrategy = FieldStrategy.NEVER, updateStrategy = FieldStrategy.NEVER)
    private Date updatedAt;

}
