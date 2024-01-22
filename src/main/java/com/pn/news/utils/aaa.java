package com.pn.news.utils;

import cn.hutool.crypto.asymmetric.RSA;

public class aaa {
    private static aaa instance;
    public RSA rsa;
    private aaa() {
        // 私有构造函数，防止外部实例化
        rsa = new RSA();

    }
    public static synchronized aaa getInstance() {
        // 使用懒汉式实例化，确保只有在需要时才创建实例
        if (instance == null) {
            instance = new aaa();
        }
        return instance;
    }
}
