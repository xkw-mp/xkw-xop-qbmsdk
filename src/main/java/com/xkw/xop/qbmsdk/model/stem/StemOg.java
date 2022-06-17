/*
 * xkw.com Inc. Copyright (c) 2022 All Rights Reserved.
 */
package com.xkw.xop.qbmsdk.model.stem;

import java.util.List;

/**
 *
 * 选项组
 *
 * @author Luozl
 * @version 1.0
 * @date 2022年05月24日
 */
public class StemOg {
    /**
     * 每行显示的选项个数
     */
    private Integer cols = 1;
    /**
     * 选项组
     */
    private List<StemOgOp> ogOps;

    public List<StemOgOp> getOgOps() {
        return ogOps;
    }

    public void setOgOps(List<StemOgOp> ogOps) {
        this.ogOps = ogOps;
    }

    public Integer getCols() {
        return cols;
    }

    public void setCols(Integer cols) {
        this.cols = cols;
    }

    @Override
    public String toString() {
        return "StemOg{" +
                "cols=" + cols +
                ", ogOps=" + ogOps +
                '}';
    }
}
