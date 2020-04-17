package spring.demo.interview.thread.thread_demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.demo.interview.thread.service.ITestUserService;
import spring.demo.interview.thread.thread_demo1.TestUser;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Package: spring.demo.interview.thread.thread_demo2
 * @ClassName: CountDownLatchTest
 * @Description: 多线程 CountDownLatch 测试类
 * @Author: liangxin
 * @CreateDate: 2019/8/2 16:16
 * @UpdateDate: 2019/8/2 16:16
 */
@RestController
@RequestMapping("/countDownLatch")
public class CountDownLatchTest {

    @Autowired
    private ITestUserService testUserService;

    private final static ExecutorService executors = Executors.newFixedThreadPool(6); // 线程池

    @GetMapping("/test")
    public void test(String names[]) {
        CountDownLatch latch = new CountDownLatch(names.length);
        try {
            for (int i = 0; i < names.length; i++) {
                String name = names[i];
                TestUser testUser = new TestUser();
                executors.submit(new Runnable() {
                    @Override
                    public void run() {
                        // do biz with name
                        if (!name.contains(".")) {
                            testUser.setUserName(name);
                            testUserService.addUser(testUser);
                        }
                        latch.countDown();
                    }
                });
            }
            latch.await();
            executors.shutdown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
