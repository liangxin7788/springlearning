package spring.demo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: spring.demo.test
 * @ClassName: TestSub
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/12/18 9:44
 * @UpdateDate: 2019/12/18 9:44
 */
public class TestSub {

    public static void main(String[] args) {
//        String fullpath = "系统类目一>";
//        if (StringUtils.isNotEmpty(fullpath) && fullpath.length() > 6) {
//            fullpath = fullpath.substring(6);
//        }
//        System.out.println(fullpath);

        String json = "{\"Joom\":6.0,\"Ebay\":0.4,\"SMT\":0.0,\"Amazon\":1.0,\"Wish\":3.0}";
        Map<String, Object> map = JSON.parseObject(json, Map.class);
        String joomPlat = map.get("Joom").toString();
        String ebayPlat = map.get("Ebay").toString();
        String smtPlat = map.get("SMT").toString();
        String amazonPlat = map.get("Amazon").toString();
        String wishPlat = map.get("Wish").toString();

        System.out.println(Double.valueOf(joomPlat));
        System.out.println(Double.valueOf(ebayPlat));
        System.out.println(Double.valueOf(smtPlat));
        System.out.println(Double.valueOf(amazonPlat));
        System.out.println(Double.valueOf(wishPlat));

    }


}
