/*
 * xkw.com Inc. Copyright (c) 2022 All Rights Reserved.
 */
package com.xkw.xop.qbmsdk;


import com.xkw.xop.qbmsdk.model.Question;
import com.xkw.xop.qbmsdk.model.answer.Answer;
import com.xkw.xop.qbmsdk.model.explanation.Explanation;
import com.xkw.xop.qbmsdk.model.stem.Stem;
import com.xkw.xop.qbmsdk.service.QuestionParserService;


/**
 * 文档地址：https://thoughts.teambition.com/share/6298216edccf5300410194ee#title=题库SDK-Java
 * 提供将xopqbm输出的html格式的题干答案解析进行拆分的功能
 * 1、题干拆分 ：将HTML格式的题干拆分为：题干、选项、小题、小问
 * 2、答案拆分 ：将HTML格式的答案拆分为：小题答案、答题空答案
 * 3、解析拆分 ：将HTML格式的解析拆分为：小题解析、分析、点睛等自定义片段
 * 4、试题拆分 ：合并题干答案解析拆分功能，对于输入的题干答案解析进行统一拆分，输出一道试题的拆分结果
 *
 * @author Luozl
 * @version 1.0
 * date 2022年05月24日
 */
public class QuestionParser {
    private QuestionParserService parserService = null;
    private Setting setting = null;

    public QuestionParser(Setting setting) {
        this.setting = setting;
        parserService = new QuestionParserService();
    }

    /**
     * 将xopqbm输出的html格式的题干 提取出 题干、选项、小题、小问
     *
     * @param stem
     * @return
     */
    public Stem splitStem(String stem) {
        return parserService.splitStem(stem);
    }

    /**
     * 将xopqbm输出的html格式的答案 提取出：小题答案、答题空答案
     *
     * @param answer
     * @return
     */
    public Answer splitAnswer(String answer) {
        return parserService.splitAnswer(answer);
    }

    /**
     * 将xopqbm输出的html格式的解析 提取出： 小题解析、分析、点睛等自定义片段
     *
     * @param explanation
     * @return
     */
    public Explanation splitExplanation(String explanation) {
        return parserService.splitExplanation(explanation);
    }

    public Question splitQuestion(String stem, String answer, String explanation) {
        return parserService.splitQuestion(stem, answer, explanation);
    }

}
