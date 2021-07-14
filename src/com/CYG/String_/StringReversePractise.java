package com.CYG.String_;
import java.util.Arrays;

public class StringReversePractise {
    public static void main(String[] args) {
        /*
        Goal: Write a function that reverses a string with the start and end index.
         */
        /*
        My design:
        1. String is immutable, so it needs to be convert to char[] charArray first.
        2. Use two pointers i and j to swap element in charArray .
            A. i move from the left to right
            B. j move from right to left.
            C. swap data from the charArray[i] and charArray[j].
            D. when i>=j stop swapping. (Or swapping in condition i<j)
        3. String is immutable, so a new String object s2 needs to be returned from method.
        4. Consider Input exceptions.
         */
        // Here we go~
        String s1 = "abcdefg";
        System.out.println("The original String is " + s1);
        String s2 = StringReverse(s1, 2, 6);
        System.out.println("=============================");
        System.out.println("The reversed String is " + s2);
    }

    public static String StringReverse(String str, int startIndex, int endIndex){ //throws RuntimeException {//Wrong
    //Why RuntimeException? If checked Exception, it require the main method to declare or handle it.
        if(str == null) {
            System.out.println("The input String is null");
            //throw RuntimeException;//No need to write this statement, since JVM will throw "NullPointerException"
        }else if (!(startIndex > 0 && startIndex < endIndex && endIndex < str.length())){
            System.out.println("The input index is not valid");
            //throw IllegalArgumentException;
        }
        // 1. String is immutable, so it needs to be convert to char[] charArray first.
        char[] charArray = str.toCharArray();
        //2. Use two pointers i and j to swap element in charArray .
        //   A. i move from the left to right
        //   B. j move from right to left.
        //   C. swap data from the charArray[i] and charArray[j].
        //   D. when i>=j stop swapping. (Or swapping in condition i<j)
        for(int i = startIndex, j = endIndex; i < j; i++, j--) {
            char swap = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = swap;
        }
        //3. String is immutable, so a new String object s2 needs to be returned from method.
        //String s = charArray.toString(); //Wrong, the return is a hash code like [C@1540e19d
        //Attn: array char[] does not have a toString() method. so the Object toString()method is called.
        //String s = Arrays.toString(charArray);// Still wrong. The return is [f, e, d, c, b, a, g]
        //String s = new String(charArray);//Yes. Constructor is needed to create the String we want.
        return  new String(charArray);
    }
}
