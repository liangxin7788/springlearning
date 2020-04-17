package spring.demo.interview.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package: spring.demo.interview.aop
 * @ClassName: WebLogAspect
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/8/31 15:51
 * @UpdateDate: 2019/8/31 15:51
 */
@Slf4j
@Aspect
@Component
//@Profile({"dev", "test"}) // 只在开发环境和测试环境中使用
public class WebLogAspect {

    @Pointcut("@annotation(spring.demo.interview.aop.WebLog)")
    public void webLog(){};

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed(); // 执行切点，执行切点后，会去依次调用 @Before -> 接口逻辑代码 -> @After -> @AfterReturning；
        // 打印出参
        log.info("Response Arg : {}", JSONObject.toJSON(result));
        // 执行耗时
        log.info("Time-Consuming : {}", System.currentTimeMillis() - start);

        // 环绕里边也可以直接进行监控
//        Signature signature = proceedingJoinPoint.getSignature();
//        MethodSignature methodSignature = (MethodSignature)signature;
//        Method method = methodSignature.getMethod();
//        ApiOperation annotation = method.getAnnotation(ApiOperation.class);
//        if (ObjectUtils.isNotEmpty(annotation)) {
//            String remark = annotation.value();
//        }

        return result;
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint)throws Throwable{
        // 打印请求信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 获取 @WebLog 注解的描述信息
        String description = getAspectLogDescription(joinPoint);
        // 打印请求参数
        log.info("===============method start=================");
        log.info("Url                  :  {}", request.getRequestURL().toString());
        log.info("Description          :  {}", description);
        log.info("Http Method          :  {}", request.getMethod());
        log.info("Class Method         :  {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        log.info("Http IP              :  {}", request.getRemoteAddr());
        // 入参
        log.info("Request Args         :  {}", JSONObject.toJSON(joinPoint.getArgs()));
    }

    @After("webLog()")
    public void doAfter()throws Throwable{
        // 接口结束后换行，好看
        log.info("===========after============" + "\n");
    }

    /**
     * 获取切面注解的描述
     * @param joinPoint 切点
     * @return 描述信息
     * @throws Exception
     */
    public String getAspectLogDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuilder description = new StringBuilder("");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    // swagger 接口说明 当使用了 @ApiOperation 时，可获取到里边的说明文字
                    ApiOperation annotation = method.getAnnotation(ApiOperation.class);
                    if (annotation != null) {
                        description.append("swagger remark: " + annotation.value());
                    }
                    description.append(method.getAnnotation(WebLog.class).description());
                    break;
                }
            }
        }
        return description.toString();
    }

}
