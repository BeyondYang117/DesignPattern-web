package com.dp.article.domain;

import lombok.Data;

@Data
public class Article {

    /**
     * 内容
     */
    private String content;

    private boolean approved;

    /**
     * 文章审核策旅（指定跌代器的数量）
     */
    private String reViewers;
}
