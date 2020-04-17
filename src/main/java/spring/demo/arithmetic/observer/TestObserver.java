package spring.demo.arithmetic.observer;

/**
 * @Package: spring.demo.arithmetic.observer
 * @ClassName: TestObserver
 * @Description: 测试观察者模式demo
 * @Author: liangxin
 * @CreateDate: 2019/10/23 16:51
 * @UpdateDate: 2019/10/23 16:51
 */
public class TestObserver {

    public static void main(String[] args) {

        /**
         * 创建观察者中心监控实例
         */
        WatchedCentry watchedCentry = new WatchedCentry();

        /**
         * 创建观察者（订阅者）实例，并登记到监控中心
         */
        WatcherOne watcherOne = new WatcherOne(watchedCentry);
        WatcherTwo watcherTwo = new WatcherTwo(watchedCentry);

        boolean b = watchedCentry.hasChanged();
        System.out.println("改变之前" + b);

        /**
         * 监控中心数据改变
         */
        watchedCentry.setData("start");
        watchedCentry.setData("run");

        // 删除某个观察者
        watchedCentry.deleteObserver(watcherOne);

        watchedCentry.setData("stop");

    }

}
