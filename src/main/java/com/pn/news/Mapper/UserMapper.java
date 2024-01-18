package com.pn.news.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pn.news.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
