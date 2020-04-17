package spring.demo.learn.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	/**
	 * 
	 * 获得容器
	 * 
	 * @return
	 * @author liangxin
	 * @date 上午9:43:23
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	/**
	 * 
	 * 通过名字过得bean
	 * 
	 * @param name
	 * @return
	 * @author Administrator
	 * @date 上午9:43:55
	 */
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}
	
	/**
	 * 
	 * 通过class获得bean
	 * 
	 * @param clazz
	 * @return
	 * @author Administrator
	 * @date 上午9:44:26
	 */
	public static <T> T getBean(Class<T> clazz) {
		return getApplicationContext().getBean(clazz);
	}
	
	/**
	 * 
	 * 通过name,以及Clazz返回指定的Bean
	 * 
	 * @param name
	 * @param clazz
	 * @return
	 * @author Administrator
	 * @date 上午9:45:04
	 */
	public static <T> T getBean(String name, Class<T> clazz) {
		return getApplicationContext().getBean(name, clazz);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (SpringUtil.applicationContext == null) {
			SpringUtil.applicationContext = applicationContext;
		}
	}

}
