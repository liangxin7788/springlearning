package spring.demo.arithmetic.resposibility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.demo.learn.bean.PreparationList;

/**
 * @Package: spring.demo.learn.test
 * @ClassName: Study
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/10/17 12:05
 * @UpdateDate: 2019/10/17 12:05
 */
@Data
public class Study {

    public void study() {
        System.out.println("学习");
    }

}
