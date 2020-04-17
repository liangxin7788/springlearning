package spring.demo.interview.thread.thread_demo3;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;

import java.util.HashMap;

/**
 * @Package: spring.demo.interview.thread.thread_demo3
 * @ClassName: CountUtil
 * @Description: 单独抽出来是为了方便获取结果 getResult ，不然直接在 MyCountDownLatch 中书写调用是又要创建对象再调用，不方便
 * @Author: liangxin
 * @CreateDate: 2019/8/2 17:03
 * @UpdateDate: 2019/8/2 17:03
 */
public class CountUtil {

    private Integer result = 0;

    public synchronized void countAge(Integer age) {
        if (ObjectUtils.isNotEmpty(age)) {
            result += age;
        }
    }

    public Integer getResult(){
        return result;
    }

}
