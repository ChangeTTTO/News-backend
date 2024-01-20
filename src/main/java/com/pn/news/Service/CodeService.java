package com.pn.news.Service;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pn.news.Common.Result;
import com.pn.news.model.request.CodeRequest;
import com.pn.news.model.response.Code;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class CodeService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    /**
    *创建验证码
    */
    public String sendCode(int style, String target) {
        String Code = Arrays.toString(NumberUtil.generateRandomNumber(100000, 999999, 1));
        log.info("生成的验证码是:"+Code);
        String jsonStr = JSONUtil.toJsonStr(Code);
        //生成的验证码放入Redis中，5分钟失效
        stringRedisTemplate.opsForValue().set("codes:"+target+":data",jsonStr,1,TimeUnit.MINUTES);
        //限制发送频率，一分钟只能发一条
        stringRedisTemplate.opsForValue().set("codes:"+"limit"+":data",Code,1,TimeUnit.MINUTES );
        String redisCode = stringRedisTemplate.opsForValue().get("codes:" + target + ":data");

        return redisCode ;
    }
}
