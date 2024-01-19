package com.pn.news.Controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pn.news.Mapper.UserMapper;
import com.pn.news.model.pojo.User;
import com.pn.news.utils.Constant;
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
        //判断参数是否完整
        if (StrUtil.hasBlank(user.getNickname(),user.getPhone(),user.getEmail(),user.getPassword())){
            return R.failed(Constant.ERROR_ARGUMENT,Constant.ERROR_ARGUMENT_MESSAGE);
        }
        //判断参数是否已存在于数据库中
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone,user.getPhone()).or().eq(User::getEmail,user.getEmail());
        if (userMapper.exists(queryWrapper)){
            return R.failed(Constant.ERROR_DATA_EXIST,Constant.ERROR_DATA_EXIST_MESSAGE);
        }
        userMapper.insert(user);
        //返回用户id
        return R.warp(user.getId());
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
