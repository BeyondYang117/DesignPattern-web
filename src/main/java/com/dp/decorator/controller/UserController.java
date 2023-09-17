package com.dp.decorator.controller;

import com.dp.decorator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述: spring 中使用装饰者模式来给任何一个service添加日志功能，才利用依额注入来动态地选择被装饰的对象
 * UserController，它处理用户相关的请求
 *
 * @date 2023/9/17 21:09
 * @author abu
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ApplicationContext applicationContext;


    /**
     * 描述: 处理获取用户的请求
     * 默认：userService, 增加日志：logUserService, 增加权限：authUserService， 增加日志和权限：logAndAuthUser
     * @date 2023/9/17 21:12
     * @author abu
     * @param id
     * @param decorator
     * @return java.lang.String
     */
    @GetMapping("/getUser")
    public String getUser(@RequestParam("id") int id, @RequestParam() String decorator) {
        UserService userService = (UserService)applicationContext.getBean(decorator);
        return userService.getUserName(id);
    }
}
