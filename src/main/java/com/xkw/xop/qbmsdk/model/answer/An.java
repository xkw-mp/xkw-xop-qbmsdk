/*
 * xkw.com Inc. Copyright (c) 2022 All Rights Reserved.
 */
package com.xkw.xop.qbmsdk.model.answer;

/**
 *
 * 答题空
 *
 * @author Luozl
 * @version 1.0
 * date 2022年05月24日
 */
public class An {
    /**
     * 答案Html
     */
    private String html;
    /**
     * 是否是选择题
     */
    private Boolean isOp = false;
    /**
     * 是否支持机阅
     */
    private Boolean isExact = false;

    public Boolean getOp() {
        return isOp;
    }

    public void setOp(Boolean op) {
        isOp = op;
    }

    public Boolean getExact() {
        return isExact;
    }

    public void setExact(Boolean exact) {
        isExact = exact;
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
                ", isOp=" + isOp +
                ", isExact=" + isExact +
                '}';
    }
}
