package com.pn.news.Exception.advice;

import com.pn.news.Exception.CommonException;
import com.pn.news.model.response.Response;
import com.pn.news.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * 当项目中发现异常，便可在这个类中去捕获并进行处理
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {
    /**
     * 处理通用自定义异常
     */
    @ExceptionHandler(value = CommonException.class) //当发现这个异常时，会执行下面的方法
    @ResponseBody
    public Response commonException(CommonException e) {
        return R.failed(e);
    }
    /**
     * 全局异常处理器
     */
  /*  @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response defaultHandleException(Exception e) {
        return R.failed();
    }*/
}
