package com.usst.springaop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {

    // public UserManagerImpl userManagerImpl;
    public Object targetObject;

    public Object creatProxy(Object targetObject) {
        this.targetObject = targetObject;
        Object o = Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), JDKProxy.this);
        return o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        checkPoem();
        Object ret = null;
        ret = method.invoke(targetObject, args);
        return ret;
    }

    private void checkPoem() {
        System.out.println("......JDKproxy检查访问权限......");
    }
}
