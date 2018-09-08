package service.impl;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("jobService")
public class JobServiceImpl extends QuartzJobBean {
    @Override
    public void executeInternal(JobExecutionContext jobexecutioncontext) throws JobExecutionException {
        System.out.println("测试Quartz：" + new Date());
    }
}
