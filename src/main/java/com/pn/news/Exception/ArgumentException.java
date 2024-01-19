package com.pn.news.Exception;

import com.pn.news.utils.Constant;
import lombok.NoArgsConstructor;

/**
 * 参数异常
 * 单例化
 */
public class ArgumentException extends CommonException {


    // 单例实例
    private static ArgumentException INSTANCE;

    /**
     * 私有构造方法
     */
    private ArgumentException() {
        super.setStatus(Constant.ERROR_ARGUMENT);
        super.setMessage(Constant.ERROR_ARGUMENT_MESSAGE);
    }

    /**
     * 获取单例实例的静态方法
     */
    public static synchronized ArgumentException getInstance() {
        if (INSTANCE == null) {
            // 如果实例不存在，创建一个新实例
            INSTANCE = new ArgumentException();
        }
        return INSTANCE;
    }
}
