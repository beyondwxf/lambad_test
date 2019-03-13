/**
 * Copyright (C), 2018-2018
 * FileName: ThreadTest1
 * Author:   Administrator
 * Date:     2018/12/17 13:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2018/12/17
 * @since 1.0.0
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();


        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });

        //Executors 类提供了便利的工厂方法来创建不同类型的 executor services。在这
        //个示例中我们使用了一个单线程线程池的 executor。
        //代码运行的结果类似于上一个示例，但是当运行代码时，你会注意到一个很大的差
        //别：Java进程从没有停止！Executors必须显式的停止-否则它们将持续监听新的任
        //务。
        //ExecutorService 提供了两个方法来达到这个目的—— shutdwon() 会等待正
        //在执行的任务执行完而 shutdownNow() 会终止所有正在执行的任务并立即关闭
        //execuotr。
        //这是我喜欢的通常关闭executors的方式：
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }

}