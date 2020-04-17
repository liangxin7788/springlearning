package spring.demo.test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Package: spring.demo.test
 * @ClassName: SingletonNotLock
 * @Description: 不带锁的单例
 * @Author: liangxin
 * @CreateDate: 2019/11/21 17:37
 * @UpdateDate: 2019/11/21 17:37
 */
public class SingletonNotLock {

    private static final AtomicReference<SingletonNotLock> INSTANCE = new AtomicReference<>();

    private SingletonNotLock(){};

    public static SingletonNotLock getInstance(){
        for(;;){
            SingletonNotLock singletonNotLock = INSTANCE.get();
            if (null != singletonNotLock) {
                return singletonNotLock;
            }
            singletonNotLock = new SingletonNotLock();
            if (INSTANCE.compareAndSet(null, singletonNotLock)) {
                return singletonNotLock;
            }
        }
    }

}
