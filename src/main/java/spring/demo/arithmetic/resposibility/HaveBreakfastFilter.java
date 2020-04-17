package spring.demo.arithmetic.resposibility;

import spring.demo.learn.bean.PreparationList;

/**
 * @Package: spring.demo.learn.test
 * @ClassName: WashFaceFilter
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/10/17 12:19
 * @UpdateDate: 2019/10/17 12:19
 */
public class HaveBreakfastFilter implements StudyPrepareFilter {

    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if (preparationList.isHaveBreakfast()) {
            System.out.println("吃完早饭");
        }

        filterChain.doFilter(preparationList, filterChain);
    }
}
