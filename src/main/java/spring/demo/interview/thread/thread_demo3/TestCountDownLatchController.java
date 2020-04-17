package spring.demo.interview.thread.thread_demo3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.demo.learn.utils.SpringUtil;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Package: spring.demo.interview.thread.thread_demo3
 * @ClassName: TestCountDownLatchController
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/8/2 16:45
 * @UpdateDate: 2019/8/2 16:45
 */
@RestController
@RequestMapping("testCountDownLatch")
public class TestCountDownLatchController {

    private final static ExecutorService executors = Executors.newFixedThreadPool(6); // 线程池

    @RequestMapping("/test")
    public void test(){
        CountUtil countUtil = new CountUtil();
        try {
            CountDownLatch countDownLatch = new CountDownLatch(10);
            for (int i =0; i < 10; i++){
                executors.execute(new MyCountDownLatch("liangxin", 1 + i, countDownLatch, countUtil));
            }
            countDownLatch.await();
//            executors.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("统计结果：" + countUtil.getResult());
    }

    public static void main(String[] args) throws InterruptedException {
        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                            System.out.println("aaa");
                        }
                     }, "ftf" + i).start();
                }
            }
         }, "ftf");
        t.start();
        t.join();
    }

}
