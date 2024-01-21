package com.pn.news.Service;

import com.pn.news.Mapper.ContentMapper;
import com.pn.news.model.pojo.Content;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {
    @Resource
    private ContentMapper contentMapper;
    public List<Content> getContent(String query, String last, String userId, int size, String style) {
        return contentMapper.findAll(null,last, userId, size, style);
    }
}
