package com.dp.composite.controller;

import com.dp.composite.auth.AccessDecisionManager;
import com.dp.composite.dao.DataProvider;
import com.dp.composite.domain.Request;
import com.dp.composite.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过组合模式实现用户的权限管理
 */
@RestController
public class UserRoleController {

    @Autowired
    private DataProvider dataProvider;

    @Autowired
    private AccessDecisionManager accessDecisionManager;

    @RequestMapping(value = "/api/user/list", method = RequestMethod.GET)
    public String listUser(String username, String password) {
        User user = dataProvider.getUser(username);
        if (user == null || !user.getPassword().equals(password)) {
            return "用户名或密码错误";
        }
        Request request = dataProvider.getRequestByPath("/api/user/list");
        int result = accessDecisionManager.vote(user, request);
        if (result == AccessDecisionManager.ACCESS_GRANTED) {
            return "查询用户列表成功";
        }
        return "没有权限查询用户列表";
    }

    @RequestMapping(value = "/api/user/add", method = RequestMethod.POST)
    public String addUser(String username, String password) {
        User user = dataProvider.getUser(username);

        // 根据请求路径从 DataProvider 中获取请求
        Request request = dataProvider.getRequestByPath("/api/user/add");
        // 调用 AccessDecisionManager 的 vote 方法进行权限验证
        int result = accessDecisionManager.vote(user, request);
        // 如果授权通过，则添加用户
        if (result == AccessDecisionManager.ACCESS_GRANTED) {
            return "添加用户成功";
        }
        // 否则返回失败信息
        return "没有权限添加用户";
    }

    @RequestMapping(value = "/api/user/delete", method = RequestMethod.DELETE)
    public String deleteUser(String username, String password) {
        User user = dataProvider.getUser(username);
        // 根据请求路径从 DataProvider 中获取请求
        Request request = dataProvider.getRequestByPath("/api/user/delete");
        // 调用 AccessDecisionManager 的 vote 方法进行权限验证
        int result = accessDecisionManager.vote(user, request);
        // 如果授权通过，则删除用户
        if (result == AccessDecisionManager.ACCESS_GRANTED) {
            return "删除用户成功";
        }
        // 否则返回失败信息
        return "没有权限删除用户";
    }

    @RequestMapping(value = "/api/user/update", method = RequestMethod.PUT)
    public String updateUser(String username, String password) {
        User user = dataProvider.getUser(username);
        // 根据请求路径从 DataProvider 中获取请求
        Request request = dataProvider.getRequestByPath("/api/user/update");
        // 调用 AccessDecisionManager 的 vote 方法进行权限验证
        int result = accessDecisionManager.vote(user, request);
        // 如果授权通过，则更新用户
        if (result == AccessDecisionManager.ACCESS_GRANTED) {
            return "更新用户成功";
        }
        // 否则返回失败信息
        return "没有权限更新用户";
    }

}
