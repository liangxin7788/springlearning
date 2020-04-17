package spring.demo.learn.bean;

import lombok.Data;

/**
 * @Package: spring.demo.learn.bean
 * @ClassName: PreparationList
 * @Description: 设计模式-责任链模式
 * @Author: liangxin
 * @CreateDate: 2019/10/17 12:03
 * @UpdateDate: 2019/10/17 12:03
 */
@Data
public class PreparationList {

    /**
     * 是否洗脸
     */
    private boolean washFace;

    /**
     * 是否洗头
     */
    private boolean washHair;

    /**
     * 是否吃早餐
     */
    private boolean haveBreakfast;

    @Override
    public String toString() {
        return "ThingList [washFace=" + washFace + ", washHair=" + washHair + ", haveBreakfast=" + haveBreakfast + "]";
    }

}
