/**
 * Copyright (C), 2018-2018
 * FileName: Test1
 * Author:   Administrator
 * Date:     2018/12/6 15:58
 * Description: 1
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wxf.lambdaTest1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈1〉
 *
 * @author Administrator
 * @create 2018/12/6
 * @since 1.0.0
 */
public class Test1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
//                Collections.sort(names, new Comparator<String>() {
//                    @Override
//                    public int compare(String a, String b) {
//                        return b.compareTo(a);
//                    }
//                });

        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        Collections.sort(names, (a, b) -> b.compareTo(a));

    }
}