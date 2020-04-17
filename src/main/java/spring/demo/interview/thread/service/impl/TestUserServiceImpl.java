package spring.demo.interview.thread.service.impl;

import org.springframework.stereotype.Service;
import spring.demo.interview.thread.thread_demo1.TestUser;
import spring.demo.interview.thread.service.ITestUserService;

/**
 * @Package: spring.demo.interview.thread.service.impl
 * @ClassName: TestUserServiceImpl
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/8/2 15:14
 * @UpdateDate: 2019/8/2 15:14
 */
@Service
public class TestUserServiceImpl implements ITestUserService {

    @Override
    public Integer addUser(TestUser user) {
        System.out.println("dao insert user success!" +  user.getAge());
        return null;
    }
}
