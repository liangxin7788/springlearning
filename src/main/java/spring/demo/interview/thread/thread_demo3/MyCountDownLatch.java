package spring.demo.interview.thread.thread_demo3;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;

import java.util.concurrent.CountDownLatch;

/**
 * @Package: spring.demo.interview.thread.thread_demo3
 * @ClassName: MyCountDownLatch
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/8/2 16:40
 * @UpdateDate: 2019/8/2 16:40
 */
public class MyCountDownLatch implements Runnable {

    private String name;
    private Integer age;
    private CountDownLatch count;
    private CountUtil countUtil;


    public MyCountDownLatch(String name, Integer age, CountDownLatch count, CountUtil countUtil) {
        this.name = name;
        this.age = age;
        this.count = count;
        this.countUtil = countUtil;
    }

    @Override
    public void run() {
        try {
            countUtil.countAge(age);
        }catch (Exception e){

        }finally {
            count.countDown();
        }
    }

}
