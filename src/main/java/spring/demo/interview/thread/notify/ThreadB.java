package spring.demo.interview.thread.notify;

/**
 * @Package: spring.demo.interview.thread.notify
 * @ClassName: ThreadA
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2020/3/12 16:38
 * @UpdateDate: 2020/3/12 16:38
 */
public class ThreadB extends Thread {

    private Object lock;

    public ThreadB(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    MyList.add();
                    if (MyList.size() == 6) {
                        lock.notify();
                        System.out.println("已发出通知！");
                    }
                    System.out.println("添加了" + (i + 1) + "个元素!");
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
