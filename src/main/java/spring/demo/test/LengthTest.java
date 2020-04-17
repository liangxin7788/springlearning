package spring.demo.test;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: spring.demo.test
 * @ClassName: LengthTest
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/11/19 17:46
 * @UpdateDate: 2019/11/19 17:46
 */
public class LengthTest {

    public static void main(String[] args) {
        System.out.println("aabcabcabc最大长度重复字符串是：" + computeMaxRepeatString("aabcabcabc"));
        // 应该得到 abcabc 才对
    }

    /**
     * 计算最长的重复字符串
     * @param str
     * @return
     */
    public static String computeMaxRepeatString(String str) {

        String maxNumberKey = null;
        Integer maxNumberNumber = 0;
        int len = str.length();
        if (len < 1) {
            throw new RuntimeException("string is empty");
        }
        if (len < 2) {
            return str.charAt(0) + "";
        }
        for (int i = 2; i <= len; i++) {//i = 2意思是至少两个字符才开始算字符串
            Object[] maxValue = computeMaxRepeatString(str, i);
            String numberKey = (String) maxValue[0];
            Integer numberNumber = (Integer) maxValue[1];
            if (numberNumber >= maxNumberNumber || numberNumber >= 2) {
                maxNumberKey = numberKey;
                maxNumberNumber = numberNumber;
            }
        }
        return maxNumberKey;
    }

    private static Object[] computeMaxRepeatString(String str, int count) {
        Map<String, Integer> numberMap = new HashMap<>();
        String maxNumberKey = null;
        Integer maxNumberNumber = 0;
        for (int i = 0; i <= str.length() - count; i++) {
            String temp = str.substring(i, i + count);
            Integer charNumber = numberMap.get(temp);
            if (charNumber == null) {
                charNumber = 1;
            } else {
                charNumber++;
            }
            numberMap.put(temp, charNumber);
            if (maxNumberKey == null) {
                maxNumberKey = temp;
                maxNumberNumber = charNumber;
            } else {
                if (charNumber > maxNumberNumber) {
                    maxNumberKey = temp;
                    maxNumberNumber = charNumber;
                }
            }
        }
        return new Object[] { maxNumberKey, maxNumberNumber };
    }
}
