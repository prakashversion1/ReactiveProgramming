package com.betterTest;

/**
 * Created by prakash on 1/17/15.
 */
public class PureFunctions {

    private int state = 0;

    // Example of a pure function which has no side effects
    public int f1(int x){
        return x * 2;
    }

    // Example of a non pure function
    public int f2(int x){
        System.out.println("value of state is : "+ state);
        state = (++state%3);
        return x*2 + state;
    }

    public static void main(String[] args) {
        PureFunctions v1 = new PureFunctions();
        System.out.println("for the 1st time : " + 2%3);
        //This function provides the basis that for all iteration the value is 10;
        for (int i=0; i<100; i++){
            if (v1.f1(5) != 10){
                throw new IllegalStateException();
            }
        }
        System.out.println("The value for f1(5)=10 for all those iterations");

        for(int i=0; i<100; i++){
            System.out.println("The value of f2(5) = " + v1.f2(5));
        }


    }

}
