/*
 * xkw.com Inc. Copyright (c) 2022 All Rights Reserved.
 */
package com.xkw.xop.qbmsdk.model.stem;

import java.util.List;

/**
 *
 * 题目(或者小题)
 *
 * @author Luozl
 */
public class Stem {
    /**
     * 大题题干
     */
    private String html;
    /**
     * 试题结构类型：选择题，填空题，复合题
     */
    private String type;
    /**
     * 小题或者小问题
     */
    private List<Stem> sqs;
    /**
     * 选项组
     */
    private StemOg og;

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Stem> getSqs() {
        return sqs;
    }

    public void setSqs(List<Stem> sqs) {
        this.sqs = sqs;
    }

    public StemOg getOg() {
        return og;
    }

    public void setOg(StemOg og) {
        this.og = og;
    }

    @Override
    public String toString() {
        return "Stem{" +
                "html='" + (html == null ? null : html.replaceAll("'", "\\\\'")) + '\'' +
                ", type='" + type + '\'' +
                ", sqs=" + sqs +
                ", og=" + og +
                '}';
    }
}
