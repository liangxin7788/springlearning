package spring.demo.learn.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import spring.demo.learn.service.impl.BaseServiceImpl;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Package: spring.demo.learn.service.test
 * @ClassName: MyBeanPostProcessor
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/7/16 15:46
 * @UpdateDate: 2019/7/16 15:46
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    // 前置处理器
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = bean.getClass();
        if (beanClass == BaseServiceImpl.class) {
            System.out.println("bean 对象初始化之前······");
        }
        return bean;
    }

    // 后置处理器 --- 此处具体的实现用的是Java中的动态代理
    public Object postProcessAfterInitialization(final Object beanInstance, String beanName) throws BeansException {
        // 为当前 bean 对象注册监控代理对象，负责增强 bean 对象方法的能力
        Class beanClass = beanInstance.getClass();
        if (beanClass == BaseServiceImpl.class) {
            Object proxy = Proxy.newProxyInstance(beanInstance.getClass().getClassLoader(), beanInstance.getClass().getInterfaces(), new InvocationHandler() {
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("ISomeService 中的 doSome() 被拦截了···");
                    String result = (String) method.invoke(beanInstance, args);
                    return result.toUpperCase();
                }
            });
            return proxy;
        }
        return beanInstance;
    }

    public static void main(String[] args) {
        StringBuilder localStrBulider = new StringBuilder();
        File file = new File("C:\\Users\\Administrator\\Desktop\\test33.txt");
        if(file.isFile() && file.exists()) {
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "utf-8");
                BufferedReader bufferReader = new BufferedReader(inputStreamReader);
                String lineStr = null;
                try {
                    while((lineStr = bufferReader.readLine()) != null) {
                        localStrBulider.append(lineStr);
                    }
                    bufferReader.close();
                    inputStreamReader.close();
                } catch (IOException e) {
                    System.out.println("file read error!");
                    e.printStackTrace();
                }
            }catch (Exception e){
                System.out.println("file catch unsupported encoding!");
                e.printStackTrace();
            }
        }
        System.out.println("localStrBulider.toString():" + localStrBulider.toString());
    }


}
