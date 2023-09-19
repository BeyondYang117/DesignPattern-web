package com.dp.article.handler.impl;


import com.dp.article.handler.ReviewHandler;
import com.dp.article.domain.Article;
import com.dp.article.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("IMAGE")
class ImageReviewHandler implements ReviewHandler {
    @Override
    public Result review(Article article) {

        // 进行图片审核

        boolean containsInappropriateImage = check(article.getContent());
        if (containsInappropriateImage) {
            return new Result(false,"文章中的图片违规！");
        } else {
            // 继续审栯后续
            // 所有审核通过
            log.debug("文章中的图片审核通过");
            return new Result(true);
        }
    }


    public boolean check(String content) {
        System.out.println("已抽取文章中的图片链接检查图片。。。。");
        return true;
    }
}
