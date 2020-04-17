package spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

//        String str = "[\"" + "aaa" +"\",\"数据迁移初始化标题2\",\"数据迁移初始化标题3\"]";
//        System.out.println(str);
        System.out.println("启动完成！");
    }

}
