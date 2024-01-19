package com.pn.news.model.response;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

/**
 * 分页响应
 */
@Data
@NoArgsConstructor
public class PageResponse  {
    /**
     * 总数
     */
    protected long total = 0;

    /**
     * 分页总数
     */
    protected long pages = 0;

    /**
     * 每页显示条数，默认 10
     */
    protected long size;

    /**
     * 当前页
     */
    protected long page = 1;

    /**
     * 上一页
     * <p>
     * 当然这些数据，客户端也可以计算
     */
    protected Long previous;

    /**
     * 下一页
     */
    protected Long next;

    /**
     * 真实列表数据
     */
    private Object data;



    public PageResponse(Object data) {
        this.data = data;
    }

    public PageResponse(long total, long pages, long page, long size, List data) {
        this.total = total;
        this.pages = pages;
        this.page = page;
        this.size = size;

        if (CollectionUtils.isNotEmpty(data)) {
            this.data = data;
        }

        //计算上一页
        if (page > 1) {
            previous = page - 1;
        } else {
            previous = null;
        }

        //计算下一页
        if (page >= pages) {
            next = null;
        } else {
            next = page + 1;
        }
    }

    public static PageResponse create(Object data) {
        return new PageResponse(data);
    }

    public static PageResponse create(IPage data) {
        return new PageResponse(data.getTotal(), data.getPages(), data.getCurrent(), data.getSize(), data.getRecords());
    }

}
