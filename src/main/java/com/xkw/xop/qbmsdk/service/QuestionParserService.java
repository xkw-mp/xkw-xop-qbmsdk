/*
 * xkw.com Inc. Copyright (c) 2022 All Rights Reserved.
 */
package com.xkw.xop.qbmsdk.service;

import com.xkw.xop.qbmsdk.model.Question;
import com.xkw.xop.qbmsdk.model.answer.An;
import com.xkw.xop.qbmsdk.model.answer.AnSq;
import com.xkw.xop.qbmsdk.model.answer.Answer;
import com.xkw.xop.qbmsdk.model.explanation.Explanation;
import com.xkw.xop.qbmsdk.model.explanation.ExplanationSeg;
import com.xkw.xop.qbmsdk.model.stem.Stem;
import com.xkw.xop.qbmsdk.model.stem.StemOg;
import com.xkw.xop.qbmsdk.model.stem.StemOgOp;
import com.xkw.xop.qbmsdk.util.Tools;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 试题html拆分服务
 * 将题库服务拆分出的html格式的题干答案解析拆分出其中的内部结构
 *
 * @author Luozl
 */
public class QuestionParserService {
    /**
     * 试题标签提取
     */
    private static final String P = "p";
    private static final String DIV = "div";
    /**
     * 题干
     */
    private static final String QML_STEM = "qml-stem";
    /**
     * 小题
     */
    private static final String QML_SQ = "qml-sq";
    /**
     * 选项组
     */
    public static final String QML_OG = "qml-og";
    /**
     * 题号
     */
    public static final String QML_QUES_NO = "ques-no";
    /**
     * 选项
     */
    public static final String QML_OP = "qml-op";
    /**
     * 选择题
     */
    private static final String QML_ISOP = "qml-isop";
    /**
     * 答案
     */
    public static final String QML_ANSWER = "qml-answer";
    /**
     * 小题答案
     */
    public static final String QML_AN_SQ = "qml-an-sq";
    /**
     * 答题空
     */
    public static final String QML_AN = "qml-an";
    /**
     * 机阅
     */
    private static final String QML_EXACT = "qml-exact";
    /**
     * 解析
     */
    public static final String QML_EXPLANATION = "qml-explanation";
    /**
     * 解析详情
     */
    public static final String QML_SEG = "qml-seg";
    /**
     * 小题解析
     */
    private static final String QML_EXPS_SQ = "qml-exps-sq";
    /**
     * 解析名称
     */
    public static final String SEG_NAME = "seg-name";
    /**
     * 小题解析详情输出模板
     */
    private static final String SQ_DETAIL = "(%s)题详解";
    /**
     * 选项序号(A,B,C,D等)
     */
    private static List<String> OP_INDEXES = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"
            , "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

    /**
     * 拆分题干
     *
     * @param stem
     * @return
     */
    public Stem splitStem(String stem) {
        Document document = Jsoup.parse(stem);
        if (document == null) {
            return null;
        }
        document.outputSettings(new Document.OutputSettings().prettyPrint(false));
        Element stemElement = document.select(String.format("%s.%s", DIV, QML_STEM)).first();
        return splitStem(stemElement);
    }

    private Stem splitStem(Element stemElement) {
        if (stemElement == null) {
            return null;
        }
        Stem retStem = new Stem();
        List<Element> sqs = stemElement.select(String.format(">.%s>.%s", QML_SQ, QML_STEM));
        retStem.setSqs(sqs.stream().map(this::splitStem).collect(Collectors.toList()));
        retStem.setOg(splitOg(stemElement.select(String.format(">.%s", QML_OG)).first()));
        List<Element> stemHtmls = stemElement.children().stream().filter(i -> !i.is("." + QML_SQ)
                && !i.is("." + QML_OG) && !i.is("." + QML_QUES_NO)).collect(Collectors.toList());
        retStem.setHtml(stemHtmls.size() > 0 ? stemHtmls.stream().map(Node::outerHtml).collect(Collectors.joining()) : null);
        retStem.setType(getQuestionType(retStem));
        return retStem;
    }

