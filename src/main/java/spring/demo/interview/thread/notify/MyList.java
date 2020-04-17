package spring.demo.interview.thread.notify;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: spring.demo.interview.thread.notify
 * @ClassName: MyList
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2020/3/12 16:35
 * @UpdateDate: 2020/3/12 16:35
 */
public class MyList {

    private static List list = new ArrayList();

    public static void add() {
        list.add("我是元素");
    }

    public static int size() {
        return list.size();
    }

}
