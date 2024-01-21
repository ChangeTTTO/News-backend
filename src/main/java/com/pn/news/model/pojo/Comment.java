package com.pn.news.model.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 评论模型
 */
@Data
public class Comment extends Common {
    /**
     * 内容
     */
    @NotBlank(message = "评论内容不能为空")
    @Length(min = 1, max = 140)
    private String content;

    /**
     * 被回复评论id
     */
    private String parentId;

    /**
     * 被回复评论
     */
    @TableField(exist = false)
    private Comment parent;

    /**
     * 文章id
     */
    private String articleId;

    /**
     * 文章对象
     */
    @TableField(exist = false)
    private Content article;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户
     */
    @TableField(exist = false)
    private User user;

    /**
     * 点赞数
     */
    private long likesCount;

    /**
     * 评论数
     */
    private long commentsCount;

    /**
     * 点赞关系id
     * <p>
     * 有值表示点赞了
     */
    @TableField(exist = false)
    private String likeId;

    /**
     * 图片列表
     * 逗号分割
     */
    private String media;


}