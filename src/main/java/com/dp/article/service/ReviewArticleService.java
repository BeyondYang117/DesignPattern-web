package com.dp.article.service;

import com.alibaba.druid.util.StringUtils;
import com.dp.article.domain.Article;
import com.dp.article.handler.ReviewHandler;
import com.dp.article.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 描述: 文章文献，评论审核等
 *      增加迭代器功能
 *
 * @date 2023/9/17 18:02
 * @author caozp
 */
@Service
public class ReviewArticleService {

    private List<ReviewHandler> reviewHandlers;

    @Autowired
    private ApplicationContext context;

    public Result reviewArticle(Article article) {
        reviewHandlers = buildHandlers(article);
        Iterator<ReviewHandler> iterator = reviewHandlers.iterator();
        Result result = null;
        while (iterator.hasNext()) {
            ReviewHandler review = iterator.next();
            result = review.review(article);
            if (!result.isApproved()) {
                return result;
            }
        }
        article.setApproved(true);
        // 保存图片
        // 。。。
        // 返回结束
        return result;
    }

    private List<ReviewHandler> buildHandlers(Article article) {
        List<String> reviewers = getList(article.getReViewers());
        if (CollectionUtils.isEmpty(reviewers)) {
            return Collections.emptyList();
        }
        List<ReviewHandler> handlerList = new ArrayList<>();
        for (String reviewer : reviewers) {
            handlerList.add(context.getBean(reviewer, ReviewHandler.class));
        }
        return handlerList;
    }

    public static List<String> getList(String sjxs) {
        if(StringUtils.isEmpty(sjxs)){
            return null;
        }
        String[] sjx = sjxs.split(",");
        return Arrays.asList(sjx);
    }
}
