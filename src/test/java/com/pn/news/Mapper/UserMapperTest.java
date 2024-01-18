package com.pn.news.Mapper;

import com.pn.news.model.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;
    @Test
    public void s() {
        User user = new User();
        user.setGender(1);
        userMapper.insert(user);
        List<User> users = userMapper.selectList(null);
        System.out.println("你说话啊"+users.size());
    }
}
