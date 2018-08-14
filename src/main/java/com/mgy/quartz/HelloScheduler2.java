package com.mgy.quartz;

import com.mgy.util.DateTimeUtil;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class HelloScheduler2 {
    public static void main(String[] args) throws SchedulerException {
        //1.创建JobDetail
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("helloJob", "group1").build();
        //2.创建SimpleTrigger
        //距离当前四秒第一次执行，且只执行一次
        Date currentDate = new Date();
        Long now = currentDate.getTime();

        SimpleTrigger simpleTrigger = (SimpleTrigger) TriggerBuilder.newTrigger().withIdentity("helloTrigger", "group1")
                .startAt(new Date(now+4000))
                .endAt(new Date(now+6000))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY))
                .build();

        // 创建Scheduler实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        System.out.println("scheduler start " + DateTimeUtil.dateToStr(new Date()));
        scheduler.scheduleJob(jobDetail, simpleTrigger);
    }
}
