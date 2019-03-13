/**
 * Copyright (C), 2018-2018
 * FileName: flatMapTest
 * Author:   Administrator
 * Date:     2018/12/13 15:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wxf.lambadaTest10_Streams_3_flatMap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2018/12/13
 * @since 1.0.0
 */
public class flatMapTest {
    public static void main(String[] args) {
        List<Foo> foos = new ArrayList<>();

        //create foos
        IntStream
                .range(1, 4)
                .forEach(i -> foos.add(new Foo("Foo" + i)));


        //create bars
        foos.forEach(foo ->
                IntStream
                        .range(1, 4)
                        .forEach(i -> foo.bars.add(new Bar("Bar" + i + "<-" + foo.name)))
        );


        //现在我们拥有了含有三个 foo 的列表，每个都含有三个 bar 。
        //flatMap 接受返回对象流的函数。所以为了处理每个 foo 上的 bar 对象，我们
        //需要传递相应的函数：
        foos.stream()
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));

        // Bar1 <- Foo1
        // Bar2 <- Foo1
        // Bar3 <- Foo1
        // Bar1 <- Foo2
        // Bar2 <- Foo2
        // Bar3 <- Foo2
        // Bar1 <- Foo3
        // Bar2 <- Foo3
        // Bar3 <- Foo3


        IntStream.range(1, 4)
                .mapToObj(i -> new Foo("Foo" + i))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
                        .forEach(f.bars::add))
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));


    }


}