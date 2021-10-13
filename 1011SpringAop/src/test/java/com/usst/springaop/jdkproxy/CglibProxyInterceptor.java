package com.usst.springaop.jdkproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyInterceptor implements MethodInterceptor {

    private Object object;

    public Object createProxy(Object targetObject){
        this.object = targetObject;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetObject.getClass());
        enhancer.setCallback(CglibProxyInterceptor.this);
        Object o = enhancer.create();
        return o;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object ret = null;
        System.out.println("-----cglib租赁或销售前-----");
        method.invoke(object,objects);
        System.out.println("-----cglib租赁或销售后-----");
        return null;
    }
}
