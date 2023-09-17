package com.dp.article.handler;


import com.dp.article.domain.Article;
import com.dp.article.util.Result;

public interface ReviewHandler {

    public Result review(Article article);
}
