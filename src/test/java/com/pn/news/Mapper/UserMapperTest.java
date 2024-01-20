package com.pn.news.Mapper;

import cn.hutool.core.util.CharsetUtil;
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

        String s = RSAUtil.getInstance().rsa.encryptHex("陶纪禄", CharsetUtil.CHARSET_UTF_8, KeyType.PublicKey);
        System.out.println("加密后等于："+s);
        /*RSAUtil.getInstance().rsa.decryptStr("陶ji")*/

    }
}
