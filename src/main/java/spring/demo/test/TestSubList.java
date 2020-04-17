package spring.demo.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: spring.demo.test
 * @ClassName: TestSubList
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/11/27 9:45
 * @UpdateDate: 2019/11/27 9:45
 */
public class TestSubList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        list.add("ee");
        list.add("ff");
        list.add("gg");
        list.add("hh");
        list.add("ii");
        list.add("jj");
        int count = 0;
        boolean flag = true;
        while (flag){
            List<String> list2 = list.subList(count * 3, 3 * (count+1) > list.size() ? list.size() : 3*(count+1));
            count++ ;
            if(list2.size() < 3){
                flag = false;
            }
            System.out.println("list2 = " + list2);
            System.out.println("list = " + list);
            System.out.println("==============");
        }
    }


}
