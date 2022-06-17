/*
 * xkw.com Inc. Copyright (c) 2022 All Rights Reserved.
 */
package com.xkw.xop.qbmsdk.model;

import com.xkw.xop.qbmsdk.model.answer.Answer;
import com.xkw.xop.qbmsdk.model.explanation.Explanation;
import com.xkw.xop.qbmsdk.model.stem.Stem;

/**
 *
 * 拆分之后的试题
 *
 * @author Luozl
 * @version 1.0
 * @date 2022年05月24日
 */
public class Question {
    /**
     * 题干
     */
    private Stem stem;
    /**
     * 答案
     */
    private Answer answer;
    /**
     * 解析
     */
    private Explanation explanation;

    public Stem getStem() {
        return stem;
    }

    public void setStem(Stem stem) {
        this.stem = stem;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Explanation getExplanation() {
        return explanation;
    }

    public void setExplanation(Explanation explanation) {
        this.explanation = explanation;
    }

    @Override
    public String toString() {
        return "Question{" +
                "stem=" + stem +
                ", answer=" + answer +
                ", explanation=" + explanation +
                '}';
    }
}
