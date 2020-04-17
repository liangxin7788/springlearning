package spring.demo.arithmetic.observer;

import java.util.Observable;

/**
 * @Package: spring.demo.arithmetic.observer
 * @ClassName: WatchedOne
 * @Description: 观察中心，负责变化和通知别的观察者（订阅者）
 * @Author: liangxin
 * @CreateDate: 2019/10/23 17:10
 * @UpdateDate: 2019/10/23 17:10
 */
public class WatchedCentry extends Observable {

    private String data = "";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if (!this.data.equals(data)) {
            this.data = data;
            setChanged();
        }
        notifyObservers();
    }

}
