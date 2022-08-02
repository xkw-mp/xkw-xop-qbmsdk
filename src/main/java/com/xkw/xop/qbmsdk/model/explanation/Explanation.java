/*
 * xkw.com Inc. Copyright (c) 2022 All Rights Reserved.
 */
package com.xkw.xop.qbmsdk.model.explanation;

import java.util.List;

/**
 *
 * 解析
 *
 * @author Luozl
 */
public class Explanation {
    private List<ExplanationSeg> explanationSegs;

    public List<ExplanationSeg> getExplanationSegs() {
        return explanationSegs;
    }

    public void setExplanationSegs(List<ExplanationSeg> explanationSegs) {
        this.explanationSegs = explanationSegs;
    }

    @Override
    public String toString() {
        return "Explanation{" +
                "explanationSegs=" + explanationSegs +
                "}";
    }
}
