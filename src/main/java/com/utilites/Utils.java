package com.utilites;

import com.google.common.primitives.Ints;
import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prakash on 1/21/15.
 */
public class Utils {


    /**
     * Function that generates 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
     * @return
     */
    public static List generateFibonaaciList(int n){
        List<Integer> holder = new ArrayList<>();
        int counter = 1;
        for(int i=0;i<n;i++){
            if (i==0 || i==1){
                holder.add(i);
            }else{
                holder.add(holder.get(holder.size()-1)+holder.get(holder.size()-2));
            }
        }
        return holder;
    }


    public static int[] generateFibonacciAsArray(int n){
         return Ints.toArray(generateFibonaaciList(n));

    }
}
