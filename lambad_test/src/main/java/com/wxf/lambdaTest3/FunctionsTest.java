/**
 * Copyright (C), 2018-2018
 * FileName: FunctionsTest
 * Author:   Administrator
 * Date:     2018/12/7 16:11
 * Description: Function接口接收一个参数，并返回单一的结果。默认方法可以将多个函数串在一 起（compse, andThen
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lambdaTest3;

import java.util.function.Function;

/**
 * 〈一句话功能简述〉<br>
 * 〈Function接口接收一个参数，并返回单一的结果。默认方法可以将多个函数串在一 起（compse, andThen〉
 *
 * @author Administrator
 * @create 2018/12/7
 * @since 1.0.0
 */
public class FunctionsTest {
    public static void main(String[] args) {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backtoString = toInteger.andThen(String::valueOf);
        System.out.println(backtoString.apply("123"));
    }
}