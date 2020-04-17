package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spring.demo.DemoApplication;

/**
 * @Package: test
 * @ClassName: Slf4jTest
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/9/30 11:27
 * @UpdateDate: 2019/9/30 11:27
 */
@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class Slf4jTest {

    @Test
    public void testSlf4j() {
        Logger logger = LoggerFactory.getLogger(Object.class);
        logger.trace("=====trace=====");
        logger.debug("=====debug=====");
        logger.info("=====info=====");
        logger.warn("=====warn=====");
        logger.error("=====error=====");
    }

}
