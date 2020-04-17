package spring.demo.learn.test.D0718;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.demo.learn.utils.SpringUtil;

/**
 * @Package: spring.demo.learn.test.D0718
 * @ClassName: Test
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/7/18 10:52
 * @UpdateDate: 2019/7/18 10:52
 */
@Controller
@RequestMapping("/test0718")
public class Test {

    @RequestMapping("/getBean")
    public static void getBean() {
        GetBeanTest bean = SpringUtil.getBean(GetBeanTest.class);
        bean.showMe();
    }

    public static void main(String[] args) {
        int a = 3;
        boolean flag = false;
        for(int i = 0; i < 5; i++){
            if(a == i){
                flag = true;
            }
        }
        System.out.println(flag);
    }


}
