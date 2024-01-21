package com.pn.news.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pn.news.model.pojo.Content;
import com.pn.news.model.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentMapper extends BaseMapper<Content> {
    List<Content> findAll(String query, String last, String userId, int size, String style);
}
