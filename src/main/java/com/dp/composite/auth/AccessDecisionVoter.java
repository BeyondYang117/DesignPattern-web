package com.dp.composite.auth;

import com.dp.composite.domain.Request;
import com.dp.composite.domain.User;

public interface AccessDecisionVoter {

    /**
     * 授权通过
     */
    public final static int ACCESS_GRANTED = 1;

    /**
     * 授权拒绝
     */
    public final static int ACCESS_DENIED = 0;

    /**
     * 弃权
     */
    public final static int ACCESS_ABSTAIN = 0;

    public int vote(User user, Request request);
}
