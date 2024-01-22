package com.pn.news.utils

import cn.hutool.crypto.asymmetric.RSA

object RSAUtil {
    val rsa: RSA by lazy { RSA() }
}
