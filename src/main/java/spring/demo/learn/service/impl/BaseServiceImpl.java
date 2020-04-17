package spring.demo.learn.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring.demo.learn.service.BaseService;

/**
 * @Package: spring.demo.learn.service.impl
 * @ClassName: BaseServiceImpl
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/7/16 15:44
 * @UpdateDate: 2019/7/16 15:44
 */
@Service
@Slf4j
public class BaseServiceImpl implements BaseService {

    @Override
    public String doSomething() {
        // 增强效果：返回内容全部大写
        log.error("test error!");
        log.debug("test debug!");
        log.warn("test warn!");
        log.info("test info!");
        return "Hello i am kxm";
    }

    @Override
    public String eat() {
        return "eat food";
    }
}
