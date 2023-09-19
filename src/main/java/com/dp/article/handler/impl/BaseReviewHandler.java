package com.dp.article.handler.impl;

import com.dp.article.domain.Article;
import com.dp.article.handler.ReviewHandler;
import com.dp.article.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component("BASE")
class BaseReviewHandler implements ReviewHandler {

    @Autowired
    private SensitiveWordReviewHandler sensitiveWordReviewHandler;

    @Override
    public Result review(Article article) {
        // 进行基础审核，检查字数是否达标
        int wordCount = article.getContent().split("\\s+").length;
        if (wordCount <= 100) {
            log.debug("基础审核通过");
            return new Result(true);
        } else {
            log.debug("基础审核未通过");
            return new Result(false,"文章字数不超过100");
        }
    }
}
