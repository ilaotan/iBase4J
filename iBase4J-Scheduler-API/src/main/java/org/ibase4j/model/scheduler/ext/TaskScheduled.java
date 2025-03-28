package org.ibase4j.model.scheduler.ext;

import java.io.Serializable;
import java.util.Date;

/**
 * 计划任务信息
 *
 * @author ShenHuaJie
 * @version $Id: ScheduleJob.java, v 0.1 2015-1-19 下午7:35:44 ShenHuaJie Exp $
 */
@SuppressWarnings("serial")
public class TaskScheduled implements Serializable {

    /**
     * 任务id
     */
    private String id;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务分组
     */
    private String taskGroup;

    /**
     * 任务状态 0禁用 1启用 2删除
     */
    private String status;

    /**
     * 任务运行时间表达式
     */
    private String taskCron;

    /**
     * 最后一次执行时间
     */
    private Date previousFireTime;

    /**
     * 下次执行时间
     */
    private Date nextFireTime;

    /**
     * 任务描述
     */
    private String desc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskGroup() {
        return taskGroup;
    }

    public void setTaskGroup(String taskGroup) {
        this.taskGroup = taskGroup;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskCron() {
        return taskCron;
    }

    public void setTaskCron(String taskCron) {
        this.taskCron = taskCron;
    }

    public Date getPreviousFireTime() {
        return previousFireTime;
    }

    public void setPreviousFireTime(Date previousFireTime) {
        this.previousFireTime = previousFireTime;
    }

    public Date getNextFireTime() {
        return nextFireTime;
    }

    public void setNextFireTime(Date nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
