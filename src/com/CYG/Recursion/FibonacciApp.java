package com.CYG.Recursion;

public class FibonacciApp {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(-1));

    }

    /* Problem: Find the fibonacci number for n.
    The fibonacci number looks like : 1, 1, 2, 3, 5, 8, 13...
    */
    /*
    My Design:
    1. when n = 1, or n = 2, return 1.
    2. when n >= 3, fib(n) = f(n - 1) + f(n -2 ).
    3. Deal with illegal input.
     */
    public static int fibonacci(int n){
        int fibNum;

        // 1. when n = 1, or n = 2, return 1.
        // 2. when n >= 3, fib(n) = f(n - 1) + f(n -2 ).
        // 3. Deal with illegal input.
        if (n <= 0){
            //System.out.println("Your input is illegal, please input a positive integer.");
            //return -1;
            //With the return -1 above, the method will return -1 with the input is illegal.
            //To improve design, I want do not return any number for illegal input. --> use exception.

            throw new IllegalArgumentException("\"Your input is illegal, please enter a positive integer.\"");
        }

        if (n == 1 || n ==2)
            fibNum = 1;
        else{
           fibNum = fibonacci(n - 1) +fibonacci(n - 2);
        }
        return fibNum;
    }

}