    private String getQuestionType(Stem stem) {
        return !Tools.collectionIsEmpty(stem.getSqs())
                ? "复合题" : stem.getOg() != null ? "选择题" : "填空题";
    }

    private StemOg splitOg(Element ogElement) {
        if (ogElement == null) {
            return null;
        }
        List<Element> ops = ogElement.select(String.format(".%s", QML_OP));
        StemOg stemOg = new StemOg();
        List<StemOgOp> ogOps=new ArrayList<>();
        for(int i=0;i<ops.size();i++){
            ogOps.add(new StemOgOp(ops.get(i).outerHtml(),OP_INDEXES.get(i)));
        }
        stemOg.setOgOps(ogOps);
        // 设置一行显示选项个数
        stemOg.setCols(ogElement.children().get(0).is("table")
                ? ogElement.select(">table>tbody>tr").get(0).select("td").size()
                : ogElement.select(String.format(".%s", QML_OP)).size());
        return stemOg;
    }

    /**
     * 拆分答案
     *
     * @param answer
     * @return
     */
    public Answer splitAnswer(String answer) {
        Document document = Jsoup.parse(answer);
        if (document == null) {
            return null;
        }
        document.outputSettings(new Document.OutputSettings().prettyPrint(false));
        Answer retAnswer = new Answer();
        Element answerElement = document.select(String.format(".%s", QML_ANSWER)).first();
        if (answerElement == null) {
            return null;
        }
        List<Element> sqs = answerElement.select(String.format(".%s", QML_AN_SQ));
        retAnswer.setAnSqs(sqs.stream().map(i -> {
            AnSq sq = new AnSq();
            sq.setAns(i.select(String.format(".%s", QML_AN)).stream().map(j -> {
                An an = new An();
                an.setHtml(j.outerHtml());
                an.setOp(j.is(String.format(".%s", QML_ISOP)));
                an.setExact(j.is(String.format(".%s", QML_EXACT)));
                return an;
            }).collect(Collectors.toList()));
            return sq;
        }).collect(Collectors.toList()));
        return retAnswer;
    }

    /**
     * 拆分解析
     *
     * @param explanation
     * @return
     */
    public Explanation splitExplanation(String explanation) {
        Document document = Jsoup.parse(explanation);
        if (document == null) {
            return null;
        }
        document.outputSettings(new Document.OutputSettings().prettyPrint(false));
        Explanation retExplanation = new Explanation();
        Element explanationElement = document.select(String.format(".%s", QML_EXPLANATION)).first();
        if (explanationElement == null) {
            return null;
        }
        List<Element> segs = explanationElement.select(String.format(".%s,.%s", QML_SEG, QML_EXPS_SQ));
        List<ExplanationSeg> explanationSegs = new ArrayList<>();
        //小题编号
        int sqIndex = 0;
        for (Element seg : segs) {
            ExplanationSeg explanationSeg = new ExplanationSeg();
            explanationSegs.add(explanationSeg);
            if ("".equals(seg.attr(SEG_NAME))) {
                explanationSeg.setName(String.format(SQ_DETAIL, ++sqIndex));
                explanationSeg.setHtml(Tools.outerHtml(seg.children()));
            } else {
                explanationSeg.setName(seg.attr(SEG_NAME));
                explanationSeg.setHtml(Tools.outerHtml(seg.children()));
            }
        }
        retExplanation.setExplanationSegs(explanationSegs);
        return retExplanation;
    }

    public Question splitQuestion(String stem, String answer, String explanation) {
        Question retQuestion = new Question();
        retQuestion.setStem(splitStem(stem));
        retQuestion.setAnswer(splitAnswer(answer));
        retQuestion.setExplanation(splitExplanation(explanation));
        return retQuestion;
    }

}
