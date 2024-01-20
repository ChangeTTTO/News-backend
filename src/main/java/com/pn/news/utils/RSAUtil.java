package com.pn.news.utils;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;

/**
 * md5工具类
 */
import java.util.Arrays;

public class RSAUtil {
    private static RSAUtil instance;
    public RSA rsa;
    private RSAUtil() {
        // 私有构造函数，防止外部实例化
        rsa = new RSA();

    }
    public static synchronized RSAUtil getInstance() {
        // 使用懒汉式实例化，确保只有在需要时才创建实例
        if (instance == null) {
            instance = new RSAUtil();
        }
        return instance;
    }

}


