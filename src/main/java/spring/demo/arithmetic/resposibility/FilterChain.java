package spring.demo.arithmetic.resposibility;

import spring.demo.learn.bean.PreparationList;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: spring.demo.learn.test
 * @ClassName: FilterChain
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/10/17 18:02
 * @UpdateDate: 2019/10/17 18:02
 */
public class FilterChain implements StudyPrepareFilter {

    private int pos = 0;

    /**
     * 责任链最后要做的事情
     */
    private Study study;

    private List<StudyPrepareFilter> studyPrepareFilterList;

    public FilterChain(Study study) {
        this.study = study;
    }

    public void addFilter(StudyPrepareFilter studyPrepareFilter) {
        if (studyPrepareFilterList == null) {
            studyPrepareFilterList = new ArrayList<StudyPrepareFilter>();
        }
        studyPrepareFilterList.add(studyPrepareFilter);
    }

    @Override
    public void doFilter(PreparationList thingList, FilterChain filterChain) {
        // 所有过滤器执行完毕
        if (pos == studyPrepareFilterList.size()) {
            study.study();
        }else {
            studyPrepareFilterList.get(pos++).doFilter(thingList, filterChain);
        }
    }

}
