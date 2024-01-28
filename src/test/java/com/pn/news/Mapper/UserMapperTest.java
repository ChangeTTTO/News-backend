package com.pn.news.Mapper;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.pn.news.model.pojo.User;
import com.pn.news.utils.RSAUtil;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;
    @Test
            public void s(){

        String Code = Arrays.toString(NumberUtil.generateRandomNumber(100000, 999999, 1));
        System.out.println("生成的验证码是:"+Code);

    }
}
