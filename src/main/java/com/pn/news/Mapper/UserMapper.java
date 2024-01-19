package com.pn.news.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pn.news.model.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
