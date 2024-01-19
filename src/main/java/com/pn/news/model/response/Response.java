package com.pn.news.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 所有接口返回包装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    /**
     * 真实数据
     * 详情接口：就是一个对象
     * 列表接口：是分页对象
     */
    private Object data;

    /**
     * 响应码
     * 默认为0：表示成功
     */
    private int status;

    /**
     * 错误提示
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

    /**
     * 详细错误信息
     */
    // private List<ErrorDetail> detail;


    public Response(Object data) {
        this.data = data;
    }


    public Response(int status, String message) {
        this.status=status;
        this.message=message;
    }
}
