/**
 * Copyright (C), 2018-2018
 * FileName: Person
 * Author:   Administrator
 * Date:     2018/12/11 16:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wxf.lambadaTest10_Streams_3_flatMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2018/12/11
 * @since 1.0.0
 */
public class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }
}