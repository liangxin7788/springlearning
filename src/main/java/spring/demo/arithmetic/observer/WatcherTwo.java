package spring.demo.arithmetic.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Package: spring.demo.arithmetic.observer
 * @ClassName: Watcher
 * @Description: 观察者2
 * @Author: liangxin
 * @CreateDate: 2019/10/23 17:24
 * @UpdateDate: 2019/10/23 17:24
 */
public class WatcherTwo implements Observer {

    String data;

    public WatcherTwo(Observable o) {
        o.addObserver(this);
    }

    public String getData() {
        return data;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.data = ((WatchedCentry) o).getData();
        System.out.println("观察者2观察到状态发生改变：" + ((WatchedCentry) o).getData());
    }
}
