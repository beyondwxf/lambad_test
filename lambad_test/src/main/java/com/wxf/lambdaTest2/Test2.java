/**
 * Copyright (C), 2018-2018
 * FileName: Test2
 * Author:   Administrator
 * Date:     2018/12/7 14:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lambdaTest2;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2018/12/7
 * @since 1.0.0
 */
public class Test2 {
    public static void main(String[] args) {


//        PersonFactory p = new PersonFactory() {
//            @Override
//            public Person create(String firstName, String lastName) {
//                return null;
//            }
//        };

        PersonFactory<Person> p1 = Person::new;
        Person person = p1.create("aa", "bb");
    }
}