package com.dp.article.service;

import com.dp.article.handler.ReviewHandler;
import com.dp.article.domain.Article;
import com.dp.article.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述: 文章文献，评论审核等
 *
 * @date 2023/9/17 18:02
 * @author caozp
 */
@Service
public class ReviewArticleService {

    @Autowired
    private ReviewHandler reviewHandler;

    public Result reviewArticle(Article article) {
        return reviewHandler.review(article);
    }
}
