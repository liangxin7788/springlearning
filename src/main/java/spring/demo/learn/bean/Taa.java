package spring.demo.learn.bean;

import java.util.List;

/**
 * @Package: spring.demo.learn.bean
 * @ClassName: Taa
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/7/24 15:08
 * @UpdateDate: 2019/7/24 15:08
 */
public class Taa {

    public List<? extends Number> test(){

//        List<? extends Number> foo3 = new ArrayList<? extends Integer>();

        return null;
    }

    public List<? super Integer> test2(){

        return null;
    }

}
