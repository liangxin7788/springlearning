package spring.demo.interview.thread.cross;

import spring.demo.interview.thread.notify.MyList;

/**
 * @Package: spring.demo.interview.thread.cross
 * @ClassName: Cross0
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2020/3/12 16:45
 * @UpdateDate: 2020/3/12 16:45
 */
public class Cross0 extends Thread {

    private Object count;

    public Cross0(Object count) {
        super();
        this.count = count;
    }

    @Override
    public void run(){
        try {
            Integer parseInt = Integer.parseInt(String.valueOf(count));
            synchronized (count) {
                if (parseInt % 2 != 0 && parseInt < 50) {
                    parseInt ++;
                    System.out.println("(打印偶数)当前线程名 " + Thread.currentThread ().getName() + ", 变量值：" + parseInt);
                    count = parseInt;
                    count.wait();
                }else {
                    count.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
