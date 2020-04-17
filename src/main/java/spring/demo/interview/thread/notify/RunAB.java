package spring.demo.interview.thread.notify;

/**
 * @Package: spring.demo.interview.thread.notify
 * @ClassName: RunAB
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2020/3/12 16:39
 * @UpdateDate: 2020/3/12 16:39
 */
public class RunAB {

    public static void main(String[] args) {
        try {
            Object lock = new Object();
            ThreadA a = new ThreadA(lock);
            a.start();
            Thread.sleep(50);
            ThreadB b = new ThreadB(lock);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
