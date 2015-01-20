package com.java8.functional;

import java.util.function.BiFunction;

/**
 * Created by prakash on 1/17/15.
 */
public class FirstClassCitizens {

    public static void main(String[] args) {


        // Here we've shoved the functions into the variable concatFunction  and passed it around which means functions
        // can be considered as first class citizens.
        BiFunction<String, String, String> concatFunction = (s, t) -> {
            return s + t;
        };
        System.out.println("Prakash + Joshi = " + concatFunction.apply("Prakash ", "Joshi"));

        BiFunction<String,String,String> concatFunction2 = FirstClassCitizens::concatString;
        System.out.println("Hello + World = " + concatFunction2.apply("Hello ","World"));

        FirstClassCitizens f1 = new FirstClassCitizens();
        BiFunction<String ,String,String> concatFunction3 = f1::concatString2;
        System.out.println("Hello + Prakash = " + concatFunction3.apply("Hello ","Prakash"));
    }

    private static String concatString(String a , String b){
        return a+b;
    }

    private String concatString2(String a ,String b){
        return a + b;
    }
}