package org.ibase4j.scheduler.manager;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.ibase4j.core.util.InstanceUtil;
import org.ibase4j.dao.scheduler.TaskSchedulerMapper;
import org.ibase4j.model.scheduler.TaskGroup;
import org.ibase4j.model.scheduler.TaskScheduler;
import org.ibase4j.service.SchedulerService;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

/**
 * 作业加载器
 *
 * @author ShenHueJie
 * @version 2016年5月27日 下午4:31:52
 */
public class TriggerLoader {
    @Autowired
    private SchedulerService schedulerService;

    @Autowired
    private TaskSchedulerMapper taskSchedulerMapper;

    private String taskType; // 作业类型

    private Class<? extends Job> jobClass; // 执行作业的类

    public TriggerLoader(String taskType, Class<? extends Job> jobClass) {
        this.taskType = taskType;
        this.jobClass = jobClass;
    }

    public Map<Trigger, JobDetail> loadTriggers() {
        Map<String, Object> params = InstanceUtil.newHashMap();
        params.put("taskType", taskType);
        List<String> taskSchedulerIds = taskSchedulerMapper.selectIdByMap(params);
        Map<Trigger, JobDetail> resultMap = InstanceUtil.newHashMap();
        for (String id : taskSchedulerIds) {
            TaskScheduler taskScheduler = schedulerService.getSchedulerById(id);
            TaskGroup taskGroup = schedulerService.getGroupById(taskScheduler.getGroupId());
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("id", taskScheduler.getId());
            jobDataMap.put("enable", taskScheduler.getEnable());
            jobDataMap.put("contactEmail", taskScheduler.getContactEmail());
            jobDataMap.put("desc", taskGroup.getGroupDesc() + ":" + taskScheduler.getTaskDesc());
            JobDetail jobDetail = JobBuilder.newJob(jobClass)
                    .withIdentity(taskScheduler.getTaskName(), taskGroup.getGroupName())
                    .withDescription(taskScheduler.getTaskDesc()).storeDurably(true).usingJobData(jobDataMap).build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withSchedule(CronScheduleBuilder.cronSchedule(taskScheduler.getTaskCron()))
                    .withIdentity(taskScheduler.getTaskName(), taskGroup.getGroupName())
                    .withDescription(taskGroup.getGroupDesc()).forJob(jobDetail).usingJobData(jobDataMap).build();

            resultMap.put(trigger, jobDetail);
        }
        return resultMap;
    }
}
