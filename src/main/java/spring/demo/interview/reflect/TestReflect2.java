package spring.demo.interview.reflect;

import java.lang.reflect.Method;

/**
 * @Package: spring.demo.interview.reflect
 * @ClassName: TestReflect2
 * @Description: 测试反射获取对象和直接创建对象的效率比对
 * @Author: liangxin
 * @CreateDate: 2019/8/5 8:54
 * @UpdateDate: 2019/8/5 8:54
 */
public class TestReflect2 {

    private static final int COUNT = 100000;

    public static void main(String[] args) {
        System.out.println("start test...");
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++){
            Person person = new Person();
            person.setName("new");
        }
        long end1 = System.currentTimeMillis();
        long diff1 = end1 - start1;
        System.out.println("native call :" + diff1);

        // =======================================
        try {
            long start2 = System.currentTimeMillis();
            for (int i = 0; i < COUNT; i++){
                Class<?> personClas = Class.forName("spring.demo.interview.reflect.Person");
                Class<?>[] argsType = new Class[1];
                argsType[0] = String.class;

                Method m = personClas.getMethod("setName", argsType);
                Object obj = personClas.newInstance();
                m.invoke(obj, "reflect" + i);
            }
            long end2 = System.currentTimeMillis();
            long diff2 = end2 - start2;
            System.out.println("reflect call:" + diff2);
        } catch (Exception e) {
            System.out.println("反射异常");
        }

        // ============================================
        try {
            long start3 = System.currentTimeMillis();
            //缓存类，避免多次查找
            Class clzA = Class.forName("spring.demo.interview.reflect.Person");
            Class<?>[] argsType = new Class[1];
            argsType[0] = String.class;
            //缓存方法，避免多次查找(不在fou里边创建对象和方法)
            Method m = clzA.getMethod("setName", argsType);
            for (int i = 0; i < COUNT; i++) {
                Object obj = clzA.newInstance();
                m.invoke(obj, "cache" + i);
            }
            long end3 = System.currentTimeMillis();
            long diff3 = end3 - start3;
            System.out.println("cache call:" + diff3);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
