package com.usst.springaop.java8;

import com.usst.springaop.reflect.Person;

import java.util.Optional;

/**
 * Optional本质是一个简单的对象容器
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Person zz = new Person("zz", "1", null);
        // 常规判断
        if (zz == null) {
            return;
        } else {
            if (zz.getAge() == null || String.valueOf(zz.getAge()).equals(" ")) {
                zz.setAge(12);
            }
        }

        // zz = null;
        // Optinal
        // ofNullable：Optinal的静态方法; 功能：根据参数是否为空返回Optional对象。若是空参返回空对象，否则返回由optional包裹的对象，底层调用了of方法。
        Optional<Person> zz1 = Optional.ofNullable(zz);
        System.out.println("-----toString:" + zz1.get().toString() + ";-----Class对象：" + zz1.get().getClass());
        // of：Optinal的静态方法; 功能：根据参数是否为空返回Optional对象。若参数是空，抛出空指针异常；否则返回由optional包裹的对象
        Optional<Person> zz2 = Optional.of(zz);
        System.out.println("-----toString:" + zz2.get().toString() + ";-----Class对象：" + zz2.get().getClass());

        // map：Optinal的成员方法; 功能：利用参数映射函数对映射函数参数进行处理产生映射结果；应用Optional.isNullable处理映射结果，返回空的Optional对象或映射结果对象。
        Optional<Integer> integer = zz1.map(Person::getAge);
        System.out.println("-----年龄:" + integer.get());

        // flatMap：Optinal的成员方法; 功能：利用参数映射函数对映射函数参数进行处理产生映射结果；该结果是Optional对象。
        Optional<String> s = zz1.flatMap(Person::getValue);
        System.out.println("-----年龄:" + s.get());

        // isPresent: Optinal的成员方法; 功能：判断调用者是否存在，存在返回true；否则返回其他。
        Person zz3 = new Person("2", "3", null);
        // Optional<Integer> age = Optional.of(zz3.getAge());
        // boolean present = age.isPresent();
        boolean present = zz1.isPresent();
        System.out.println("-----isPresent判断调用者存在性：" + present);

        // ifPresent: Optinal的成员方法; 功能：判断调用者是否存在。函数参数可以写成lambada表达式形式，针对表达式参数进行一些操作，函数处理无返回值。
        zz1.ifPresent(person -> {
            //Todo：做一些操作
            person.setAge(33);
        });
        System.out.println("-----年龄:" + zz1.get().getAge());

        System.out.println("-----zz3:" + zz3);
        // filter: Optinal的成员方法; 功能：Optional调用filter,根据参数判断过滤返回符合条件的结果。
        Optional<Person> person = Optional.of(zz3).filter(person1 -> {
            boolean b = person1.getAge() == null;
            return b;
        });
        System.out.println("-----年龄:" + person.get());

    }
}
