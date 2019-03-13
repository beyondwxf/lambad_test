/**
 * Copyright (C), 2018-2018
 * FileName: ComparatorsTest
 * Author:   Administrator
 * Date:     2018/12/7 16:49
 * Description: Comparator接口在早期的Java版本中非常著名。Java 8 为这个接口添加了不同的 默认方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lambdaTest3;

import java.util.Comparator;

/**
 * 〈一句话功能简述〉<br>
 * 〈Comparator接口在早期的Java版本中非常著名。Java 8 为这个接口添加了不同的 默认方法〉
 *
 * @author Administrator
 * @create 2018/12/7
 * @since 1.0.0
 */
public class ComparatorsTest {


    public static void main(String[] args) {
        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "WonderLand");
        comparator.compare(p1, p2);//>0
        comparator.reversed().compare(p1, p2);//<0
    }
}