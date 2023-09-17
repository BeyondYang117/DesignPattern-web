package com.dp.decorator.service.decorato;

import com.dp.decorator.service.UserService;

/**
 * 定义一个抽象的装饰者类，它实现了sercice接口，并持有一个service 对象的引用
 */
public abstract class UserServiceDecorator implements UserService {

    /**
     * 被装饰的service对象
     */
    protected UserService userService;

    /**
     * 通过构造方法传入被装饰的service对象
     * @param userService
     */
    public UserServiceDecorator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String getUserName(int id) {
        return userService.getUserName(id);
    }
}
