package com.pn.news.Controller;

import cn.dev33.satoken.stp.StpUtil;
import com.pn.news.common.Result;
import com.pn.news.Exception.ArgumentException;
import com.pn.news.Mapper.CommonMapper;
import com.pn.news.Service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.pn.news.model.pojo.Comment;
/**
 * 评论控制器
 */
@RestController
@RequestMapping("/comments")
@Tag(name = "评论接口")
public class CommentController {
    @Resource
    private CommentService commentService;
    @Resource
    private CommonMapper commonMapper;


    /**
     * 评论列表
     * @param page      第几页
     * @param size      每页显示多少条
     * @param order     排序；0：最新，默认；10：最热
     * @param userId    用户id
     * @param articleId 文章id
     * @param parentId  被回复评论的id
     * @return
     */
    @GetMapping
    @Operation(summary = "查询评论列表")
    public Result index(@RequestParam(defaultValue = "1") int page,
                        @RequestParam(defaultValue = "10") int size,
                        @RequestParam(defaultValue = "0") int order,
                        @RequestParam(name = "user_id", required = false) String userId,
                        @RequestParam(name = "article_id", required = false) String articleId,
                        @RequestParam(name = "parent_id", required = false) String parentId) {
        return Result.INSTANCE.success(commentService.findAll(page, size, order, userId, articleId, parentId));
    }

    /**
     * 创建评论
     * @param data
     * @param bindingResult
     * @return
     */
    @PostMapping
    @Operation(summary = "发布评论")
    public Object create(@Valid @RequestBody Comment data,
                         BindingResult bindingResult) {
        StpUtil.checkLogin();
        if (bindingResult.hasErrors()) {
            throw ArgumentException.getInstance();
        }

        //设置用户id
        data.setUserId(StpUtil.getLoginIdAsString());

        commentService.create(data);

        return Result.INSTANCE.success(data.getId());
    }
}
