package spring.demo.interview.reflect;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Package: spring.demo.interview.reflect
 * @ClassName: TestReflect
 * @Description: 测试反射操作person类相关属性
 * @Author: liangxin
 * @CreateDate: 2019/7/30 14:15
 * @UpdateDate: 2019/7/30 14:15
 */
public class TestReflect {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        field();
//        constructor();
        method();
    }

    public static void method() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class class3 = Class.forName("spring.demo.interview.reflect.Person");
        // 得到对象
        Person person = (Person) class3.newInstance();

        // 获取所有普通方法
        Method[] methods = class3.getDeclaredMethods();
        if (ObjectUtils.isNotEmpty(methods)) {
            for (Method method : methods) {
                System.out.println(method);
            }
        }

        // 获取指定参数普通方法
//        Method method = class3.getDeclaredMethod("setName", String.class);
        Method method = class3.getDeclaredMethod("testGetMethod", String.class);

        method.setAccessible(true);

        Object result = method.invoke(person, "liangxin");

        System.out.println(result.toString());

//        System.out.println(person.getName());
    }

    /**
     * 反射操作构造器
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public static void constructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class class2 = Class.forName("spring.demo.interview.reflect.Person");

        // 得到所有的构造方法
//        Constructor constructor = class2.getConstructor();
//        if (ObjectUtils.isNotEmpty(constructor)) {
//            System.out.println(constructor);
//        }

        // 得到指定的构造方法
        Constructor c = class2.getConstructor(String.class, Integer.class);

        // 得到对象
        Person p = (Person) c.newInstance("lisi", 100);
        System.out.println(p.getName() + "======" + p.getAge());
    }

    /**
     * 反射操作属性
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchFieldException
     */
    public static void field() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        // 使用反射操作属性（变量）
        Class class1 = Class.forName("spring.demo.interview.reflect.Person");

        // 得到所有的属性
//        Field[] fields = class1.getDeclaredFields();
//        if (ObjectUtils.isNotEmpty(fields)) {
//            for (Field field : fields) {
//                System.out.println(field);
//                /**
//                 * 结果
//                 * private java.lang.String spring.demo.interview.reflect.Person.name
//                 * private java.lang.String spring.demo.interview.reflect.Person.age
//                 */
//            }
//        }

        // 得到对象
        Person person = (Person) class1.newInstance();

        // 得到指定的属性
        Field field = class1.getDeclaredField("name");
        Field field2 = class1.getDeclaredField("age");

        // 设置方法允许操作私有属性
        field.setAccessible(true);
        field2.setAccessible(true);

        // 赋值
        field.set(person, "zhangsan");
        field2.set(person, 20);

        // 获取值（Person中设置属性为私有，需要设置一个方法setAccessible(true)）
        System.out.println(field.get(person) + "==" + field2.get(person));

    }

}
