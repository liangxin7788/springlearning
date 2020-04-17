package spring.demo.interview.thread.notify;

/**
 * @Package: spring.demo.interview.thread.notify
 * @ClassName: Th
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2020/3/12 14:52
 * @UpdateDate: 2020/3/12 14:52
 */
public class Th extends Thread {

    private final String name;

    public Th(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++)
            System.err.println(name + "\t" + i);
    }

    public static void main(String[] args) throws Exception {
        Th t = new Th("t1");
        Th t2 = new Th("t2");
        t.start();
        t.join();
        t2.start();
    }

}
