package com.dp.decorator.service.decorato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("logAndAuthUser")
public class LogAndAuthUserServiceDecorator extends UserServiceDecorator {

    /**
     * 日志装饰者的引用
     */
    private LogUserServiceDecorator logUserServiceDecorator;

    /**
     * 权限装饰者的引用
     */
    private AuthUserServiceDecorator authUserServiceDecorator;

    /**
     * 通过构造方法传入被装饰的service对象
     *
     * @param logUserServiceDecorator
     *
     */
    @Autowired
    public LogAndAuthUserServiceDecorator(LogUserServiceDecorator logUserServiceDecorator, AuthUserServiceDecorator authUserServiceDecorator) {
        // 调用父类的构造方法，传入任意一个被装饰的对象， 这里我们传人日志装饰者
        super(logUserServiceDecorator);
        // 赋值日志装饰者和权限装饰者的引用
        this.logUserServiceDecorator = logUserServiceDecorator;
        this.authUserServiceDecorator = authUserServiceDecorator;
    }

    /**
     * 在原有的service的基础上添加日志记录和权限验证的功能
     * @param id
     * @return
     */
    @Override
    public String getUserName(int id) {
        // 先调用日志装饰者的方法，实现日志功能
        String name = logUserServiceDecorator.getUserName(id);
        System.out.println("记录日志后，再进行权限验证,name= "+name);
        // 再调用权限装饰者的方法，实现权限功能，并返回用户对象
        return authUserServiceDecorator.getUserName(id);
    }
}
