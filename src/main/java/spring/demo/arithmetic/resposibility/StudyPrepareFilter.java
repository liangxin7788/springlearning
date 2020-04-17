package spring.demo.arithmetic.resposibility;

import spring.demo.learn.bean.PreparationList;


/**
 * @Package: spring.demo.learn.test
 * @ClassName: StudyPrepareFilter
 * @Description: 注意这里多了一个FilterChain，也就是责任链，是用于串起所有的责任对象的，它也是StudyPrepareFilter的一个子类
 * @Author: liangxin
 * @CreateDate: 2019/10/17 18:00
 * @UpdateDate: 2019/10/17 18:00
 */
public interface StudyPrepareFilter {

    void doFilter(PreparationList preparationList, FilterChain filterChain);

}
