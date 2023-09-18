package com.dp.composite.auth;

import com.dp.composite.domain.Request;
import com.dp.composite.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 组合模式的叶子节点，实现了 AccessDecisionVoter 接口
 * 这个类用于判断用户是否有角色权限
 *
 */
@Component
public class RoleVoter implements AccessDecisionVoter {


    @Override
    public int vote(User user, Request request) {
        // 获取用户的角色列表
        List<String> roles = user.getRoles();
        // 获取请求需要的角色列表
        List<String> requestRoles = request.getRequiredRoles();
        // 如果用户的角色列表包含请求需要的任意一个角色，则授权通过
        for (String role : requestRoles) {
            if (roles.contains(role)) {
                return ACCESS_GRANTED;
            }
        }
        // 否则授权拒绝
        return ACCESS_DENIED;
    }
}
