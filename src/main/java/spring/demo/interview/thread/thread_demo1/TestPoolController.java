package spring.demo.interview.thread.thread_demo1;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Package: spring.demo.interview.thread
 * @ClassName: Pool
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/8/2 15:19
 * @UpdateDate: 2019/8/2 15:19
 */
@Slf4j
@RestController
@RequestMapping("/testPool")
public class TestPoolController {

    private final static ExecutorService executors = Executors.newFixedThreadPool(16); // 线程池

    @GetMapping("/main")
    public static void main() {
        List<Future<?>> futures = new ArrayList<>();
        for (int i =0; i < 10; i++){
            Future<?> addFuture = executors.submit(new MyRunnable("liangxin", 1 + i, false));
            futures.add(addFuture);
            log.info("添加用户线程执行完一个！");
        }
        if (ObjectUtils.isNotEmpty(futures)) {
            for (Future<?> future : futures) {
                try {
                    future.get(); // 等待子线程跑完
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
