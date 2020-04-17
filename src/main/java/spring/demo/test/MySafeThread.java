package spring.demo.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Package: spring.demo.test
 * @ClassName: MySafeThread
 * @Description: 线程安全的计数器
 * @Author: liangxin
 * @CreateDate: 2019/11/7 16:12
 * @UpdateDate: 2019/11/7 16:12
 */
public class MySafeThread implements Runnable {

    //设置计数器初始值为0
    private static AtomicInteger count = new AtomicInteger(0);

    private static boolean flag = true;

    @Override
    public void run(){
        while (flag){
            try {
                Thread.sleep(1); // 防止打印过快导致的顺序混乱
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MySafeThread.calc();
        }
    }
    //计数 注意加锁sychronized
    private synchronized static void calc(){
        //count 为计数后的值
        if (count.get()<1000){
            //自增1 返回更新后的值
            int c = count.incrementAndGet();
            //现场名称与自增后的值
            System.out.println(Thread.currentThread().getName()+":"+c);
        }else {
            flag = false;
        }
    }
    //开启五个线程进行计数
    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            MySafeThread mySafeThread = new MySafeThread();
            Thread t = new Thread(mySafeThread);
            t.start();
        }
    }

}
