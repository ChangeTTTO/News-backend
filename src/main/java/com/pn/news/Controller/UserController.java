package com.pn.news.Controller;

import com.pn.news.Mapper.UserMapper;
import com.pn.news.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name="用户接口")
@RequestMapping("/user")
public class UserController {
    @Resource
    UserMapper userMapper;

    /**
     * 查询单个用户
     * @return user
     */
    @GetMapping
    @Operation(summary = "查询单个用户")
    public User getUser(){
        User user = new User();
        user.setNickname("小明");
        return user;
    }

    /**
     * 注册
     * @param user
     * @return user
     */
    @PostMapping("/register")
    public Object register(@RequestBody User user){
        return userMapper.insert(user);
    }
    /**
     * 返回用户列表
     */
    @GetMapping("/list")
    public List<User> getAllUser(){
        return userMapper.selectList(null);
    }
}
