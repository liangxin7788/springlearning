package spring.demo.learn.test.D0718;

import org.springframework.stereotype.Component;

/**
 * @Package: spring.demo.learn.test.D0718
 * @ClassName: GetBeanTest
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/7/18 10:51
 * @UpdateDate: 2019/7/18 10:51
 */
@Component
public abstract class GetBeanTest {

    public abstract Father getBean();

    public void showMe(){
        this.getBean().showMe();
    }

}
