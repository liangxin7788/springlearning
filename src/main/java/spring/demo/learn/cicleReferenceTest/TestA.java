//package spring.demo.learn.cicleReferenceTest;
//
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.beans.ConstructorProperties;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
///**
// * @Package: spring.demo.learn.cicleReferenceTest
// * @ClassName: TestA
// * @Description: 构造器循环依赖（项目启动失败的）
// * @Author: liangxin
// * @CreateDate: 2019/9/27 14:13
// * @UpdateDate: 2019/9/27 14:13
// */
//@Data
//@Component
//public class TestA {
//
//    private TestB testB;
//
//    public TestA(TestB testB){
//        this.testB = testB;
//    }
//
//
//
//}
//
//@Data
//@Component
//class TestB {
//
//    private TestC testC;
//
//    public TestB(TestC testC){
//        this.testC = testC;
//
//    }
//
//}
//
//@Data
//@Component
//class TestC {
//
//    @Autowired
//    private TestA testA;
//
//    public TestC(TestA testA){
//        this.testA = testA;
//    }
//
//    public static void main(String[] args) {
//        Integer a = new Integer(3);
//        Integer b  = null;
//        System.out.println(b == a);
//    }
//
//}