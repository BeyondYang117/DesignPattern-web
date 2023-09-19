package com.dp.article.controller;

import com.dp.article.service.ReviewArticleService;
import com.dp.article.domain.Article;
import com.dp.article.util.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述: 文章内容审核（责任链模式）
 *
 * @date 2023/9/17 14:18
 * @author caozp
 *
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ReviewArticleService reviewArticleService;

    /**
     * approve: false
     * reViewers: SENSITIVE,IMAGE,BASE
     * @param article
     * @return
     */
    @PostMapping("/review")
    public ResponseEntity<String> reviewArticle (@RequestBody Article article) {

        Result result = reviewArticleService.reviewArticle(article);
        if (result.isApproved()) {
            return ResponseEntity.ok("文章通过审核！");
        } else {
            return ResponseEntity.ok("文章审核未通过！"+ result.getMsg());
        }
    }
}
