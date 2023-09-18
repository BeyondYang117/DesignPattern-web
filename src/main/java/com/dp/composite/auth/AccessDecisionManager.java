package com.dp.composite.auth;

import com.dp.composite.domain.Request;
import com.dp.composite.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 组合模式的容器节点，实现了 AccessDecisionVoter 接口
 * 这个类用于组合多个 AccessDecisionVoter 对象, 并根据投票结果决定是否授权
 */
@Component
public class AccessDecisionManager implements AccessDecisionVoter {

    @Autowired
    private List<AccessDecisionVoter> voters;

    public int vote(User user, Request request) {
        // 记录投票结果的变量
        int result = ACCESS_ABSTAIN;
        // 遍历所有的AccessDecisionVoter对象，进行投票
        for (AccessDecisionVoter voter : voters) {
            int vote = voter.vote(user, request);
            // 如果有任何一个投票结果是拒绝，则直接返回拒绝
            if (vote == ACCESS_DENIED) {
                return ACCESS_DENIED;
            }
            // 如果任何一个投票结果是通过，则记录通过，但不返回，继续遍历其他投票者
            if (vote == ACCESS_GRANTED) {
                result = ACCESS_GRANTED;
            }
        }
        // 返回最终的投票结果
        return result;
    }
}
