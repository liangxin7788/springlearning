package spring.demo.interview.serialzable;

import lombok.Data;

import java.io.Serializable;

/**
 * @Package: spring.demo.interview.serialzable
 * @ClassName: UserSeria
 * @Description: 测试序列化类
 * @Author: liangxin
 * @CreateDate: 2019/7/30 16:03
 * @UpdateDate: 2019/7/30 16:03
 */
@Data
public class UserSeria implements Serializable {

    /**
     * 序列化到文件之后，如果手动修改了此值，反序列化时，将不能转回成此对象类型，报错如下
     * java.io.InvalidClassException: spring.demo.interview.serialzable.UserSeria; local class incompatible: stream classdesc serialVersionUID = -2095916884810199532, local class serialVersionUID = -2095916884810199531
     */
    private static final long serialVersionUID = -2095916884810199532L;

    private Integer userId;
    private String userName;

}
