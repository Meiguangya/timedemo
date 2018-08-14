package com.mgy.quartz;

import com.mgy.util.DateTimeUtil;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class HelloScheduler3 {

    public static void main(String[] args) throws SchedulerException {
        //1.创建JobDetail
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("helloJob", "group1").build();
        //2.创建SimpleTrigger
        //每秒
        CronTrigger simpleTrigger = (CronTrigger) TriggerBuilder.newTrigger().withIdentity("helloTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
                .build();

        // 创建Scheduler实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        System.out.println("scheduler start " + DateTimeUtil.dateToStr(new Date()));
        scheduler.scheduleJob(jobDetail, simpleTrigger);
    }
}
