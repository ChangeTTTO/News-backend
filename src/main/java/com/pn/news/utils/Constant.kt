package com.pn.news.utils
object Constant {
    /**
     * 未知错误
     */
    const val ERROR_UNKNOWN = 20

    const val ERROR_UNKNOWN_MESSAGE = "服务端未知错误"

    /**
     * 参数错误
     */
    const val ERROR_ARGUMENT = 30
    const val ERROR_ARGUMENT_MESSAGE = "请求参数错误"

    /**
     * 数据已经存在错误
     */
    const val ERROR_DATA_EXIST = 1550
    const val ERROR_DATA_EXIST_MESSAGE = "数据已经存在"

    /**
     * 默认编码
     */
    const val CHARSET = "UTF-8"
    const val SALT = "PN"

    /**
     * android
     */
    const val ANDROID = 0

    /**
     * ios
     */
    const val IOS = 10

    /**
     * web
     */
    const val WEB = 20

    /**
     * 文件上传目录
     * 可以是相对路径，也可以是绝对路径
     */
    //    public static final String DIR_UPLOAD = "C:/temp";
    const val DIR_UPLOAD = "D:\\My"
}
