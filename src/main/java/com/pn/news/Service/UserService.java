package com.pn.news.Service;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pn.news.Mapper.UserMapper;
import com.pn.news.model.pojo.User;
import com.pn.news.model.response.loginResponse;
import com.pn.news.utils.RSAUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;
    /**
    *登录
    */
    public loginResponse login(User user) {
        if (!StrUtil.isAllBlank(user.getPhone(),user.getPassword())){
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone,user.getPhone());
            User one = userMapper.selectOne(queryWrapper);
            //判断用户是否存在
            if (one==null){
                throw new RuntimeException();
            }

            //判断密码是否正确
            if (!RSAUtil.getInstance().rsa.decryptStr(one.getPassword(),KeyType.PrivateKey).equals(user.getPassword())){
                throw new RuntimeException();
            }
        }
        //标记已登录
        StpUtil.login(user.getId());
        return new loginResponse(user.getId(),StpUtil.getTokenValue());
    }
}
