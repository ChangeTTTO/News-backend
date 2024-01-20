package com.pn.news.Controller;

import cn.dev33.satoken.stp.StpUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RequestMapping("/orders")
@Tag(name = "订单接口")
@Slf4j
public class OrdersController {
    /**
    *获取订单列表
    */
    @Operation(summary = "获取订单列表")
    @GetMapping
    public Object getList(){
        log.info("开始进行登录校验");
        if (StpUtil.isLogin()){
            return "登录了"+StpUtil.getLoginIdAsString();
        }
        return "未登录";
    }
}
