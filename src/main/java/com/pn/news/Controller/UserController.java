package com.pn.news.Controller;

import com.pn.news.Mapper.UserMapper;
import com.pn.news.model.User;
import com.pn.news.utils.R;
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
     * 通过id查询单个用户
     * @return user
     */
    @GetMapping("/{id}")
    @Operation(summary = "通过id查询单个用户")
    public User getUser(@PathVariable("id") String id){

        return userMapper.selectById(id);
    }

    /**
     * 注册
     * @param user
     * @return user
     */
    @PostMapping("/register")
    @Operation(summary = "注册")
    public Object register(@RequestBody User user){
        return userMapper.insert(user);
    }
    /**
     * 返回用户列表
     */
    @GetMapping("/list")
    @Operation(summary = "查询所有用户")
    public Object getAllUser(){
        List<User> users = userMapper.selectList(null);
        return R.warp(users);
    }
}
