package com.pn.news.Controller;

import cn.dev33.satoken.stp.StpUtil;
import com.pn.news.Common.Result;
import com.pn.news.Exception.ArgumentException;
import com.pn.news.Mapper.CommentMapper;
import com.pn.news.Mapper.CommonMapper;
import com.pn.news.Service.ContentService;
import com.pn.news.model.pojo.Content;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * 文章内容控制器
 */
@RestController
@RequestMapping("/content")
@Tag(name = "文章接口")
public class ContentController {
    @Resource
    private ContentService contentService;
    @Resource
    private CommonMapper commonMapper;
    /**
     * 列表
     * @param last   分页使用；最后一条数据id；不传递就是最新数据
     * @param userId 用户id；查询指定用户发布的内容；为空就是所有用户发布的内容
     * @param size   每页显示多少条数据；默认10
     * @param style  内容类型；取值和Content.style一样
     * @return
     */
    @GetMapping
    @Operation(summary = "分页显示内容列表")
    public Object getContent(@RequestParam(required = false) String last,
                             @RequestParam(required = false, value = "user_id") String userId,
                             @RequestParam(defaultValue = "10") int size,
                             @RequestParam(required = false) String style){
        if (size >= 30) {
            size = 30;
        }
        return Result.success(contentService.getContent(null,last, userId, size, style));
    }
    /**
     * 查看文章详情
     */
    @GetMapping("/{id}")
    @Operation(summary = "查看文章详情")
    public Result show(@PathVariable String id){
        commonMapper.incrementCount("content",id,"clicks_count");
        return  Result.success(contentService.showDetail(id));
    }
    /**
     * 发布文章
     * @param data
     * @param bindingResult
     */
    @PostMapping
    @Operation(summary = "发布文章")
    public Object create(@Valid @RequestBody Content data, BindingResult bindingResult) {
        StpUtil.checkLogin();

        if (bindingResult.hasErrors()){
            throw ArgumentException.getInstance();
        }

        //设置用户id
        data.setUserId(StpUtil.getLoginIdAsString());

        contentService.create(data);

        return Result.success(data.getId());
    }
}
