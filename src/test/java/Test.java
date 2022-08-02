/*
 * xkw.com Inc. Copyright (c) 2022 All Rights Reserved.
 */

import com.xkw.xop.qbmsdk.QuestionParser;
import com.xkw.xop.qbmsdk.Setting;
import com.xkw.xop.qbmsdk.model.Question;
import com.xkw.xop.qbmsdk.model.answer.Answer;
import com.xkw.xop.qbmsdk.model.explanation.Explanation;
import com.xkw.xop.qbmsdk.model.stem.Stem;

/**
 * Test
 * sdk使用测试用例
 *
 * @author Luozl
 */
public class Test {

    /**
     * 输出的数据可以在下面的网站显示：http://www.jsons.cn/javaformat/
     * 也可以通过xopqbm接口调用:/questions/internal/split?id=123456
     *
     * @param args
     */
    public static void main(String[] args) {
        Setting setting = new Setting();
        QuestionParser parser = new QuestionParser(setting);
        testAnswer(parser);
        testStem(parser);
        testExplanation(parser);
        testQuestion(parser);
        System.out.println("可以在下面的网站上查看输出数据：http://www.jsons.cn/javaformat/");
    }

    private static void testStem(QuestionParser parser) {
        //小题题干测试
        String strStem = "<div class=\"qml-stem\"><p style=\"\"><span style=\"font-family: 宋体;\">选择每组单词中不属于同一类的词。</span></p><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">1. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">thirty</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">happy</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">sixty</span></span></div></div></div><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">2. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">sports</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">trousers</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">shorts</span></span></div></div></div><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">3. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">run</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">plant</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">jump</span></span></div></div></div><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">4. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">ground</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">floor</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">eighty</span></span></div></div></div><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">5. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">mountain</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">these</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">those</span></span></div></div></div></div>";
        Stem stem = parser.splitStem(strStem);
        System.out.println(stem.toString());
        //答题空题干测试
        strStem = "<div class=\"qml-stem\"><p style=\"\"><span style=\"font-family: 'Times New Roman';\">Look, there _______ a crayon on the floor. (<span style=\"font-family: 'Times New Roman'\" qml-space-size=\"11\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>)</span></p><div class=\" qml-og\"><table class=\"qml-og\" style=\"width:100%\"><tr><td>A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">is</span></span></td><td>B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">are</span></span></td><td colspan=\"1\">C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">/</span></span></td></tr></table></div></div>";
        stem = parser.splitStem(strStem);
        System.out.println(stem.toString());
    }

    private static void testAnswer(QuestionParser parser) {
        String strAnswer = "<div class=\"qml-answer\"><span class=\"qml-an-sq\">&nbsp;&nbsp;&nbsp;&nbsp;①. <span class=\"qml-an  \"><span style=\"font-family: 宋体;\">平平安安</span></span>&nbsp;&nbsp;&nbsp;&nbsp;②. <span class=\"qml-an  \"><span style=\"font-family: 宋体;\">认认真真</span></span>&nbsp;&nbsp;&nbsp;&nbsp;③. <span class=\"qml-an  \"><span style=\"font-family: 宋体;\">仔仔细细</span></span>&nbsp;&nbsp;&nbsp;&nbsp;④. <span class=\"qml-an  qml-exact\"><span style=\"font-family: 宋体;\">③</span></span>&nbsp;&nbsp;&nbsp;&nbsp;⑤. <span class=\"qml-an  qml-exact\"><span style=\"font-family: 宋体;\">④</span></span>&nbsp;&nbsp;&nbsp;&nbsp;⑥. <span class=\"qml-an  qml-exact\"><span style=\"font-family: 宋体;\">①</span></span>&nbsp;&nbsp;&nbsp;&nbsp;⑦. <span class=\"qml-an  qml-exact\"><span style=\"font-family: 宋体;\">⑥</span></span>&nbsp;&nbsp;&nbsp;&nbsp;⑧. <span class=\"qml-an  qml-exact\"><span style=\"font-family: 宋体;\">⑤</span></span>&nbsp;&nbsp;&nbsp;&nbsp;⑨. <span class=\"qml-an  qml-exact\"><span style=\"font-family: 宋体;\">②</span></span>&nbsp;&nbsp;&nbsp;&nbsp;⑩. <span class=\"qml-an  qml-exact\"><span style=\"font-family: 宋体;\">②</span></span>&nbsp;&nbsp;&nbsp;&nbsp;⑪. <span class=\"qml-an  qml-exact\"><span style=\"font-family: 宋体;\">①</span></span>&nbsp;&nbsp;&nbsp;&nbsp;⑫. <span class=\"qml-an  qml-exact\"><span style=\"font-family: 宋体;\">④</span></span>&nbsp;&nbsp;&nbsp;&nbsp;⑬. <span class=\"qml-an  qml-exact\"><span style=\"font-family: 宋体;\">③</span></span></span></div>";
        Answer answer = parser.splitAnswer(strAnswer);
        System.out.println(answer.toString());
    }

