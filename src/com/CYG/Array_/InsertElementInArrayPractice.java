package com.CYG.Array_;

public class InsertElementInArrayPractice {
    /*
    Goal: Insert one element to a sorted array to make it still sorted.
     */
    /*
    My Design:
     1. Array has fixed length, so a new array with one addtional space is needed.
     2. To insert the element in the array, two steps are needed.
        A. Find the location/index for insertion.
        B. Copy the element into the new array, with the inserted element.
     */
    public static void main(String[] args) {
        int[] originalArray = {11, 22, 33, 44, 55};
        System.out.println("====The original array is ====");
        for (int i = 0; i < originalArray.length; i++) {
            System.out.print(originalArray[i] + "\t");
        }
        int element = 40;
        int[] insertedArray = insertElement(originalArray, element);
        System.out.println(" ");
        System.out.println("====The new array after element " + element + " insertion is ====");
        for (int i = 0; i < insertedArray.length; i++) {
            System.out.print(insertedArray[i] + "\t");
        }
    }

    public static int[] insertElement(int[] arr, int insert) {
        //A. Find the location/index for insertion.
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= insert) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            index = arr.length;
        }
        //Test if the index is found.
        //System.out.println("index = " + index);
        //B. Copy the element into the new array, with the inserted element.
        //int[] arrNew[arr.length + 1];//Wrong. array is object, needs to be "new".
        int[] arrNew = new int[arr.length + 1];
        for (int i = 0, j = 0; i < arrNew.length; i++) {
            if (i != index) {
                arrNew[i] = arr[j];
                j++;
            } else {
                arrNew[i] = insert;
            }
        }
        //For testing use.
        return arrNew;
    }
}
