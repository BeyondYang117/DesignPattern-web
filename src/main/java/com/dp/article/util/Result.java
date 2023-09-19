package com.dp.article.util;

import lombok.Data;

@Data
public class Result {

    private boolean isApproved;

    private String msg;

    public Result(boolean isApproved, String msg) {
        this.isApproved = isApproved;
        this.msg = msg;
    }

    public  Result(boolean isApproved) {
        this.isApproved = isApproved;
        this.msg = "审核通过";
    }
}
