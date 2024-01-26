package com.pn.news.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pn.news.Mapper.FriendMapper;
import com.pn.news.model.pojo.Friend;
import org.springframework.stereotype.Service;

/**
 * 好友服务
 */
@Service
public class FriendService {
    private FriendMapper mapper;

    public FriendService(FriendMapper mapper) {
        this.mapper = mapper;
    }

    public void create(Friend data) {
        //因为使用了约束
        //所以保存失败
        //直接回抛出异常
        mapper.insert(data);
    }


}
