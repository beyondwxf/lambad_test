/**
 * Copyright (C), 2018-2018
 * FileName: TheadTest2
 * Author:   Administrator
 * Date:     2018/12/17 14:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2018/12/17
 * @since 1.0.0
 */
public class TheadTest2 {
    public static void main(String[] args) {
        Callable<Integer> task = () -> {
            TimeUnit.SECONDS.sleep(1);
            return 123;
        };

    }
}