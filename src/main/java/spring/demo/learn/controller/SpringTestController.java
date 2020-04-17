package spring.demo.learn.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.demo.interview.aop.WebLog;
import spring.demo.learn.service.BaseService;
import spring.demo.learn.utils.SpringUtil;

import javax.naming.Name;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Package: spring.demo.learn.controller
 * @ClassName: SpringTest
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/7/16 16:01
 * @UpdateDate: 2019/7/16 16:01
 */
@RestController
@RequestMapping("/test")
public class SpringTestController {

    @Autowired
    private BaseService baseService;
    
    @GetMapping("/print")
    @ApiOperation("测试使用swagger描述备注")
    @WebLog(description = "切面自定义描述")
    public String print(){
        BaseService baseService = SpringUtil.getBean(BaseService.class);
        String result = baseService.doSomething();
        System.out.println(result);
        return result;
    }


    public static void main(String[] args) {
//        String s = "1 2 3";
//        String[] s1 = s.split(" ");
//        for (int i = 0; i < 3; i ++){
//            System.out.println(s1[i]);
//        }
//        System.out.println(1005 % 10);

        Integer a = null;
        if (1 == a) {
            System.out.println("==");
        }else {
            System.out.println("budeng");
        }
    }

}
