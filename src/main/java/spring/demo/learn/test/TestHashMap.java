package spring.demo.learn.test;

import java.util.*;

/**
 * @Package: spring.demo.learn.test
 * @ClassName: TestHashMap
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/10/11 11:14
 * @UpdateDate: 2019/10/11 11:14
 */
public class TestHashMap {

    public static void main(String[] args) {
//        Map<String, Object> map = new HashMap<>();

//        List<String> mun = new ArrayList<>();
//
//        for (int i = 0; i < 18; i++){
////            map.put("liangxin" + i, "liangxin" + i);
//            mun.add("liangxin" + i);
//        }
//        System.out.println(mun);

//        mun.forEach( t -> {
//            if("liangxin5".equals(t)){
//                return;
//            }
//            System.out.println(t);
//        });

//        for (String s : mun) {
//            if("liangxin5".equals(s)){
//                continue;
//            }
//            System.out.println(s);
//        }

        /**
         * 7HH1103780
         * 7HH1103780-13
         * 1AA101094
         * 2SS305800-1
         * 2SS305800-2
         * 2SS305800-3
         * 2SS305800-4
         */

        Set<String> skus = new LinkedHashSet<>();
        skus.add("7HH1103780");
        skus.add("7HH1103780-13");
        skus.add("2SS305800-1");
        skus.add("2SS305800-2");
        skus.add("2SS305800-3");


        System.out.println(skus.contains("2SS305800-3"));

    }

}
