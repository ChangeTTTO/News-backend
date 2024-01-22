package com.pn.news.Controller;

import cn.hutool.core.util.StrUtil;
import com.pn.news.common.Result;
import com.pn.news.Exception.ArgumentException;
import com.pn.news.Service.CodeService;
import com.pn.news.model.request.CodeRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

/**
 * 验证码控制器
 */
@RestController
@RequestMapping("/codes")
@Tag(name = "验证码接口")
public class CodeController {
    @Resource
    CodeService codeService;
    /**
     * 发送验证码
     * style:验证码的类型，0：邮件，10：短信
     */
    @PostMapping("/getCode")
    @Operation(summary = "发送验证码")
    public Result sendCode(@RequestParam(defaultValue = "0") int style, @RequestBody(required = false) CodeRequest param, HttpServletRequest request){
                String target=null;
            if (style==0){
                if (StrUtil.isBlank(param.getEmail())){
                    throw ArgumentException.getInstance();
                }
                target=param.getEmail();
            } else if (style==10) {
                if (StrUtil.isBlank(param.getPhone())){
                    throw  ArgumentException.getInstance();
                }
                target=param.getPhone();
            }else {
                throw  ArgumentException.getInstance();
            }
            return Result.INSTANCE.success(codeService.sendCode(style,target));
}
}
