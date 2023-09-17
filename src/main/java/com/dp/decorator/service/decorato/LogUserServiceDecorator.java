package com.dp.decorator.service.decorato;

import com.dp.decorator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 定义一个具体的装饰者类，它表示日志功能
 */
@Service("logUserService")
public class LogUserServiceDecorator extends UserServiceDecorator {

    /**
     * 通过构造方法传入被装饰的service对象，并使用@Autowired注解让spring自动为我们选择合适的bean对象
     * @param userService
     */
    @Autowired
    public LogUserServiceDecorator(UserService userService) {
        super(userService);
    }

    /**
     * 在原有service的基础上添加日志记录的功能
     */
    @Override
    public String getUserName(int id) {
        // 记录请求开始时间
        long startTime = System.currentTimeMillis();
        String userName = userService.getUserName(id);
        long endTime = System.currentTimeMillis();
        System.out.println("记录日志：方法执行时间为：" + (endTime - startTime));
        return userName;
    }

}
