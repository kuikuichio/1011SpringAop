package com.usst.springaop.jdk;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBProxy implements MethodInterceptor {

    public Object targetObject;

    public Object creatProxy(Object obj){
        this.targetObject = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetObject.getClass());
        enhancer.setCallback(this);
        Object o = enhancer.create();
        return o;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object ret = null;
        if ("addUser".equals(method.getName())){
            checkPoem();
        }
        ret = method.invoke(targetObject, objects);
        return ret;
    }

    private void checkPoem() {
        System.out.println("......JDKproxy检查访问权限......");
    }
}
