package com.pn.news.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 全局自定义异常
 * 目的是对错误进行封装,以方便全局出错
 * 单例化,使用需传入状态码和异常信息
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor@AllArgsConstructor
@Data
public class CommonException extends RuntimeException{
    /**
     * 状态码
     */
    private int status;

    /**
     * 消息
     */
    private String message;
    /**
     * 扩展状态码
     * <p>
     * 例如：第三方服务出错后，具体的错误码
     */
    private String extraStatus;

    /**
     * 扩展消息
     * <p>
     * 例如：第三方服务出错后，具体的错误消息
     */
    private String extraMessage;
    private static CommonException INSTANCE;
    private CommonException(int status,String  message){
        this.status=status;
        this.message=message;
    }
    public static synchronized CommonException getInstance(int status,String message){
        if (INSTANCE==null){
           INSTANCE=new CommonException(status,message);
        }
        return INSTANCE;
    }

}
