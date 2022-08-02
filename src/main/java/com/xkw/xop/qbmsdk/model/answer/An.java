/*
 * xkw.com Inc. Copyright (c) 2022 All Rights Reserved.
 */
package com.xkw.xop.qbmsdk.model.answer;

/**
 *
 * 答题空
 *
 * @author Luozl
 */
public class An {
    /**
     * 答案Html
     */
    private String html;
    /**
     * 是否是选择题
     */
    private Boolean op = false;
    /**
     * 是否支持机阅
     */
    private Boolean exact = false;

    public Boolean getOp() {
        return op;
    }

    public void setOp(Boolean op) {
        this.op = op;
    }

    public Boolean getExact() {
        return exact;
    }

    public void setExact(Boolean exact) {
        this.exact = exact;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    @Override
    public String toString() {
        return "An{" +
                "html='" + (html == null ? null : html.replaceAll("'", "\\\\'")) + '\'' +
                ", op=" + op +
                ", exact=" + exact +
                '}';
    }
}
