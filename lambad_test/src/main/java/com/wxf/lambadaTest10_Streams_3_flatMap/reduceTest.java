/**
 * Copyright (C), 2018-2018
 * FileName: reduceTest
 * Author:   Administrator
 * Date:     2018/12/14 11:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package  com.wxf.lambadaTest10_Streams_3_flatMap;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2018/12/14
 * @since 1.0.0
 */
//reduce
//归约操作将所有流中的元素组合为单一结果。Java8支持三种不同类型
//的 reduce 方法。第一种将流中的元素归约为流中的一个元素。让我们看看我们如
//何使用这个方法来计算出最老的人：
public class reduceTest {

    public static void main(String[] args) {
        Person persion1 = new Person("aa", 12);
        Person persion2 = new Person("aa1", 123);
        Person persion3 = new Person("aa2", 124);
        List<Person> persons = new ArrayList<Person>();
        persons.add(persion1);
        persons.add(persion2);
        persons.add(persion3);

        persons.stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
                .ifPresent(System.out::println);
        //reduce 方法接受 BinaryOperator 积累函数。它实际上是两个操作数类型相同
        //的 BiFunction 。 BiFunction 就像是 Function ，但是接受两个参数。示例中
        //的函数比较两个人的年龄，来返回年龄较大的人。
        //第二个 reduce 方法接受一个初始值，和一个 BinaryOperator 累加器。这个方
        //法可以用于从流中的其它 Person 对象中构造带有聚合后名称和年龄的
        //新 Person 对象。

        Person result =
                persons
                        .stream()
                        .reduce(new Person("", 0), (p1, p2) -> {
                            p1.age += p2.age;
                            p1.name += p2.name;
                            return p1;
                        });
        System.out.printf("name=%s;age=%s", result.name, result.age);
        //第三个 reduce 对象接受三个参数：初始值， BiFunction 累加器
        //和 BinaryOperator 类型的组合器函数。由于初始值的类型不一定为 Person ，
        //我们可以使用这个归约函数来计算所有人的年龄总和。：

        Integer ageSum = persons
                .stream()
                .reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);

        System.out.println("ageSum:" + ageSum);


        Integer ageSuma = persons
                .stream()
                .reduce(0,
                        (sum, p) -> {
                            System.out.format("accumulator: sum=%s; person=%s\n"
                                    , sum, p);
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;
                        });
        //// accumulator: sum=0; person=Max
        //// accumulator: sum=18; person=Peter
        //// accumulator: sum=41; person=Pamela
        //// accumulator: sum=64; person=David
        //你可以看到，累加器函数做了所有工作。它首先使用初始值 0 和第一个人Max来
        //调用累加器。接下来的三步中 sum 会持续增加，直到76。
        //等一下。好像组合器从来没有调用过？以并行方式执行相同的流会揭开这个秘密：


        Integer ageSums = persons
                .parallelStream()
                .reduce(0,
                        (sum, p) -> {
                            System.out.format("accumulator: sum=%s; person=%s\n"
                                    , sum, p);
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;
                        });
        // accumulator: sum=0; person=Pamela
        // accumulator: sum=0; person=David
        // accumulator: sum=0; person=Max
        // accumulator: sum=0; person=Peter
        // combiner: sum1=18; sum2=23
        // combiner: sum1=23; sum2=12
        // combiner: sum1=41; sum2=35
        //        这个流的并行执行行为会完全不同。现在实际上调
    }


}