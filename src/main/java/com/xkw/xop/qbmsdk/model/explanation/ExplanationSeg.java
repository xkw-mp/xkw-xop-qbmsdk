/*
 * xkw.com Inc. Copyright (c) 2022 All Rights Reserved.
 */
package com.xkw.xop.qbmsdk.model.explanation;

/**
 *
 * 解析详情
 *
 * @author Luozl
 */
public class ExplanationSeg {
    private String name;
    private String html;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    @Override
    public String toString() {
        return "ExplanationSeg{" +
                "name='" + name + '\'' +
                ", html='" + (html == null ? null : html.replaceAll("'", "\\\\'")) + '\'' + "}";
    }
}
