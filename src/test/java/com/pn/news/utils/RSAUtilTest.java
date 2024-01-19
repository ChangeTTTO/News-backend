package com.pn.news.utils;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.crypto.digest.MD5;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RSAUtilTest {

    @Test
    void encrypt() {
        RSA rsa = SecureUtil.rsa();
        rsa.getPublicKey();
        rsa.getPrivateKey();
        //使用公钥进行加密
        System.out.println(Arrays.toString(rsa.encrypt(Constant.SALT, CharsetUtil.CHARSET_UTF_8, KeyType.PublicKey)));
    }
}