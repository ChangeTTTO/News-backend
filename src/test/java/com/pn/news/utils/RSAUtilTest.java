package com.pn.news.utils;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
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
    @Test
    void instance(){
        RSAUtil A = RSAUtil.INSTANCE;
        RSA a = A.getRsa();
        RSAUtil B = RSAUtil.INSTANCE;
        RSA b = B.getRsa();
        System.out.println(a);
        System.out.println(b);
        RSA c = new RSA();
        RSA d = new RSA();
        System.out.println(c);
        System.out.println(d);
    }
    @Test
    void hash(){
        String s1 = "bac";
        String s2 = new String("abc");

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}