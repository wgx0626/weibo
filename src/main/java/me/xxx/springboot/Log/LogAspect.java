package me.xxx.springboot.Log;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Configuration
public class LogAspect {

    static Logger logger = Logger.getLogger(LogAspect.class);

    //切入点
    //@Pointcut("execution(* me.xxx.springboot.Dao..*.*(..))")
    @Pointcut("within(me.xxx.springboot.Dao.Impl.MemberDaoImpl)")
    public void webLog(){}

    //前置通知
    @Before("webLog()")
    /*public void LogOut(JoinPoint jp){
        //功能代码
        System.out.print("Log:"+jp.getSignature().getName());
        logger.info("Log:"+jp.getSignature().getName());
    }*/
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }
    /**
     * 处理完请求返回内容
     * @param ret
     * @throws Throwable
     */
    /*@AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("方法的返回值 : " + ret);
    }*/

   /* *
     * 后置异常通知
     * @param jp

    @AfterThrowing("webLog()")
    public void throwss(JoinPoint jp){
        System.out.println("方法异常时执行.....");
    }

    *
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     * @param jp

    @After("webLog()")
    public void after(JoinPoint jp){

    }

    *
     * 环绕通知,环绕增强，相当于MethodInterceptor
     * @param pjp
     * @return

    @Around("webLog()")
    public Object arround(ProceedingJoinPoint pjp) {
        try {
            Object o =  pjp.proceed();
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
*/}
