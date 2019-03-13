/**
 * Copyright (C), 2018-2018
 * FileName: SuppliersTest
 * Author:   Administrator
 * Date:     2018/12/7 16:17
 * Description: Supplier接口产生一个给定类型的结果。与Function不同的是，Supplier没有输入参 数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lambdaTest3;


import java.util.function.Supplier;

/**
 * 〈一句话功能简述〉<br>
 * 〈Supplier接口产生一个给定类型的结果。与Function不同的是，Supplier没有输入参 数〉
 *
 * @author Administrator
 * @create 2018/12/7
 * @since 1.0.0
 */
public class SuppliersTest {
    public static void main(String[] args) {
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();// new Person
    }

}