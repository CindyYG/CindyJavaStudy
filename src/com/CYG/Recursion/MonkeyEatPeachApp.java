package com.CYG.Recursion;

public class MonkeyEatPeachApp {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("The peach number on day " + i + " is " +peachNumberOnDay(i));
        }
    }
    /*
    Problem to solve: 猴子吃桃子的问题： 有一堆桃子，猴子第一天吃了其中一半，并多吃了一个。以后每天猴子都吃其中一半，再多吃一个。
    当第10天，猴子再想吃桃子的时候，发现只有一个桃子了。问最初第一天的时候，有多少桃子？ 第n天的时候，有多少桃子？
     */
    /*
    My thought:
    1. The peach number on each day is a repetitive method of the previous day. (Consider recursion or loop)
    *注意：A.用递归的时候，数据必须是收敛的，发散的不行。 B.递归是： 现在 = function（过去），即，有过去推到现在。
    2. Known:   Day10, peachNum = 1 = (Day09 / 2 - 1). [Day09 = (Day10 + 1) * 2]
                Day09, peachNum = 4 = (Day08 / 2 - 1)  [ Day08 = (Day09 + 1) * 2]
                Day08, peachNum = 10 = (Day07 / 2 - 1)
                Day n，peachNum = ( (Day n-1） / 2 - 1 )
    3. Write method 1st, then, deal with illegal input.
     */
    public static int peachNumberOnDay(int n){
        if (n <=0 || n > 10) {
            throw new IllegalArgumentException("Your day n should be in the range 1=10");
        }
        int peachNum;
        if(n == 10) {
            peachNum = 1;
        }else{
            //peachNum = peachNumberOnDay(n-1)/2 -1;//Why wrong?
            //因为已知是day10，所以是由后面推导前面，由n，推n-1，而不是反过来。
            // 所以递归中，“=”右边是（最后那个）已知，而不是未知。
            // 即 Day09, peachNum = 4 = （Day10 + 1）*2 而不是 (Day08 / 2 - 1) .因为对Day09来说，Day10是已知，Day08是未知。
            peachNum = (peachNumberOnDay(n+1) + 1) * 2;
        }
        return peachNum;
    }

}
