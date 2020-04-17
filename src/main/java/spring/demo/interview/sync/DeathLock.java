package spring.demo.interview.sync;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Package: spring.demo.interview.sync
 * @ClassName: DeathLock
 * @Description: 手写死锁实现
 * @Author: liangxin
 * @CreateDate: 2020/3/19 15:02
 * @UpdateDate: 2020/3/19 15:02
 */
public class DeathLock {

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(j + " * " + i + " = " + i*j + " ");
            }
            System.out.println();
        }
    }

}
