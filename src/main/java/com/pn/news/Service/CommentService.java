package com.pn.news.Service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pn.news.Mapper.CommentMapper;
import com.pn.news.Mapper.CommonMapper;
import com.pn.news.model.pojo.Comment;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * 评论服务
 */
@Service
public class CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private CommonMapper commonMapper;


    public void create(Comment data) {
        if (commentMapper.insert(data)==1){
            commonMapper.incrementCount("content",data.getArticleId(),"comments_count");

            if (StringUtils.isNotBlank(data.getParentId())){
                commonMapper.incrementCount("comment",data.getParentId(),"comments_count");
            }
        }else {
            throw new RuntimeException();
        }

    }

    public IPage<Comment> findAll(int page, int size, int order, String userId, String articleId, String parentId) {
        //查询条件
        Map<String, String> conditions = new HashMap<>();
        if (StringUtils.isNotBlank(userId)) {
            conditions.put("c.user_id", String.format("= '%s'", userId));
        }

        if (StringUtils.isNotBlank(articleId)) {
            conditions.put("c.article_id", String.format("= '%s'", articleId));
        }

        if (StringUtils.isNotBlank(parentId)) {
            conditions.put("c.parent_id", String.format("= '%s'", parentId));
        } else {
            conditions.put("c.parent_id", "is null");
        }

        //排序
        String orderField;
        if (order == 10) {
            //最热

            //按照点赞数倒序
            orderField = "c.likes_count";
        } else {
            //最新

            //按照创建时间倒序
            orderField = "c.created_at";
        }

        //查询数据
        IPage<Comment> r = commentMapper.findAll(new Page<Comment>(page, size), conditions, orderField, "desc");

        return r;
    }
    }
