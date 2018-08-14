package com.mgy.quartz;

import com.mgy.util.DateTimeUtil;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {
        //1.创建一个JobDetail 将该实例与HelloJob 绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("helloJob", "group1")
                /*.usingJobData("message","hello myjob1")
                .usingJobData("floatJobVal",3.14F)*/
                .build();

        //可以获取jobdetail的属性
        /*System.out.println("name:" + jobDetail.getKey().getName());
        System.out.println("group:" + jobDetail.getKey().getGroup());
        System.out.println("class:" + jobDetail.getJobClass().getName());*/

        //2.创建一个trigger实例,定义Job怎么执行
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(2)
                .repeatForever();

        //使触发器第一次触发时间为三秒后的时间,终止时间为6秒后
        Date date = new Date();
        Long now = date.getTime();
        Date start = new Date(now + 3000);
        Date end = new Date(now + 6000);
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("helloTrigger", "group1")
                /*.usingJobData("message","hello trigger1")
                .usingJobData("doubleTriVal",2.0D)*/
                //.startNow()
                .startAt(start)
                .endAt(end)
                .withSchedule(simpleScheduleBuilder).build();

        // 创建Scheduler实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        System.out.println("scheduler start " + DateTimeUtil.dateToStr(new Date()));
        scheduler.scheduleJob(jobDetail, trigger);

    }
}
