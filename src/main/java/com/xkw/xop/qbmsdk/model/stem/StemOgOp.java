/*
 * xkw.com Inc. Copyright (c) 2022 All Rights Reserved.
 */
package com.xkw.xop.qbmsdk.model.stem;

/**
 *
 * 选项
 *
 * @author Luozl
 * @version 1.0
 * date 2022年05月24日
 */
public class StemOgOp {
    /**
     * 选项的html内容
     */
    private String html;
    /**
     *选项序号(A,B,C,D等)
     */
    private String index;

    @Override
    public String toString() {
        return "StemOgOp{" +
                "html='" + html + '\'' +
                ", index='" + index + '\'' +
                '}';
    }

    public StemOgOp(String html, String index) {
        this.html = html;
        this.index = index;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

}
