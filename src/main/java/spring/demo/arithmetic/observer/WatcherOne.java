package spring.demo.arithmetic.observer;

import spring.demo.ArrayAndQueue.HeroNode;
import spring.demo.learn.bean.Taa;

import java.lang.reflect.Field;
import java.util.Observable;
import java.util.Observer;

/**
 * @Package: spring.demo.arithmetic.observer
 * @ClassName: Watcher
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/10/23 17:24
 * @UpdateDate: 2019/10/23 17:24
 */
public class WatcherOne implements Observer {

    String data;

    public WatcherOne(Observable o) {
        o.addObserver(this);
    }

    public String getData() {
        return data;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.data = ((WatchedCentry) o).getData();
        System.out.println("观察者1观察到状态发生改变：" + ((WatchedCentry) o).getData());
    }
}
