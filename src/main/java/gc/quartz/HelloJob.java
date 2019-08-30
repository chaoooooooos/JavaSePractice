package gc.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("现在是北京时间:" + DateUtil.getCurrDateTime() + " - helloJob任务执行");
    }

}
