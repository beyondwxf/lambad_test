/**
 * Copyright (C), 2018-2018
 * FileName: SteamsTest
 * Author:   Administrator
 * Date:     2018/12/7 17:22
 * Description: java.util.Stream表示了某一种元素的序列，在这些元素上可以进行各种操作。 Stream操作可以是中间操作，也可以是完结操作。完结操作会返回一个某种类型的 值，而中间操作会返回流对象本身，并且你可以通过多次调用同一个流操作方法来 将操作结果串起来（就像StringBuffer的append方法一样————译者注）。 Stream是在一个源的基础上创建出来的，例如java.util.Collection中的list或者 set（map不能作为Stream的源）。Stream操作往往可以通过顺序或者并行两种方 式来执行。
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lambdaTest4_Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈java.util.Stream表示了某一种元素的序列，在这些元素上可以进行各种操作。
 * Stream操作可以是中间操作，也可以是完结操作。完结操作会返回一个某种类型的 值，
 * 而中间操作会返回流对象本身，并且你可以通过多次调用同一个流操作方法来 将操作结果串起来
 * （就像StringBuffer的append方法一样————译者注）。
 * Stream是在一个源的基础上创建出来的，例如java.util.Collection中的list或者 set（map不能作为Stream的源）。
 * Stream操作往往可以通过顺序或者并行两种方 式来执行。〉
 *
 * @author Administrator
 * @create 2018/12/7
 * @since 1.0.0
 */
public class SteamsTest {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        //Java 8中的Collections类的功能已经有所增强，你可以之直接通过调用
        //Collections.stream()或者Collection.parallelStream()方法来创建一个流对象。下面
        //的章节会解释这个最常用的操作。


        //Filter
        //Filter接受一个predicate接口类型的变量，并将所有流对象中的元素进行过滤。该操
        //作是一个中间操作，因此它允许我们在返回结果的基础上再进行其他的流操作
        //（forEach）。ForEach接受一个function接口类型的变量，用来执行对每一个元素
        //的操作。ForEach是一个中止操作。它不返回流，所以我们不能再调用其他的流操
        //作。
        stringCollection
                .stream()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::print);


        //Sorted
        //Sorted是一个中间操作，能够返回一个排过序的流对象的视图。流对象中的元素会
        //默认按照自然顺序进行排序，除非你自己指定一个Comparator接口来改变排序规
        //则
        stringCollection
                .stream()
                .sorted()
                .filter(s -> s.startsWith("s"))
                .forEach(System.out::print);
        //一定要记住，sorted只是创建一个流对象排序的视图，而不会改变原来集合中元素
        //的顺序。原来string集合中的元素顺序是没有改变的。

        //Map
        //map是一个对于流对象的中间操作，通过给定的方法，它能够把流对象中的每一个
        //元素对应到另外一个对象上。下面的例子就演示了如何把每个string都转换成大写
        //的string. 不但如此，你还可以把每一种对象映射成为其他类型。对于带泛型结果的
        //流对象，具体的类型还要由传递给map的泛型方法来决定。
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::print);


        //Match
        //匹配操作有多种不同的类型，都是用来判断某一种规则是否与流对象相互吻合的。
        //所有的匹配操作都是终结操作，只返回一个boolean类型的结果。

        boolean anyStartsWithA =
                stringCollection
                        .stream()
                        .anyMatch(s -> s.startsWith("a"));//true
        System.out.println(anyStartsWithA);

        boolean allStratsWithA =
                stringCollection
                        .stream()
                        .allMatch(s -> s.startsWith("a"));//false
        System.out.println(allStratsWithA);

        boolean noneStartsWithZ =
                stringCollection
                        .stream()
                        .noneMatch(s -> s.startsWith("z"));
        System.out.println(noneStartsWithZ); //true


        //Count
        //Count是一个终结操作，它的作用是返回一个数值，用来标识当前流对象中包含的
        //元素数量。

        long startsWithB =
                stringCollection
                        .stream()
                        .filter(s -> s.startsWith("b"))
                        .count();
        System.out.println(startsWithB); //3

        //Reduce
        //该操作是一个终结操作，它能够通过某一个方法，对元素进行削减操作。该操作的
        //结果会放在一个Optional变量里返回。
        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
        // "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"


        //Parallel Streams
        //像上面所说的，流操作可以是顺序的，也可以是并行的。顺序操作通过单线程执
        //行，而并行操作则通过多线程执行。
        //下面的例子就演示了如何使用并行流进行操作来提高运行效率，代码非常简单。
        //首先我们创建一个大的list，里面的元素都是唯一的：

        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        //现在，我们测量一下对这个集合进行排序所使用的时间。
        //顺序排序
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms",
                millis));
        // sequential sort took: 899 ms

        //并行排序
        long t2 = System.nanoTime();
        long countT2 = values.parallelStream().sorted().count();
        System.out.println(countT2);
        long t3 = System.nanoTime();
        long millisT3 = TimeUnit.NANOSECONDS.toMillis(t3 - t2);
        System.out.println(String.format("parallel sort took: %d ms", millisT3));
    }

}