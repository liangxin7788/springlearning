package spring.demo.interview.aop;

import java.lang.annotation.*;

/**
 * @Package: spring.demo.interview.aop
 * @ClassName: WebLog
 * @Description: 自定义日志注解
 * @Author: liangxin
 * @CreateDate: 2019/8/31 15:47
 * @UpdateDate: 2019/8/31 15:47
 */
@Retention(RetentionPolicy.RUNTIME) // 定义为运行时使用该注解
@Target({ElementType.METHOD})       // 定义为作用于方法上
@Documented                         // 注解是否将包含在 JavaDoc 中
public @interface WebLog {          // 注解名为 WebLog
    /**
     * 日志描述信息
     * @return
     */
    String description() default "";// 定义一个属性，默认为空字符串

}
