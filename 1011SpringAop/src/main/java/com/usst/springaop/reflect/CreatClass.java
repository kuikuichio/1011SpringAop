package com.usst.springaop.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Class.forName;

public class CreatClass {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        // 获取Class对象
        Class<?> aClass = forName("com.usst.springaop.reflect.CreatClass");

        // 获取Method对象
        Method[] methods = aClass.getMethods();
        Optional<Method> first = Arrays.stream(methods).findFirst();
        Method method = first.get();
        // 获取method相关属性
        // System.out.println(method.getName());
        // System.out.println(method.getReturnType());
        // System.out.println(method.getParameterCount());
        // System.out.println(method.getParameterTypes());
        // System.out.println(method.getDefaultValue());
        // System.out.println(method.getExceptionTypes());
        // System.out.println(method.getClass());

        // 获取构造器对象
        // Constructor<?>[] constructors = aClass.getConstructors();
        // Optional<Constructor<?>> first1 = Arrays.stream(constructors).findFirst();
        // Constructor<?> constructor = first1.get();
        // System.out.println(constructor.getName());

        Class<?> aClass1 = forName("com.usst.springaop.reflect.Person");
        // 获取构造器对象
        Constructor<?>[] constructors1 = aClass1.getConstructors();
        Stream<Constructor<?>> stream = Arrays.stream(constructors1);
        long count = stream.count();
        Constructor<?> constructor = Arrays.stream(constructors1).findFirst().get();
        // 获取所有的构造器对象
        List<Constructor<?>> collect = Arrays.stream(constructors1).collect(Collectors.toList());
        Person ssq = null;
        for (int i = 0; i < collect.size(); i++) {
            if (i % 2 == 0) {
                // 构造无参对象实例
                Person ss = (Person) collect.get(i).newInstance();
                // System.out.println("第" + i + "个-----" + ss.getAge() + ss.getUsername() + ss.getPassword() + "-----");
            } else {
                // 构造有参对象实例
                ssq = (Person) collect.get(i).newInstance("33", "22", 33);
                // System.out.println("第" + i + "个-----" + ss.getAge() + ss.getUsername() + ss.getPassword() + "-----");
            }
        }

        // 获取属性对象
        Field[] fields = aClass1.getDeclaredFields();
        List<Field> collect1 = Arrays.asList(fields).stream().collect(Collectors.toList());
        System.out.println(collect1);

        // 获取成员方法对象
        Method getemail = aClass1.getMethod("getemail");
        Person finalSsq = ssq;
        try {
            getemail.invoke(finalSsq);
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }

    }
}
