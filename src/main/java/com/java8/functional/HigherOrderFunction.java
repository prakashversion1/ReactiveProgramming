package com.java8.functional;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by prakash on 1/17/15.
 */
public class HigherOrderFunction {

    public static void main(String[] args) {
        Supplier<String> a = createCombineAndTransform("Prakash ","Joshi" ,toUpperCase);
        System.out.printf("The transormation = " + a.get());
    }

    public static Function<String,String> toUpperCase = (s) -> {
      return  s.toUpperCase();
    };

    public static Supplier<String> createCombineAndTransform(String a, String b,
                                                             Function<String,String> transformer )
    {
        return () -> {
            String aa = a;
            String bb = b;
            if(transformer != null){
                aa = transformer.apply(a);
                bb = transformer.apply(b);
            }
            return aa+bb;
        };
    }
}
