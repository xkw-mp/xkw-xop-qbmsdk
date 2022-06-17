/*
 * xkw.com Inc. Copyright (c) 2022 All Rights Reserved.
 */
package com.xkw.xop.qbmsdk.model.answer;

import java.util.List;

/**
 *
 * 答案
 *
 * @author Luozl
 * @version 1.0
 * date 2022年05月24日
 */
public class Answer {
    /**
     * 小题答案
     * 没有小题的话就只有一个答题空
     */
    private List<AnSq> anSqs;

    public List<AnSq> getAnSqs() {
        return anSqs;
    }

    public void setAnSqs(List<AnSq> anSqs) {
        this.anSqs = anSqs;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "anSqs=" + anSqs +
                "}";
    }
}
