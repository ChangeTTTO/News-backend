package com.pn.news.Controller;

import com.pn.news.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public User getUser(){
        User user = new User();
        user.setNickname("小明");
        return user;
    }
    @PostMapping("/register")
    public Object register(@RequestBody User user){
        return user;
    }
}
