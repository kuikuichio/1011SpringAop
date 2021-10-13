package com.usst.springaop.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LogAop {

    // 切入点
    @Pointcut("execution(* com.*..controller..*(..))")
    public void doControllerAop() {
        System.out.println("这是一个AOP切面！");
    }

    @Before("doControllerAop()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return;
        }

        HttpServletRequest request = requestAttributes.getRequest();


        // 记录下请求内容
        // 打印空行方便阅读
        System.out.println();
        log.info("--------------->日志打印ing<------------- : ");
        log.info("---->请求URL : " + request.getRequestURL().toString());
        log.info("---->HTTP方法 : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("---->方法名 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("---->获取封装了署名信息的对象, 在该对象中可以获取到目标方法名, 所属类的 Class 等信息 : " +
                joinPoint.getSignature());
        log.info("---->获取传入目标方法的参数对象 : " + Arrays.toString(joinPoint.getArgs()));
        log.info("---->获取被代理的对象 : " + joinPoint.getTarget());
        log.info("---->获取代理的对象 : " + joinPoint.getThis());
    }

    @Around("doControllerAop()")
    public void doBefore(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            Object proceed = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}
