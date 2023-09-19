package com.dp.composite.auth;

import com.dp.composite.domain.Request;
import com.dp.composite.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 组合模式的叶子节点，实现了AccessDecisionVoter接口
 * 这个类用子判断用户是否有资源权限
 */
@Component
public class ResourceVoter implements AccessDecisionVoter {
    @Override
    public int vote(User user, Request request) {
        // 获取用户的资源列表
        List<String> resources = user.getResources();
        // 获取请求需要的资源列表
        List<String> requestResources = request.getRequiredResources();
        // 如果用户的资源列表包含请求需要的所有资源，则授权通过
        for (String resource : requestResources) {
            if (!resources.contains(resource)) {
                return ACCESS_DENIED;
            }
        }
        return ACCESS_GRANTED;
    }
}
