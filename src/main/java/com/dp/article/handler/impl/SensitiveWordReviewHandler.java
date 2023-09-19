package com.dp.article.handler.impl;

import com.dp.article.handler.ReviewHandler;
import com.dp.article.domain.Article;
import com.dp.article.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component("SENSITIVE")
class SensitiveWordReviewHandler implements ReviewHandler {

    @Autowired
    private ImageReviewHandler imageReviewHandler;

    @Override
    public Result review(Article article) {

        // 进行敏感词审核
        // 检查文章是否包含敏感词的逻辑
        boolean containsSensitiveWord = check(article.getContent());

        if (containsSensitiveWord) {
            log.debug("文章包含敏感词");
            return new Result(false, "文章包含敏感英文");
        }
        log.debug("文章不包含敏感词");
        return new Result(true);
    }

    public boolean check(String content) {
        System.out.println("检查敏感词。。。。");
        return true;
    }
}
