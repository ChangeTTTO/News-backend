package com.pn.news.Controller;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pn.news.Exception.ArgumentException;
import com.pn.news.Mapper.FriendMapper;
import com.pn.news.Mapper.UserMapper;
import com.pn.news.Service.FriendService;
import com.pn.news.Service.UserService;
import com.pn.news.common.Result;
import com.pn.news.model.pojo.Friend;
import com.pn.news.model.pojo.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friends")
@Tag(name = "好友接口")
public class FriendController {
    @Resource
    private FriendService service;

    @Resource
    private UserMapper userMapper;
    @Resource
    private FriendMapper friendMapper;


    /**
     * 关注用户
     * @param data
     * @return
     */
    @PostMapping
    @Operation(summary = "关注用户")
    public Result create(@RequestBody User data) {
        StpUtil.checkLogin();

        //查找要关注的用户
        User otherUser = userMapper.selectById(data.getId());

        //不能关注自己
        if (StpUtil.getLoginIdAsString().equals(data.getId())) {
            throw ArgumentException.getInstance();
        }

        //创建好友对象
        Friend friend = new Friend();

        //设置当前用户id
        friend.setI(StpUtil.getLoginIdAsLong());

        //设置要关注用户id
        friend.setYou(data.getId());

        friendMapper.insert(friend);

        //返回数据
        return Result.INSTANCE.success(friend.getId());
    }

    /**
     * 取消关注
     * @param userId
     * @return
     */
    @Operation(summary = "取消关注")
    @DeleteMapping("/{userId}")
    public Result destroy(@PathVariable String userId) {
        StpUtil.checkLogin();

        //删除这条关系
        LambdaQueryWrapper<Friend> query = new LambdaQueryWrapper<>();
        query.eq(Friend::getI, StpUtil.getLoginIdAsString()).eq(Friend::getYou, userId);
        int result = friendMapper.delete(query);
        return Result.INSTANCE.success(result);

    }
}
