package com.dp.article.handler.impl;

import com.dp.article.domain.Article;
import com.dp.article.handler.ReviewHandler;
import com.dp.article.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Slf4j
@Primary
@Component
public class BaseReviewHandler implements ReviewHandler {

    @Autowired
    private SensitiveWordReviewHandler sensitiveWordReviewHandler;

    @Override
    public Result review(Article article) {
        // 进行基础审核，检查字数是否达标
        int wordCount = article.getContent().split("\\s+").length;
        if (wordCount <= 100) {
            log.debug("基础审核通过");
            return sensitiveWordReviewHandler.review(article);
        } else {
            log.debug("基础审核未通过");
            return Result.fail("文章字数不超过100");
        }
    }
}
