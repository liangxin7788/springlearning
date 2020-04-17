package spring.demo.learn.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Package: spring.demo.learn.test
 * @ClassName: SortTest
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2020/3/10 9:15
 * @UpdateDate: 2020/3/10 9:15
 */
public class SortTest {

    public static void main(String[] args) {
        Integer arr[] = {1, 2, 5, 3, 6, 9, 7, 5};
        List<Integer> list = Arrays.asList(arr);

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer arg0, Integer arg1) {
//                if (Math.abs(5-arg0)-Math.abs(5-arg1)>0){
//                    return 1;
//                }
//                if (Math.abs(5-arg0)-Math.abs(5-arg1)==0){
//                    return 0;
//                }
//                if (Math.abs(5-arg0)-Math.abs(5-arg1)<0){
//                    return -1;
//                }
//                return 0;
                if(arg0>arg1){
                    return -1;
                }
                if(arg0<arg1){
                    return 1;
                }
                return 0;
            }
        });
        System.out.println(JSON.toJSONString(list));
    }

}
