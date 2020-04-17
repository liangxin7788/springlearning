package spring.demo.arithmetic.resposibility;

import spring.demo.learn.bean.PreparationList;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: spring.demo.learn.test
 * @ClassName: TestResponsibilityModel
 * @Description: 责任链模式测试类
 * @Author: liangxin
 * @CreateDate: 2019/10/17 12:23
 * @UpdateDate: 2019/10/17 12:23
 */
public class TestResponsibilityModel {

    public static void main(String[] args) {
        PreparationList preparationList = new PreparationList();
        preparationList.setWashFace(true);
        preparationList.setWashHair(false);
        preparationList.setHaveBreakfast(true);

        // 主任务
        Study study = new Study();

        StudyPrepareFilter washFaceFilter = new WashFaceFilter();
        StudyPrepareFilter washHairFilter = new WashHairFilter();
        StudyPrepareFilter haveBreakfastFilter = new HaveBreakfastFilter();

        FilterChain filterChain = new FilterChain(study);
        filterChain.addFilter(washFaceFilter);
        filterChain.addFilter(washHairFilter);
        filterChain.addFilter(haveBreakfastFilter);

        filterChain.doFilter(preparationList, filterChain);

    }

}
