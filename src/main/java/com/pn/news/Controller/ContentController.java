package com.pn.news.Controller;

import com.pn.news.Common.Result;
import com.pn.news.Service.ContentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章内容控制器
 */
@RestController
@RequestMapping("/content")
public class ContentController {
    @Resource
    private ContentService contentService;
    /**
     * 列表
     * @param last   分页使用；最后一条数据id；不传递就是最新数据
     * @param userId 用户id；查询指定用户发布的内容；为空就是所有用户发布的内容
     * @param size   每页显示多少条数据；默认10
     * @param style  内容类型；取值和Content.style一样
     * @return
     */
    @GetMapping
    public Object getContent(@RequestParam(required = false) String last,
                             @RequestParam(required = false, value = "user_id") String userId,
                             @RequestParam(defaultValue = "10") int size,
                             @RequestParam(required = false) String style){
        if (size >= 30) {
            size = 30;
        }
        return Result.success(contentService.getContent(null,last, userId, size, style));
    }
}