    private static void testExplanation(QuestionParser parser) {
        //带有消息解析和分析点睛等标签
        String strExplanation = "<div class=\"qml-explanation\"><div class=\"qml-seg\" seg-name=\"分析\">【分析】<p style=\"\"><span>1111</span></p></div><div class=\"qml-exps-sq\">(1)题详解： <span>A三十，B开心的，C六十，AC是基数词，B是形容词，故选B。</span><br  /></div><div class=\"qml-exps-sq\">(2)题详解： <span>A运动，B裤子，C短裤，A是表示运动总称的名词，BC是表示具体服装的名词，故选A。</span><br  /></div><div class=\"qml-exps-sq\">(3)题详解： <span>A跑步，B植物，C跳，AC是动词 ，B是名词，故选B。</span><br  /></div><div class=\"qml-exps-sq\">(4)题详解： <span>A地面，B地板，C八十，AB是名词， C是基数词，故选C。</span><br  /></div><div class=\"qml-exps-sq\">(5)题详解： <span>A山，B这些，C那些，A是名词，BC是代词，故选A。</span><br  /></div><div class=\"qml-seg\" seg-name=\"点睛\">【点睛】<p style=\"\"><span>321</span></p></div></div>";
        Explanation explanation = parser.splitExplanation(strExplanation);
        System.out.println(explanation.toString());

    }

    private static void testQuestion(QuestionParser parser) {
        //试题的拆解测试
        String strStem = "<div class=\"qml-stem\"><p style=\"\"><span style=\"font-family: 'Times New Roman';\">Look, there _______ a crayon on the floor. (<span style=\"font-family: 'Times New Roman'\" qml-space-size=\"11\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>)</span></p><div class=\" qml-og\"><table class=\"qml-og\" style=\"width:100%\"><tr><td>A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">is</span></span></td><td>B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">are</span></span></td><td colspan=\"1\">C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">/</span></span></td></tr></table></div></div>";
        String strAnswer = "<div class=\"qml-answer\">1. <span class=\"qml-an-sq\"><span class=\"qml-an qml-isop \">B</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. <span class=\"qml-an-sq\"><span class=\"qml-an qml-isop \">C</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3. <span class=\"qml-an-sq\"><span class=\"qml-an qml-isop \">B</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4. <span class=\"qml-an-sq\"><span class=\"qml-an qml-isop \">A</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5. <span class=\"qml-an-sq\"><span class=\"qml-an qml-isop \">A</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>";
        String strExplanation = "<div class=\"qml-explanation\"><div class=\"qml-seg\" seg-name=\"分析\">【分析】<p style=\"\"><span>1111</span></p></div><div class=\"qml-exps-sq\">(1)题详解： <span>A三十，B开心的，C六十，AC是基数词，B是形容词，故选B。</span><br  /></div><div class=\"qml-exps-sq\">(2)题详解： <span>A运动，B裤子，C短裤，A是表示运动总称的名词，BC是表示具体服装的名词，故选A。</span><br  /></div><div class=\"qml-exps-sq\">(3)题详解： <span>A跑步，B植物，C跳，AC是动词 ，B是名词，故选B。</span><br  /></div><div class=\"qml-exps-sq\">(4)题详解： <span>A地面，B地板，C八十，AB是名词， C是基数词，故选C。</span><br  /></div><div class=\"qml-exps-sq\">(5)题详解： <span>A山，B这些，C那些，A是名词，BC是代词，故选A。</span><br  /></div><div class=\"qml-seg\" seg-name=\"点睛\">【点睛】<p style=\"\"><span>321</span></p></div></div>";
        Question question = parser.splitQuestion(strStem, strAnswer, strExplanation);
        System.out.println(question.toString());
    }
}
