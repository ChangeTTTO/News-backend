package com.pn.news.Controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pn.news.Exception.ArgumentException;
import com.pn.news.Exception.CommonException;
import com.pn.news.Mapper.UserMapper;
import com.pn.news.Service.UserService;
import com.pn.news.model.pojo.User;
import com.pn.news.utils.Constant;
import com.pn.news.utils.R;
import com.pn.news.utils.RSAUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@Tag(name="用户接口")
@RequestMapping("/user")
public class UserController {
    @Resource
    UserMapper userMapper;
    @Resource
    UserService userService;

    /**
     * 通过id查询单个用户
     */
    @GetMapping("/{id}")
    @Operation(summary = "通过id查询单个用户")
    public User getUser(@PathVariable("id") String id){
        User user = userMapper.selectById(id);
        if (user==null){
            throw new RuntimeException();
        }
        return user;
    }

    /**
     * 注册
     */
    @PostMapping("/register")
    @Operation(summary = "注册")
    public Object register(@Valid @RequestBody User user, BindingResult bindingResult){
        RSA rsa = new RSA();
        //判断参数是否完整
        if (bindingResult.hasErrors()){
            throw ArgumentException.getInstance();
        }
        //判断参数是否已存在于数据库中
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone,user.getPhone()).or().eq(User::getEmail,user.getEmail());
        if (userMapper.exists(queryWrapper)){
            throw CommonException.getInstance(Constant.ERROR_DATA_EXIST,Constant.ERROR_DATA_EXIST_MESSAGE);
        }
        user.setPassword(RSAUtil.INSTANCE.getRsa().encryptHex(user.getPassword(),KeyType.PublicKey));
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
    /**
    *登录
    */
    @PostMapping("/login")
    public Object login(@RequestBody User user){
        if (user.getPlatform()!=Constant.ANDROID &&
        user.getPlatform()!=Constant.IOS &&
        user.getPlatform()!=Constant.WEB
    ){
        throw ArgumentException.getInstance();
        }
        return R.warp(userService.login(user));
    }
    /**
    *退出登录
    */
    @DeleteMapping("/{platform}")
    public Object outLogin(@PathVariable String id){
        StpUtil.checkLogin();
        StpUtil.logout(StpUtil.getLoginIdAsString(),id);
        return R.warp();
    }
    @PatchMapping("/{id}")
    public Object update(@PathVariable String id,@RequestBody User user){
         StpUtil.checkLogin();
         return R.warp(userService.update(id,user));
    }
}
