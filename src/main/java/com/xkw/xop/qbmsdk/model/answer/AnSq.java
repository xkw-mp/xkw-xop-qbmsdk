/*
 * xkw.com Inc. Copyright (c) 2022 All Rights Reserved.
 */
package com.xkw.xop.qbmsdk.model.answer;

import java.util.List;

/**
 *
 * 小题答案
 *
 * @author Luozl
 * @version 1.0
 * @date 2022年05月24日
 */
public class AnSq {
    /**
     * 答题空
     *
     */
    private List<An> ans;

    public List<An> getAns() {
        return ans;
    }

    public void setAns(List<An> ans) {
        this.ans = ans;
    }

    @Override
    public String toString() {
        return "AnSq{" +
                "ans=" + ans +
                "}";
    }
}
