package com.CYG.BubbleSort_;

public class BubbleSortTest {
    public static void main(String[] args) {
        /*
        Goal of Program:
        1. Write my own code to implement bubble sort for an array.
         */
        /*
        My Design:
        1. initialize an int array
        2. Find the largest number of the array, and save it as the last element in the array.
        3. Use loop to repeat 2 to find the rest of the elements in order.
         */
        //Here is the code~
        //Try git commit.
        //1. initialize an int array
        int[] arr = {44, 55, 22, 33, 11};
        int temp;
        //2. Find the largest number of the array, and save it as the last element in the array.
        //3. Use loop to repeat 2. to find the rest of the elements in order.
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int p: arr) {
            System.out.print(p + "\t");
        }
        //try git commit again.

    }
}
