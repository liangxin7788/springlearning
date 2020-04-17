package spring.demo.interview.hashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: spring.demo.interview.hashMap
 * @ClassName: AboutKey
 * @Description: 测试hashMap存储时key的注意点
 * @Author: liangxin
 * @CreateDate: 2019/8/14 8:43
 * @UpdateDate: 2019/8/14 8:43
 */
public class AboutKey {

    /**
     * 用自定义类作为key，必须重写equals()和hashCode()方法。
     * <p>
     * 自定义类中的equals() 和 hashCode()都继承自Object类。
     * Object类的hashCode()方法返回这个对象存储的内存地址的编号。
     * 而equals()比较的是内存地址是否相等。
     */
    public static void main(String[] args) {
        Map<PhoneNumber, String> map = new HashMap<PhoneNumber, String>();
        PhoneNumber phoneNumber1 = new PhoneNumber();
        phoneNumber1.setPhoneNumber(111);
        phoneNumber1.setPrefix(111);

        PhoneNumber phoneNumber2 = new PhoneNumber();
        phoneNumber2.setPhoneNumber(222);
        phoneNumber2.setPrefix(222);

        map.put(phoneNumber1, "111");
        map.put(phoneNumber2, "222");

        System.out.println(map.get(phoneNumber1));
        System.out.println(map.get(phoneNumber2));

        PhoneNumber phoneNumber3 = new PhoneNumber();
        //参数内容和phoneNumber2一样
        phoneNumber3.setPhoneNumber(222);
        phoneNumber3.setPrefix(222);
        System.out.println(map.get(phoneNumber3));
    }

}

//  以下是重写/不重写equals()和hashCode()方法；
class PhoneNumber {
    private int prefix; //区号
    private int phoneNumber; //电话号

    public int getPrefix() {
        return prefix;
    }

    public void setPrefix(int prefix) {
        this.prefix = prefix;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber pn = (PhoneNumber) o;
        return pn.prefix == prefix && pn.phoneNumber == phoneNumber;
    }


    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + prefix;
        result = 31 * result + phoneNumber;
        return result;
    }


}