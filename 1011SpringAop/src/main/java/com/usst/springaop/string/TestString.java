package com.usst.springaop.string;

import java.util.Arrays;

public class TestString {
    public static void main(String[] args) {
        String data[] = {"abs", "abc","ss"};
        Arrays.asList(data).forEach(e->{
            int a1 = e.indexOf("bs");
            int b = e.lastIndexOf("b");

            String[] split = e.split(",");
            Arrays.asList(split).forEach(d->{
                System.out.println(d);
            });
            //
            // if (a1>=0){
            //     System.out.println(e.charAt(a1));
            // }
            // if (b>=0){
            //     System.out.println(e.charAt(b));
            // }
            // System.out.println(e);
        });
    }
}
