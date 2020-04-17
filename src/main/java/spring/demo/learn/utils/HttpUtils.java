package spring.demo.learn.utils;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @Package: spring.demo.learn.utils
 * @ClassName: HttpUtils
 * @Description: get/post方法调用
 * @Author: liangxin
 * @CreateDate: 2019/8/26 9:49
 * @UpdateDate: 2019/8/26 9:49
 */
public class HttpUtils {

    private static String TOTKEN = null;

    private static String SEARCH_URL = "https://aip.baidubce.com/rest/2.0/image-classify/v1/realtime_search/product/search";

    public synchronized static String getToken(){
        if (StringUtils.isEmpty(TOTKEN)) {
            // 官网获取的 API Key 更新为你注册的
            String clientId = "xgkbGv97vjm83ukN47lt65HG";
            // 官网获取的 Secret Key 更新为你注册的
            String clientSecret = "a1VefRZmPW5bBedvMOQ0mor2nRaK978Y";

            TOTKEN = getAuth(clientId, clientSecret);
            return TOTKEN;
        }
        return TOTKEN;
    }

    private static String getAuth(String clientId, String clientSecret) {
        // 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + clientId
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + clientSecret;

        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            Map<String,String> maps =(Map<String,String>) JSON.parse(result);
            String access_token = maps.get("access_token");
            return access_token;

        } catch (MalformedURLException e) {
            System.out.println("网络异常！");
            e.printStackTrace();
        } catch (ProtocolException e) {
            System.out.println("网络协议异常！");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO异常！");
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入您需要判别的分数：");
//        while(sc.hasNext()){
//            int intNumber = sc.nextInt();
//            if (intNumber>90) {
//                System.out.println("优秀！");
//            }else if(60<intNumber && intNumber<90){
//                System.out.println("合格！");
//            }else if(intNumber==-1){
//                System.out.println("程序退出！");
//                break;
//            }else{
//                System.out.println("不合格！");
//            }
//        }
//        sc.close();
        Double a = 19.9;

        Double b = 9.9;

//        double v = a - b;

        BigDecimal b1 = new BigDecimal(a.toString());
        BigDecimal b2 = new BigDecimal(b.toString());

        Double v = b1.subtract(b2).doubleValue();

        System.out.println(v);

    }


}
