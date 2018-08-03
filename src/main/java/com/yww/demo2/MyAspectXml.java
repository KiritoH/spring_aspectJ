package com.yww.demo2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspectXml {

    //前置通知(JointPoint为切入点信息)
    public void before(JoinPoint joinPoint){
        System.out.println("XML方式的前置通知==============");
        //输出切入点信息
        System.out.println(joinPoint);
    }

    //后置通知
    public void afterReturning(Object result){
        System.out.println("XML方式的后置通知==============");
        System.out.println(result);
    }

    //环绕通知
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("======XML方式的环绕前通知======");
        //执行目标方法
        Object obj = joinPoint.proceed();
        System.out.println("======XML方式的环绕后通知======");
        return obj;

    }

    //异常抛出通知
    public void afterThrowing(){
        System.out.println("XML方式的异常抛出通知=============");
    }

    //最终通知
    public void after(){
        System.out.println("XML方式的最终通知============");
    }
}
