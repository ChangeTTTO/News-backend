package com.pn.news.model.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;


//@Document(indexName = "content")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Content extends Common{
    //    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;

    @NotBlank(message = "内容不能为空")
    @Length(min = 1, max = 1000, message = "内容长度必须为1~1000位")
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String content;

    //    @Field(type = FieldType.Keyword)
    private String icon; //封面
    private String uri;

    private String userId;//创建人

    private String province;

    /**
     * 视频时长
     * <p>
     * 单位秒
     */
    private int duration;

    /**
     * 视频宽
     */
    private int width;

    /**
     * 视频高
     */
    private int height;

    @TableField(exist = false)
    private User user;

    /**
     * 类型
     * 不传递：0：文章，10：视频
     */
    private int style;

    private long commentsCount;
    private long likesCount;
    private long clicksCount;


//    @TableField(exist = false)
//    private List<Comment> comments;

    @TableField(exist = false)
    private String likeId;

    public String[] getIcons() {
        if (icon != null) {
            return icon.split(",");
        }
        return null;
    }


    }

