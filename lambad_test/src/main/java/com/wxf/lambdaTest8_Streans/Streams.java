/**
 * Copyright (C), 2018-2018
 * FileName: Streams
 * Author:   Administrator
 * Date:     2018/12/11 15:12
 * Description: 数据流如何工作
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lambdaTest8_Streans;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 〈一句话功能简述〉<br>
 * 〈数据流如何工作〉
 *
 * @author Administrator
 * @create 2018/12/11
 * @since 1.0.0
 */
public class Streams {

    public static void main(String[] args) {
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        Stream.of("a1", "a2", "a3")
                .findFirst()
                .ifPresent(System.out::println);


        //只要使用 Stream.of() ，就可以从一系列对象引用中创建数据流。
        //除了普通的对象数据流，Java8还自带了特殊种类的流，用于处理基本数据类
        //型 int 、 long 和 double 。你可能已经猜到了它
        //是 IntStream 、 LongStream 和 DoubleStream 。
        //IntStream 可以使用 IntStream.range() 替换通常的 for 循环：

        IntStream.range(1, 4)
                .forEach(System.out::println);
        System.out.println("============================");
        Arrays.stream(new int[]{1, 2, 3})
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(s -> {
                    System.out.println(s);
                });
        System.out.println("============================");
        IntStream.range(1, 4)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);
        System.out.println("============================");
        IntStream.range(1, 4)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);
        System.out.println("============================");

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter:" + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));


        System.out.println("============================");

        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });

        System.out.println("============================");

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> {
                    System.out.println("forEach: " + s);
                });

        System.out.println("============================");


        Stream.of("d2", "a2", "b1", "b3", "c")
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println("============================");

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        //要克服这个限制，我们需要为每个我们想要执行的终止操作创建新的数据流调用
        //链。例如，我们创建一个数据流供应器，来构建新的数据流，并且设置好所有衔接
        //操作

        Supplier<Stream<String>> streamsSupplier =
                () -> Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));
        streamsSupplier.get().allMatch(s -> true);//ok
        streamsSupplier.get().noneMatch(s -> true);


    }
}