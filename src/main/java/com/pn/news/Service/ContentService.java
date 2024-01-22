package com.pn.news.Service;

import com.pn.news.Mapper.ContentMapper;
import com.pn.news.Mapper.UserMapper;
import com.pn.news.model.pojo.Content;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {
    @Resource
    private ContentMapper contentMapper;
    @Resource
    private UserMapper userMapper;
    public List<Content> getContent(String query, String last, String userId, int size, String style) {
        return contentMapper.findAll(null,last, userId, size, style);
    }

    public Content showDetail(String id) {
        Content content = contentMapper.selectById(id);
        if (content!=null){
            //找到用户
            content.setUser(userMapper.selectById(content.getUserId()));
        }
        return content;
    }

    public void create(Content data) {
        contentMapper.insert(data);
    }
}
