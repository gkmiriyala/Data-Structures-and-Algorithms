package com.practice;

public class SortingPractice {
    
    public static void main(String a[]){
       int[] input = {4,5,6,1,2,3};
       quickSort(input, 0, input.length-1);
       for(int i:input){
            System.out.print(i);
            System.out.print(" ");
       }
    }
 
    /*
     * Implement the Quick Sort Method
     */
    private static void quickSort(int[] arr, int lowerIndex, int higherIndex) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = arr[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(arr, i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(arr, lowerIndex, j);
        if (i < higherIndex)
            quickSort(arr, i, higherIndex);
    }
 
    private static void exchangeNumbers(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
