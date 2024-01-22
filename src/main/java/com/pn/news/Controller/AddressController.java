package com.pn.news.Controller;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.pn.news.Exception.ArgumentException;
import com.pn.news.common.Result;
import com.pn.news.model.pojo.Address;
import com.pn.news.Mapper.AddressMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * 收货地址控制器
 */
@RestController
@Tag(name="收货地址接口")
@RequestMapping("/addresses")
public class AddressController {
    @Resource
    AddressMapper addressMapper;

    /**
     * 新增收货地址
     * @param data
     * @param bindingResult
     */
    @PostMapping
    @Transactional
    @Operation(summary = "新增收货地址")
    public Result create(@Valid @RequestBody Address data,
                         BindingResult bindingResult) {
        StpUtil.checkLogin();
        if (bindingResult.hasErrors()){
            throw ArgumentException.getInstance();
        }
        //设置用户id
        data.setUserId(StpUtil.getLoginIdAsLong());

        if (data.idDefault()){
             //如果用户本身有了一个默认收货地址，此时又想新增一个，那么就应该将其他所有地址改成不是默认的。
            LambdaUpdateWrapper<Address> wrapper = new LambdaUpdateWrapper<>();
            wrapper.eq(Address::getUserId,data.getUserId());
            wrapper.set(Address::getDefaultAddress,0);
            addressMapper.update(null,wrapper);
            throw new RuntimeException();
        }
        //添加到数据库
        addressMapper.insert(data);
        return Result.INSTANCE.success(data.getId());
    }

}
