package spring.demo.ArrayAndQueue;

import lombok.Data;

/**
 * @Package: spring.demo.ArrayAndQueue
 * @ClassName: HeroNode
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/9/19 8:29
 * @UpdateDate: 2019/9/19 8:29
 */
@Data
public class HeroNode {

    private Integer no;

    private String name;

    private String nickName;

    private HeroNode next;

}
