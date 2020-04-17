package spring.demo.interview.sync;

/**
 * @Package: spring.demo.interview.sync
 * @ClassName: TestSynchronized
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/8/6 15:41
 * @UpdateDate: 2019/8/6 15:41
 */
public class TestSynchronized {

    public void test1(){
        synchronized (this){
            int i = 5;
            while (i-- > 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 去掉 synchronized 关键字，
     */
    public /*synchronized*/ void test2(){
        int i = 5;
        while (i-- > 0){
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final TestSynchronized myt2 = new TestSynchronized();
        Thread test1 = new Thread(  new Runnable() {  public void run() {myt2.test1();}}, "test1"  );
        Thread test2 = new Thread(  new Runnable() {  public void run() {myt2.test2();}}, "test2"  );

        test1.start();
        test2.start();
    }

}
