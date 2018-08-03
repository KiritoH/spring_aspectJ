package com.yww.demo1;

/*注解方式的切面类*/

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspectAnno {

    //前置通知
    @Before(value = "myPointcut1()")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置通知========");
        System.out.println(joinPoint);
    }

    //后置通知
    @AfterReturning(value = "myPointcut1()",returning = "result")
    public void after(Object result){
        System.out.println("后置通知=======");
        System.out.println(result);
    }

    //环绕通知
    @Around(value = "myPointcut2()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("======环绕前通知======");
        //执行目标方法
        Object obj = joinPoint.proceed();
        System.out.println("======环绕后通知======");
        return obj;
    }

    //异常抛出通知
    @AfterThrowing(value = "myPointcut3()",throwing = "e")
    public void afterThrowing(Throwable e){

        //在目标方法没有异常时,是不会触及此方法的
        System.out.println("异常抛出通知=====");

        System.out.println(e.getMessage());
    }

    @After(value = "myPointcut4()")
    public void after(){
        //无论有没有异常都会执行该通知,而其他类型的通知在存在异常的时候是不会执行的
        System.out.println("最终通知========");
    }



    @Pointcut(value = "execution(* com.yww.demo1.ProductDao.save(..))")
    public void myPointcut1(){}

    @Pointcut(value = "execution(* com.yww.demo1.ProductDao.delete(..))")
    public void myPointcut2(){}

    @Pointcut(value = "execution(* com.yww.demo1.ProductDao.update(..))")
    public void myPointcut3(){}

    @Pointcut(value = "execution(* com.yww.demo1.ProductDao.find(..))")
    public void myPointcut4(){}
}
