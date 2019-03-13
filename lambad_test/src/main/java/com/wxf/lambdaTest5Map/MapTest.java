/**
 * Copyright (C), 2018-2018
 * FileName: MapTest
 * Author:   Administrator
 * Date:     2018/12/10 14:44
 * Description: 正如前面已经提到的那样，map是不支持流操作的。而更新后的map现在则支持多 种实用的新方法，来完成常规的任务。
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lambdaTest5Map;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈正如前面已经提到的那样，map是不支持流操作的。而更新后的map现在则支持多 种实用的新方法，来完成常规的任务。〉
 *
 * @author Administrator
 * @create 2018/12/10
 * @since 1.0.0
 */
public class MapTest {
    public static void main(String[] args) {
        //Map
        //正如前面已经提到的那样，map是不支持流操作的。而更新后的map现在则支持多
        //种实用的新方法，来完成常规的任务。
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
        map.forEach((id, val) -> System.out.println(val));


        //上面的代码风格是完全自解释的：putIfAbsent避免我们将null写入；forEach接受一
        //个消费者对象，从而将操作实施到每一个map中的值上。
        //下面的这个例子展示了如何使用函数来计算map的编码
        map.computeIfPresent(3, (num, val) -> val + num);
        map.get(3); // val33
        map.computeIfPresent(9, (num, val) -> null);
        map.containsKey(9); // false
        map.computeIfAbsent(23, num -> "val" + num);
        map.containsKey(23); // true
        map.computeIfAbsent(3, num -> "bam");
        map.get(3); // val33

        map.remove(3, "val3");
        map.get(3); //val33

        map.remove(3, "val33");
        map.get(3);//null

        map.getOrDefault(42, "not found");
        //将map中的实例合并也是非常容易的：

        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        map.get(9);

        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        map.get(9);


    }
}