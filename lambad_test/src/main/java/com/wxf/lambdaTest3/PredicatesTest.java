/**
 * Copyright (C), 2018-2018
 * FileName: PredicatesTest
 * Author:   Administrator
 * Date:     2018/12/7 15:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lambdaTest3;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Predicate是一个布尔类型的函数，该函数只有一个输入参数。Predicate接口包含
 * 了多种默认方法，用于处理复杂的逻辑动词（and, or，negate）
 * 〈〉
 *
 * @author Administrator
 * @create 2018/12/7
 * @since 1.0.0
 */
public class PredicatesTest {

    public static void main(String[] args) {
        Predicate<String> predicate = s -> s.length() > 0;
        predicate.test("foo");
        System.out.println(predicate.test("foo"));
        predicate.negate().test("");
        System.out.println(predicate.negate().test("sss"));
        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

    }
}