package com.pn.news.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pn.news.model.response.ID;
import com.pn.news.model.response.PageResponse;
import com.pn.news.model.response.Response;


import java.util.List;

/**
 * 响应工具类
 * <p>
 * 对返回的数据进行处理
 * 例如：包装；加密
 */
public class R {
    /**
     * 只返回一个id
     * @param id
     * @return
     */

    public static Object warp(String id){
            return new Response(new ID());
    }
/**
 * 成功
 */
public static Object warp(Object data){
    if(data instanceof List<?>){
        data = PageResponse.create(data);
    }
    return new Response(data);
}


    /**
     * 失败
     * @param status
     * @param message
     * @return
     */
    public static Object failed(int status,String message) {
            return new Response(status,message);
    }
}
