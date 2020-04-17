package spring.demo.interview.thread.notify;

/**
 * @Package: spring.demo.interview.thread.notify
 * @ClassName: MyThread2
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2020/3/12 14:50
 * @UpdateDate: 2020/3/12 14:50
 */
public class MyThread2 extends Thread {

    private int count = 5;

    @Override
    public void run() {
        synchronized (this){
            count--;
            System.out.println(this.currentThread().getName() + " count:" + count);
        }
    }

    public static void main(String[] args) {
        MyThread2 myThread = new MyThread2();
        Thread thread1 = new Thread(myThread, "thread1");
        Thread thread2 = new Thread(myThread, "thread2");
        Thread thread3 = new Thread(myThread, "thread3");
        Thread thread4 = new Thread(myThread, "thread4");
        Thread thread5 = new Thread(myThread, "thread5");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

}
