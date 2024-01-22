package com.pn.news.utils

object FileUtil {
    fun suffix(data: String): String {
        val indexOf = data.lastIndexOf(".")  //找到.所在的索引
        return if (indexOf != -1) data.substring(indexOf) else ".u"  //截取.之后的字符串
    }
}
