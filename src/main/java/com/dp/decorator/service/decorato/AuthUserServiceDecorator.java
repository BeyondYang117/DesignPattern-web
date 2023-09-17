package com.dp.decorator.service.decorato;

import com.dp.decorator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 权限装饰者类，它表示权限检查的功能
 *
 * @author caozp
 */
@Service("authUserService")
public class AuthUserServiceDecorator extends UserServiceDecorator {
    /**
     * 通过构造方法传入被装饰的service对象
     *
     * @param userService
     */
    @Autowired
    public AuthUserServiceDecorator(UserService userService) {
        super(userService);
    }

    public String getUserName(int id) {
        System.out.println("进行了权限验证，验证通过后才可以访问service");
        // 模拟获取当前用户的角色
        String role = "admin";
        // 检查当前用户是否有权限访问
        if (role.equals("admin")) {
            // 如果有权限，调用被装饰对象的方法
            return userService.getUserName(id);
        }
        // 如果没有权限，抛出异常或返回空对象
        throw new RuntimeException("权限不足，拒绝访问");
    }

}
