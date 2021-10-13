package com.usst.springaop.java8;

import java.util.*;
import java.util.stream.Collectors;

public class lambda {
    public static void main(String[] args) {
        //Astream
        // List<String> strings = Arrays.asList("a", "b", "c");
        //
        // List<Object> collect = strings.stream().map(e -> {
        //     e = e+"--haha--stream!";
        //     System.out.println(e);
        //     return e;
        // }).collect(Collectors.toList());
        //
        // collect.forEach(e->{
        //     System.out.println(e);
        // });

        ArrayList<Person> peoples = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (i % 2 != 0) {
                {
                    peoples.add(new Person(i + "lisi", "123456", "徐汇凌云路", "123@163.com", "123456", 1000f * i, 1));
                }
            }
            if (i % 2 == 0) {
                peoples.add(new Person(i + "zhangsan", "123456", "徐汇凌云路", "123@163.com", "123456", 1000f * i, 1));
            }
        }

        //filter用来做判断的,筛选记录功能。
        long count = peoples.stream().filter(person -> {
            boolean b = person.getSalary() > 0f;
            // if (person.getSalary() > 0f) {
            //     person.setSalary(person.getSalary());
            // } else {
            //     person.setSalary(person.getSalary() + 1000f);
            // }
            person.setSalary(person.getSalary() + 1000f);
            return b;
        }).count();
        // System.out.println(count);


        //map用来针对每个元素进行些修改(更新、添加)操作。可以在原数据直接修改，可以返回新的对象数据。
        // peoples.stream().map(person -> {
        // Person person1 = new Person();
        // person1.setSalary(person.getSalary() + 1000f);
        // person1.setPassword(person.getPassword());

        // person.setPassword("400");
        // return person;

        // }).collect(Collectors.toSet()).forEach(person -> {
        // System.out.println(person.toString());
        // });


        //map用来针对每个元素获取记录中的所需字段,构造成map形式。
        peoples.stream().map(person -> {
            Map<String, String> map = new HashMap<>();
            map.put("username", person.getUsername());
            map.put("password", person.getPassword());
            return map;
        }).collect(Collectors.toSet()).forEach(person -> {
            Set<String> strings = person.keySet();
            strings.forEach(e -> {
                // System.out.println(person.get(e));
            });
        });

        //map用来针对每个元素获取记录中的所需字段,构造成list形式。
        //sort排序
        peoples.stream().skip(2).limit(3).sorted(
                Comparator.comparing(Person::getUsername)).collect(Collectors.toList()).forEach(e -> {
            // System.out.println(e);
        });

        //sort排序 min max
        peoples.forEach(e -> {
            System.out.println("person:" + e);
        });

        Optional<Person> min = peoples.stream().skip(2).sorted(
                Comparator.comparing(Person::getUsername)).limit(3).min(Comparator.comparing(Person::getSalary));
        System.out.println(min.get());

        Optional<Person> max = peoples.stream().skip(2).sorted(
                Comparator.comparing(Person::getUsername)).limit(3).max(Comparator.comparing(Person::getSalary));
        System.out.println(max);

        Person person = peoples.parallelStream().findFirst().get();
        Optional<Person> any = peoples.parallelStream().findAny();

        System.out.println("-------------findFirst()----findAny()------------");
        System.out.println("parallelStream--optional::{}" + person);
        System.out.println("parallelStream--optional::{}" + any);

        System.out.println("---------------------reduce()--------------------");
        Float reduce = peoples.stream().map(Person::getSalary).reduce(1F, Float::sum);
        System.out.println(reduce);


    }
}
