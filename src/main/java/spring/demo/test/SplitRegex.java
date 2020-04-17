package spring.demo.test;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Package: spring.demo.test
 * @ClassName: SplitRegex
 * @Description: 用所有的标点符号切割字符串（正则切割）
 * @Author: liangxin
 * @CreateDate: 2019/11/11 9:21
 * @UpdateDate: 2019/11/11 9:21
 */
public class SplitRegex {

    public static void main(String[] args) {
//        splitString("aa bb,cc.ee%ff@hh*htt");

        String pwd = "liangxinSHARON";
        String save = DigestUtils.md5Hex(pwd);
        System.out.println(save);
    }

    public static String[] splitString(String content){

        String result[] = content.split("[@#$%^&*、，。；？！,.;?! ]");
        for (String str : result) {
            System.out.println(str);
        }
        return result;
    }

}
