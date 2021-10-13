package com.usst.springaop.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvokeHandler implements InvocationHandler {
    private Object object;

    // 利用proxy.newProxyInstance()将被代理对象和调度处理器对象进行绑定，返回代理对象。

    /**
     * 创建被代理对象
     * @param targetObject
     * @return Object
     */
    public Object creatProxy(Object targetObject){
        this.object = targetObject;
        Object o = Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), ProxyInvokeHandler.this);
        return o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = null;
        System.out.println("-----jdk进行销售或者租赁房屋前的逻辑处理-----");
        ret = method.invoke(object, args);
        System.out.println("-----进行销售或者租赁房屋后的逻辑处理-----");
        return ret;
    }
}
