package com.pn.news.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pn.news.model.pojo.Comment;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 评论映射
 */
@Repository
public interface CommentMapper extends BaseMapper<Comment> {
    /**
     * 评论列表
     *
     * @param page       分页模型
     * @param conditions 查询条件
     * @param orderField 排序字段
     * @param order      倒序还是正序
     * @return
     */
    IPage<Comment> findAll(Page<Comment> page, Map<String, String> conditions, String orderField, String order);
}
