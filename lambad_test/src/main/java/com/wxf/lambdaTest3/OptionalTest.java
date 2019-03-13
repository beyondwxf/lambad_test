/**
 * Copyright (C), 2018-2018
 * FileName: OptionalTest
 * Author:   Administrator
 * Date:     2018/12/7 17:12
 * Description: 不是一个函数式接口，而是一个精巧的工具接口，用来防止 NullPointerException产生。这个概念在下一节会显得很重要，所以我们在这里快速 地浏览一下Optional的工作原理。 Optional是一个简单的值容器，这个值可以是null，也可以是non-null。考虑到一个 方法可能会返回一个non-null的值，也可能返回一个空值。为了不直接返回null，我 们在Java 8中就返回一个Optional.
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lambdaTest3;

import java.util.Optional;

/**
 * 〈一句话功能简述〉<br>
 * 〈不是一个函数式接口，而是一个精巧的工具接口，用来防止 NullPointerException产生。这个概念在下一节会显得很重要，所以我们在这里快速 地浏览一下Optional的工作原理。 Optional是一个简单的值容器，这个值可以是null，也可以是non-null。考虑到一个 方法可能会返回一个non-null的值，也可能返回一个空值。为了不直接返回null，我 们在Java 8中就返回一个Optional.〉
 *
 * @author Administrator
 * @create 2018/12/7
 * @since 1.0.0
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("bam");
        optional.isPresent(); //true;
        optional.get();      //"bam"
        optional.orElse("fallbacksssssss"); //"bam"
        optional.ifPresent((s -> System.out.println(s.charAt(0)))); //"b"
    }
}