package spring.demo.interview.thread.thread_demo1;

import spring.demo.interview.thread.service.ITestUserService;
import spring.demo.learn.utils.SpringUtil;

/**
 * @Package: spring.demo.interview.thread
 * @ClassName: MyRunnable
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/8/2 15:08
 * @UpdateDate: 2019/8/2 15:08
 */
public class MyRunnable implements Runnable {

    private String name;
    private Integer age;
    private boolean aa;

    public MyRunnable(String name, Integer age, boolean aa) {
        this.name = name;
        this.age = age;
        this.aa = aa;
    }

    @Override
    public void run() {
        TestUser user = new TestUser();
        ITestUserService service = (ITestUserService) SpringUtil.getBean(ITestUserService.class);
        user.setUserName(name);
        user.setAge(age);
        service.addUser(user);
    }

}
