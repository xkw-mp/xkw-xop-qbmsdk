# 简介

***

学科网开放平台提供了Java版本的题库SDK，本文档主要针对Java开发者，对于题库能力提供一些辅助的服务。gitHub地址：[https://github.com/xkw-mp/xkw-xop-qbmsdk](https://github.com/xkw-mp/xkw-xop-qbmsdk)

### 接口能力

| 接口能力 | 接口能力简要描述                                             |
| -------- | ------------------------------------------------------------ |
| 题干拆分 | 将HTML格式的题干拆分为：题干、选项、小题、小问               |
| 答案拆分 | 将HTML格式的答案拆分为：答题空答案                           |
| 解析拆分 | 将HTML格式的解析拆分为：小题解析、分析、点睛等自定义片段     |
| 试题拆分 | 合并题干答案解析拆分功能，对于输入的题干答案解析进行统一拆分，输出一道试题的拆分结果 |

注：切分之后都是html格式的数据

# 快速入门

## 安装 Java SDK

Java SDK的目录结构

```html
com.xkw.xop.qbmsdk
├── QuestionParser.java
├── Setting.java
├── Test.java
├── model
│   ├── Question.java
│   ├── answer
│   │   ├── An.java
│   │   ├── AnSq.java
│   │   └── Answer.java
│   ├── explanation
│   │   ├── Explanation.java
│   │   └── ExplanationSeg.java
│   └── stem
│       ├── Stem.java
│       ├── StemOg.java
│       └── StemOgOp.java
├── service
│   └── QuestionParserService.java
└── util
    └── Tools.java
```

**支持 JAVA版本：1.8+**

### **使用maven依赖**

pom中添加依赖，推荐使用最新版本

```xml
<dependency>
    <groupId>com.xkw.xop</groupId>
    <artifactId>xkw-xop-qbmsdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

### **直接使用JAR包**

1). 在Maven仓库中下载xkw-xop-qbmsdk压缩工具包：[Maven Central Repository Search](https://search.maven.org/search?q=a:xkw-xop-qbmsdk)；

2). 将下载的xkw-xop-qbmsdk.zip解压后，复制到工程文件夹中;

3). 添加SDK工具包xkw-xop-qbmsdk.jar，jsoup-1.13.1.jar([https://jsoup.org/](https://jsoup.org/))
其中，version为版本号(参见 [__版本更新记录__](https://search.maven.org/search?q=a:xkw-xop-qbmsdk))，添加完成后，用户就可以在工程中使用xopqbm Java SDK。

## 接口使用

```java
Setting setting = new Setting();
QuestionParser parser = new QuestionParser(setting);
String strStem = "<div class=\"qml-stem\"><p style=\"\"><span style=\"font-family: 宋体;\">选出不同类的单词。</span></p><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">1. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">these</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">they</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">those</span></span></div></div></div><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">2. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">office</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">hospital</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">wish</span></span></div></div></div><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">3. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">ship</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">teeth</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">taxi</span></span></div></div></div><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">4. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">crayon</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">whale</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">butterfly</span></span></div></div></div><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">5. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">harvest</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">near</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">far</span></span></div></div></div></div>";
Stem stem = parser.splitStem(strStem);
System.out.println(stem.toString());
```



### 基本配置说明

暂时无需配置额外参数



# 接口能力说明


## 题干拆分

将HTML格式的题干拆分为：主题干、选项、小题、小问

```java
String strStem = "<div class=\"qml-stem\"><p style=\"\"><span style=\"font-family: 宋体;\">选出不同类的单词。</span></p><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">1. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">these</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">they</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">those</span></span></div></div></div><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">2. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">office</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">hospital</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">wish</span></span></div></div></div><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">3. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">ship</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">teeth</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">taxi</span></span></div></div></div><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">4. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">crayon</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">whale</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">butterfly</span></span></div></div></div><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">5. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">harvest</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">near</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">far</span></span></div></div></div></div>";
Stem stem = parser.splitStem(strStem);
System.out.println(stem.toString());
```

参数：

| 参数名称 | 参数说明   | 数据类型 | 是否必须 |
| -------- | ---------- | -------- | -------- |
| stem     | html的题干 | String   | 是       |

返回数据：Stem

| 字段     | 参数说明                                           | 类型            | 是否必须 |
| -------- | -------------------------------------------------- | --------------- | -------- |
| html     | 题干                                               | String          | 是       |
| type     | 试题结构类型：选择题，填空题，复合题               | String          |          |
| og       | 选项                                               | StemOg          | 否       |
| +cols    | 每行显示选项个数                                   | Inetger         |          |
| +ogOps   | 选项组(有序数组，例如有4个选项，那么选项为ABCD)    | Array(StemOgOp) | 是       |
| ++html   | 选项的html数据                                     | String          | 是       |
| sqs      | 小题(小问)：小题或者小问下面不允许再有小题或者小问 | Array(Stem)     | 否       |
| +type    | 类型                                               | String          | 是       |
| +html    | 选项的html数据                                     | String          | 是       |
| +og      | 小题(小问)选项组                                   | StemOg          | 否       |
| ++cols   | 每行显示选项个数                                   | Inetger         |          |
| ++ogOps  | 选项组(有序数组)                                   | Array(StemOgOp) | 是       |
| +++html  | 选项的html数据                                     | String          | 是       |
| +++index | 选项序号(A,B,C,D等)                                | String          | 是       |

## 答案拆分

多选答案是否拼接在一起

将HTML格式的答案拆分为：答题空答案

```java
String strAnswer = "<div class=\"qml-answer\">1. <span class=\"qml-an-sq\"><span class=\"qml-an qml-isop \">B</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. <span class=\"qml-an-sq\"><span class=\"qml-an qml-isop \">C</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3. <span class=\"qml-an-sq\"><span class=\"qml-an qml-isop \">B</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4. <span class=\"qml-an-sq\"><span class=\"qml-an qml-isop \">A</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5. <span class=\"qml-an-sq\"><span class=\"qml-an qml-isop \">A</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>";
Answer answer = parser.splitAnswer(strAnswer);
System.out.println(answer.toString());
```

参数

| 参数名称 | 参数说明   | 数据类型 | 是否必须 |
| -------- | ---------- | -------- | -------- |
| answer   | html的答案 | String   | 是       |

返回数据：Answer

| 字段    | 参数说明                               | 类型        | 是否必须 |
| ------- | -------------------------------------- | ----------- | -------- |
| anSqs   | 答案组(有序数组)                       | Array(AnSq) | 是       |
| +ans    | 小题(小问)答案(有序数组)               | Array(An)   | 是       |
| ++html  | 答案html(如果是选择题，答案为选项序号) | String      | 是       |
| ++op    | 是否选择题                             | Boolean     | 是       |
| ++exact | 是否支持机阅                           | Boolean     | 是       |

## 解析拆分

将HTML格式的解析拆分为：小题解析、分析、点睛等自定义片段

```java
String strExplanation = "<div class=\"qml-explanation\"><div class=\"qml-exps-sq\">(1)题详解： <p style=\"\"><span>A这些，B他/她/它们，C那些，AC都是指示代词，B是人称代词，故选B。</span></p></div><div class=\"qml-exps-sq\">(2)题详解： <p style=\"\"><span>A办公室，B医院，C希望，AB都是名词，C是动词，故选C。</span></p></div><div class=\"qml-exps-sq\">(3)题详解： <p style=\"\"><span>A轮船，B牙齿，C出租车，AC都是交通工具名词，B是其他名词，故选B。</span></p></div><div class=\"qml-exps-sq\">(4)题详解： <p style=\"\"><span>A蜡笔，B鲸鱼，C蝴蝶，BC都是动物名词，A是文具用品名词，故选A。</span></p></div><div class=\"qml-exps-sq\">(5)题详解： <p style=\"\"><span>A收获，B近的，C远的，BC都是形容词，A是动词，故选A。</span></p></div></div>";
Explanation explanation = parser.splitExplanation(strExplanation);
System.out.println(explanation.toString());
```

参数：

| 参数名称    | 参数说明   | 数据类型 | 是否必须 |
| ----------- | ---------- | -------- | -------- |
| explanation | html的解析 | String   | 是       |

返回数据：Explanation

| 字段            | 参数说明                                                     | 类型                  | 是否必须 |
| --------------- | ------------------------------------------------------------ | --------------------- | -------- |
| explanationSegs | 解析的细分段落名称：分析，详解，点睛，小题1(2)详解，或者自定义的名称 | Array(ExplanationSeg) | 否       |
| +name           | 细分段落名称：分析，详解，点睛，小题1(2)详解，或者自定义的名称 | String                | 是       |
| +html           | 内容Html                                                     | String                | 否       |

## 试题拆分

对HTML格式的试题进行拆分，拆分出题干答案解析，其中题干答案解析都需要按照上面的题干答案解析接口进行拆分

```java
String strStem = "<div class=\"qml-stem\"><p style=\"\"><span style=\"font-family: 宋体;\">选出不同类的单词。</span></p><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">1. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">these</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">they</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">those</span></span></div></div></div><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">2. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">office</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">hospital</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">wish</span></span></div></div></div><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">3. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">ship</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">teeth</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">taxi</span></span></div></div></div><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">4. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">crayon</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">whale</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">butterfly</span></span></div></div></div><div class=\"qml-sq\"><div class=\"qml-stem\"><br/><span class=\"ques-no\">5. </span><div class=\"qml-inline qml-og\">A.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">harvest</span></span>　　　　B.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">near</span></span>　　　　C.&nbsp;<span class=\"qml-op\"><span style=\"font-family: 'Times New Roman';\">far</span></span></div></div></div></div>";
String strAnswer = "<div class=\"qml-answer\">1. <span class=\"qml-an-sq\"><span class=\"qml-an qml-isop \">B</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. <span class=\"qml-an-sq\"><span class=\"qml-an qml-isop \">C</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3. <span class=\"qml-an-sq\"><span class=\"qml-an qml-isop \">B</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4. <span class=\"qml-an-sq\"><span class=\"qml-an qml-isop \">A</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5. <span class=\"qml-an-sq\"><span class=\"qml-an qml-isop \">A</span></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>";
String strExplanation = "<div class=\"qml-explanation\"><div class=\"qml-exps-sq\">(1)题详解： <p style=\"\"><span>A这些，B他/她/它们，C那些，AC都是指示代词，B是人称代词，故选B。</span></p></div><div class=\"qml-exps-sq\">(2)题详解： <p style=\"\"><span>A办公室，B医院，C希望，AB都是名词，C是动词，故选C。</span></p></div><div class=\"qml-exps-sq\">(3)题详解： <p style=\"\"><span>A轮船，B牙齿，C出租车，AC都是交通工具名词，B是其他名词，故选B。</span></p></div><div class=\"qml-exps-sq\">(4)题详解： <p style=\"\"><span>A蜡笔，B鲸鱼，C蝴蝶，BC都是动物名词，A是文具用品名词，故选A。</span></p></div><div class=\"qml-exps-sq\">(5)题详解： <p style=\"\"><span>A收获，B近的，C远的，BC都是形容词，A是动词，故选A。</span></p></div></div>";
Question question = parser.splitQuestion(strStem,strAnswer,strExplanation);
System.out.println(question.toString());
```

参数：

| 参数名称    | 参数说明   | 数据类型 | 是否必须 |
| ----------- | ---------- | -------- | -------- |
| stem        | html的试题 | String   | 否       |
| answer      | html的答案 | String   | 否       |
| explanation | html的解析 | String   | 否       |

返回数据：Question

| 字段        | 参数说明 | 类型        | 是否必须 |
| ----------- | -------- | ----------- | -------- |
| stem        | 题干     | Stem        | 否       |
| answer      | 答案     | Answer      | 否       |
| explanation | 解析     | Explanation | 否       |



# 错误信息

### 会出现错误的情况

1. 使用的不是xopqbm返回的html数据

1. 需要传递的是试题的题干html，但是传递了答案或者解析的html

1. 对xopqbm返回的html数据做了其他处理，破坏了原有的结构，再调用接口有可能报错

