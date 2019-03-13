/**
 * Copyright (C), 2018-2018
 * FileName: Consumers
 * Author:   Administrator
 * Date:     2018/12/7 16:23
 * Description: Consumer代表了在一个输入参数上需要进行的操作。
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lambdaTest3;

import java.util.function.Consumer;

/**
 * 〈一句话功能简述〉<br>
 * 〈Consumer代表了在一个输入参数上需要进行的操作。〉
 *
 * @author Administrator
 * @create 2018/12/7
 * @since 1.0.0
 */
public class ConsumersTest {
    public static void main(String[] args) {
        Consumer<Person> greeter = (p) -> System.out.println("Hello," + p.firstName);
        greeter.accept(new Person("luke", "Skywalker"));
    }


}