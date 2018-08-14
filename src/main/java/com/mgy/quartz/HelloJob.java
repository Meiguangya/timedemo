package com.mgy.quartz;

import com.mchange.v2.lang.StringUtils;
import com.mgy.util.DateTimeUtil;
import org.quartz.*;

import java.util.Date;

public class HelloJob implements Job {

    private String message;
    private Float floatJobVal;
    private Double doubleTriVal;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("hello---" + DateTimeUtil.dateToStr(new Date()));
        //获取信息
        /*JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        System.out.println("name: " + jobKey.getName());
        System.out.println("group: " + jobKey.getGroup());
        System.out.println("class: " + jobKey.getName());

        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        System.out.println("my trigger name and group are: " + triggerKey.getName() + "," + triggerKey.getGroup());*/

        //通过获取map拿到值
        /*JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        JobDataMap triggerDateMap = jobExecutionContext.getTrigger().getJobDataMap();

        String jobMsg = jobDataMap.getString("message");
        Float floatVal = jobDataMap.getFloat("FloatJobValue");

        String triMsg = triggerDateMap.getString("message");
        Double doubleVal = triggerDateMap.getDouble("double");*/

        /*System.out.println("floatVal: " + floatJobVal);
        System.out.println("triMsg: " + message);
        System.out.println("doubleVal: " + doubleTriVal);*/
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Float getFloatJobVal() {
        return floatJobVal;
    }

    public void setFloatJobVal(Float floatJobVal) {
        this.floatJobVal = floatJobVal;
    }

    public Double getDoubleTriVal() {
        return doubleTriVal;
    }

    public void setDoubleTriVal(Double doubleTriVal) {
        this.doubleTriVal = doubleTriVal;
    }
}
