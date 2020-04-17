package spring.demo.test;

import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Package: spring.demo.test
 * @ClassName: TestJson
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/12/3 9:24
 * @UpdateDate: 2019/12/3 9:24
 */
public class TestJson {

    public static void main(String[] args) {
//        String name = "[\"2019 Summer Autumn Womens Ethnic Print Solid V Neck Long Sleeve Beach Dress Loose Casual Ladies Party Dresses Female Holiday Clothes Vestidos  \",\"数据迁移初始化标题2\",\"数据迁移初始化标题3\"]";
        List<String> list = new ArrayList<>();
        String json = "ah\\hbb\"1";
        list.add(json);
        list.add("\"数据迁移初始化标题2\"");
        list.add("\"数据迁移初始化标题3\"");
        list.add("\"数据迁移初始化标题4\"");
        list.add("\"数据迁移初始化标题5\"");
        list.add(null);
        list.add("\"数据迁移初始化标题7\"");

        for (String s : list) {
            System.out.println(list.get(6) + "======" + s);
        }

//        String trim = json.trim();
//
//        List<String> list = JSON.parseArray(json, String.class);
//        List<String> list2 = JSON.parseArray(trim, String.class);
//
        System.out.println(JSON.toJSONString(list));
//        System.out.println(list2);

//        getInteger(48);

    }

    public static void getInteger(Integer hour){
        Calendar calendar = Calendar.getInstance();
        /* HOUR_OF_DAY 指示一天中的小时 */
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - hour);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(hour + "个小时前的时间：" + df.format(calendar.getTime()));
        System.out.println("当前的时间：" + df.format(new Date()));
    }

}
