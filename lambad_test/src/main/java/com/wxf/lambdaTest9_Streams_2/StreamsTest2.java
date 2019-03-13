/**
 * Copyright (C), 2018-2018
 * FileName: StreamsTest2
 * Author:   Administrator
 * Date:     2018/12/11 16:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lambdaTest9_Streams_2;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2018/12/11
 * @since 1.0.0
 */
public class StreamsTest2 {
    public static void main(String[] args) {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        //collect
        //collect 是非常有用的终止操作，将流中的元素存放在不同类型的结果中，例
        //如 List 、 Set 或者 Map 。 collect 接受收集器（Collector），它由四个不同
        //的操作组成：供应器（supplier）、累加器（accumulator）、组合器（combiner）
        //和终止器（finisher）。这在开始听起来十分复杂，但是Java8通过内置
        //的 Collectors 类支持多种内置的收集器。所以对于大部分常见操作，你并不需
        //要自己实现收集器。
        //让我们以一个非常常见的用例来开始：

        List<Person> filtered = persons
                .stream()
                .filter(p -> p.name.startsWith("P"))
                .collect(Collectors.toList());

        System.out.println(filtered);

        System.out.println("========================");

        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.age));

        personsByAge.forEach((age, p) -> System.out.format("age %s：%s\n", age, p));


        System.out.println("========================");

        Double averageAge = persons
                .stream()
                .collect(Collectors.averagingInt((p -> p.age)));
        System.out.println(averageAge);

        System.out.println("========================");

        //如果你对更多统计学方法感兴趣，概要收集器返回一个特殊的内置概要统计对象，
        //所以我们可以简单计算最小年龄、最大年龄、算术平均年龄、总和和数量。

        IntSummaryStatistics ageSummary =
                persons
                        .stream()
                        .collect(Collectors.summarizingInt(p -> p.age));
        System.out.println(ageSummary);
        //// IntSummaryStatistics{count=4, sum=76, min=12, average=19.0000
        //00, max=23}


        String phrase = persons
                .stream()
                .filter(p -> p.age >= 18)
                .filter(p -> p.age >= 18)
                .map(p -> p.name)
                .collect(Collectors.joining("and ", "In Germany ", " are of legal age."));

        System.out.println(phrase);
        // In Germany Max and Peter and Pamela are of legal age.


        //既然我们知道了一些最强大的内置收集器，让我们来尝试构建自己的特殊收集器
        //吧。我们希望将流中的所有人转换为一个字符串，包含所有大写的名称，并
        //以 | 分割。为了完成它，我们通过 Collector.of() 创建了一个新的收集器。我
        //们需要传递一个收集器的四个组成部分：供应器、累加器、组合器和终止器。
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "), // supplier
                        (j, p) -> j.add(p.name.toUpperCase()),// accumulator
                        (j1, j2) -> j1.merge(j2),             // combiner
                        StringJoiner::toString);           // finisher

        String names = persons
                .stream()
                .collect(personNameCollector);
        System.out.println(names);

        //由于Java中的字符串是不可变的，我们需要一个助手类 StringJointer 。让收集
        //器构造我们的字符串。供应器最开始使用相应的分隔符构造了这样一
        //个 StringJointer 。累加器用于将每个人的大写名称加到 StringJointer 中。
        //组合器知道如何把两个 StringJointer 合并为一个。最后一步，终结器
        //从 StringJointer 构造出预期的字符串。


        //flatMap
        //我们已经了解了如何通过使用 map 操作，将流中的对象转换为另一种类
        //型。 map 有时十分受限，因为每个对象只能映射为一个其它对象。但如何我希望
        //将一个对象转换为多个或零个其他对象呢？ flatMap 这时就会派上用场。
        //flatMap 将流中的每个元素，转换为其它对象的流。所以每个对象会被转换为零
        //个、一个或多个其它对象，以流的形式返回。这些流的内容之后会放
        //进 flatMap 所返回的流中。
        //在我们了解 flatMap 如何使用之前，我们需要相应的类型体系：


    }

}