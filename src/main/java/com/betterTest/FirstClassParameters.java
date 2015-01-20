package com.betterTest;

import java.util.function.Function;

/**
 * Created by prakash on 1/17/15.
 */
public class FirstClassParameters {
    public static void main(String[] args) {
        System.out.println(concatAndTransform("Prakash ","Joshi",s -> {
            return s.toUpperCase();
        }));

        Function<String,String> toLowerCase = (s) ->
        {
           return s.toLowerCase();
        };


        System.out.println(concatAndTransform("Hello ","Prakash",toLowerCase));
    }

    public static String concatAndTransform(String a, String b ,Function<String,String> transform){
        if(transform != null){
            a = transform.apply(a);
            b = transform.apply(b);
        }
        return a + b;
    }
}
