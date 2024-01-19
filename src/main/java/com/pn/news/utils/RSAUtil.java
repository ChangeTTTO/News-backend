package com.pn.news.utils;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

import java.util.Arrays;

/**
 * md5工具类
 */
public class RSAUtil {
    public static String encrypt(String data) {
        RSA rsa = SecureUtil.rsa();
        rsa.getPublicKey();
        rsa.getPrivateKey();
        //使用公钥进行加密
        return Arrays.toString(rsa.encrypt(data + Constant.SALT, CharsetUtil.CHARSET_UTF_8, KeyType.PublicKey));
    }
}

