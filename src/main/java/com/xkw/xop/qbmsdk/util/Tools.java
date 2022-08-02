/*
 * xkw.com Inc. Copyright (c) 2022 All Rights Reserved.
 */
package com.xkw.xop.qbmsdk.util;


import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Collection;

/**
 *
 * 一些基础的公共服务
 *
 * @author Luozl
 */
public class Tools {
    public static boolean collectionIsEmpty( Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static String html(Elements elements) {
        StringBuilder sb = StringUtil.borrowBuilder();
        for (Element element : elements) {
            sb.append(element.html());
        }
        return StringUtil.releaseBuilder(sb);
    }

    public static String outerHtml(Elements elements) {
        StringBuilder sb = StringUtil.borrowBuilder();
        for (Element element : elements) {
            sb.append(element.outerHtml());
        }
        return StringUtil.releaseBuilder(sb);
    }
}
