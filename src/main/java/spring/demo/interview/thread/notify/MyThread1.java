package spring.demo.interview.thread.notify;

/**
 * @Package: spring.demo.interview.thread.notify
 * @ClassName: MyThread1
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2020/3/12 14:48
 * @UpdateDate: 2020/3/12 14:48
 */
public class MyThread1 implements Runnable {

    public int i = 10;

    @Override
    public void run() {
        Thread currThread = Thread.currentThread ();
        synchronized (currThread){
            ++i;
            System.out.println (this.getClass ().getName () + " i = " + i);
            currThread.notify ();
        }
    }
}
