package spring.demo.test;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

import com.estone.erp.job.executor.service.jobhandler.AbstractJobHandler;


import lombok.extern.slf4j.Slf4j;

/**
 * 项目分布式的，防止定时任务被多次触发，同一管理链接：http://192.168.3.164:8080/xxl-job-admin/（测试）
 * @author liangxin
 * 2019年4月17日 上午10:30:35
 */
@Slf4j
@Component
@JobHandler("productDemoJob")
public class ProductDemoJob extends AbstractJobHandler{

    public ProductDemoJob() {
        super("productDemoJob");
    }

    @Override
    public ReturnT<String> run(String arg0) throws Exception {
        XxlJobLogger.log("分布式定时任务启动测试完毕！");
        int i = 1/0;
        ReturnT<String> t = new ReturnT<String>();
        t.setMsg("本轮任务执行完毕");
        return t;
    }

}
