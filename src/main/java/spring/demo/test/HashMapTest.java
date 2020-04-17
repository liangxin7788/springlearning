package spring.demo.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: spring.demo.test
 * @ClassName: HashMapTest
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2020/1/8 14:15
 * @UpdateDate: 2020/1/8 14:15
 */
public class HashMapTest {

    public static void main(String[] args) throws InterruptedException {
        Map<String, Object> map = new HashMap<>();
        map.put(null, "aaa");

        Thread.sleep(3000);
        System.out.println("=============");
        System.out.println(map.get(null));
    }


}
