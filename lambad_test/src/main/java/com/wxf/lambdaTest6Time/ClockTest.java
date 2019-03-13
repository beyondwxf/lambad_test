/**
 * Copyright (C), 2018-2018
 * FileName: ClockTest
 * Author:   Administrator
 * Date:     2018/12/11 10:29
 * Description: 时间日期API Java 8 包含了全新的时间日期API，这些功能都放在了java.time包下。新的时间日 期API是基于Joda-Time库开发的，但是也不尽相同。下面的例子就涵盖了大多数新 的API的重要部分。
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.lambdaTest6Time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * 〈一句话功能简述〉<br>
 * 〈时间日期API Java 8 包含了全新的时间日期API，这些功能都放在了java.time包下。新的时间日 期API是基于Joda-Time库开发的，但是也不尽相同。下面的例子就涵盖了大多数新 的API的重要部分。〉
 * Clock提供了对当前时间和日期的访问功能。Clock是对当前时区敏感的，并可用于
 * 替代System.currentTimeMillis()方法来获取当前的毫秒时间。当前时间线上的时刻
 * 可以用Instance类来表示。Instance也能够用于创建原先的java.util.Date对象。
 *
 * @author Administrator
 * @create 2018/12/11
 * @since 1.0.0
 */
public class ClockTest {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant); //legacy java.util.Date

        //时区类可以用一个ZoneId来表示。时区类的对象可以通过静态工厂方法方便地获
        //取。时区类还定义了一个偏移量，用来在当前时刻或某时间与目标时区时间之间进
        //行转换。

        System.out.println(ZoneId.getAvailableZoneIds());
        //prints all available timezone ids

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

        // ZoneRules[currentStandardOffset=+01:00]
        // ZoneRules[currentStandardOffset=-03:00]


        //LocalTime
        //本地时间类表示一个没有指定时区的时间，例如，10 p.m.或者17：30:15，下面的
        //例子会用上面的例子定义的时区创建两个本地时间对象。然后我们会比较两个时
        //间，并计算它们之间的小时和分钟的不同。
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        System.out.println(now1.isBefore(now2)); //false;

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println(hoursBetween); //-3
        System.out.println(minutesBetween); //-239


        //LocalTime是由多个工厂方法组成，其目的是为了简化对时间对象实例的创建和操
        //作，包括对时间字符串进行解析的操作。

        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late); //23.59.59

        DateTimeFormatter germanFormatter =
                DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.SHORT)
                        .withLocale(Locale.GERMAN);

//        LocalTime leetTime = LocalTime.parse("13:37",germanFormatter);
//        System.out.println(leetTime); // 13:37


        //LocalDate
        //本地时间表示了一个独一无二的时间，例如：2014-03-11。这个时间是不可变的，
        //与LocalTime是同源的。下面的例子演示了如何通过加减日，月，年等指标来计算
        //新的日期。记住，每一次操作都会返回一个新的时间对象。

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);

        //解析字符串并形成LocalDate对象，这个操作和解析LocalTime一样简单。

        DateTimeFormatter germanFormatter2 =
                DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.MEDIUM)
                        .withLocale(Locale.GERMAN);
        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter2);
        System.out.println(xmas); // 2014-12-24


        //LocalDateTime
        //LocalDateTime表示的是日期-时间。它将刚才介绍的日期对象和时间对象结合起
        //来，形成了一个对象实例。LocalDateTime是不可变的，与LocalTime和LocalDate
        //的工作原理相同。我们可以通过调用方法来获取日期时间对象中特定的数据域。


        LocalDateTime sylverter = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

        DayOfWeek dayOfWeek1 = sylverter.getDayOfWeek();
        System.out.println(dayOfWeek);

        Month month = sylverter.getMonth();
        System.out.println(month);

        long minuteOfDay = sylverter.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);

        //如果再加上的时区信息，LocalDateTime能够被转换成Instance实例。Instance能够
        //被转换成以前的java.util.Date对象。
        Instant instant1 = sylverter
                .atZone(ZoneId.systemDefault())
                .toInstant();

        Date legacyDate1 = Date.from(instant1);
        System.out.println(legacyDate1);

        //// Wed Dec 31 23:59:59 CET 2
        //014
        //格式化日期-时间对象就和格式化日期对象或者时间对象一样。除了使用预定义的格
        //式以外，我们还可以创建自定义的格式化对象，然后匹配我们自定义的格式。

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd,yyy - HH:mm");
        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
        String string = formatter.format(parsed);
        System.out.println(string);


    }
}