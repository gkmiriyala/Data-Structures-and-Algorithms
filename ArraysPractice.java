package com.practice;

import java.util.ArrayList;

public class ArraysPractice {
	public static void main(String[] args){
		int[] arr = {-3, -1, -2, -8};
		//System.out.println(elementAppearsOnceInArray(arr));
		//System.out.println(magicIndexDistinctValues(arr));
		//System.out.println(duplicateInArray(arr));
		//System.out.println(elementInArrayDifferenceOfOne(arr, 8));
		System.out.println(maxContSum(arr));
	}
	
	/*
	 * 1)	Find the element that appears once in a sorted array where all the other 
	 * elements appear twice one after another. Find that element in O(logn) complexity.
	 * Input: arr[] = {1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8}		Output: 4
	 */
	public static int elementAppearsOnceInArray(int[] arr){
		int left=0;
		int right=arr.length-1;
		while (left<=right) {
			int mid=(left+right)/2;
			if(mid%2!=0) {
				if(mid+1<arr.length && arr[mid]==arr[mid-1])
					left=mid+1;
				else if(mid-1>=0&&arr[mid]==arr[mid+1])
					right=mid-1;
				else return arr[mid];
			}
			else {
				if(mid+1<arr.length&&arr[mid]==arr[mid+1])
					left=mid+1;
				else if(mid-1>=0&&arr[mid]==arr[mid-1])
					right=mid-1;
				else return arr[mid];
			}
		}
		return -1;
	}
	
	/*
	 * 2)	A magic index in an array A[0….n-1] is defined to be an index such that A[i] = i. 
	 * Given a sorted array of distinct integers, write a method to find a magic index if once 
	 * exists, in an array A. FOLLOW UP: What if the values are not distinct?
	 * Return the first
	 */
	public static int magicIndexDistinctValues(int[] arr){
		if(arr[0]>0) return -1;
		if(arr[0]==0) return 0;
		else{
			int left=1;
			int right=arr.length-2;
			while(left<=right) {
				int mid=(left+right)/2;
				if(arr[mid]<mid) left =mid+1;
				else if(arr[mid]>mid) right=mid-1;
				else return mid;
			}
		}
		return -1;
	}
	
	/*
	 * 3)	Given a sorted array of n integers that has been rotated an unknown number of times, 
	 * write code to find an element in the array. You may assume that the array was originally 
	 * sorted in increasing order.
	 * Contiguous?
	 * Will the element always exist in the array?
	 */
	public int elementInArray(int[] arr){
		return 0;
	}
	
	/*
	 * 4)	Given an array that contains numbers from 1 to n-1 and exactly 1 duplicate, 
	 * find that duplicate. {1,2,3,4,4,5}
	 */
	public static int duplicateInArray(int[] arr) {
		int left=0;
		int right=arr.length-1;
		while(left<=right){
			int mid = (left+right)/2;
			if (mid%2==0){
				if (arr[mid]%2==0) {
					if (mid-1>=0&&arr[mid]==arr[mid-1]) return arr[mid];
					else right=mid-1;
				}
				else {
					if (mid+1<arr.length&&arr[mid]==arr[mid+1]) return arr[mid];
					else left=mid+1;
				}
			}
			else {
				if (arr[mid]%2!=0) {
					if (mid-1>=0&&arr[mid]==arr[mid-1]) return arr[mid];
					else right=mid-1;
				}
				else {
					if (mid+1<arr.length&&arr[mid]==arr[mid+1]) return arr[mid];
					else left=mid+1;
				}
			}
		}
		return -1;
	}
	
	/*
	 * 5)	Search an element in an array where difference between adjacent elements is 1.
	 * For example: arr[] = {8,7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3} return the index
	 */
	public static int elementInArrayDifferenceOfOne(int[] arr, int n) {
		int targetIndex = Math.abs(arr[0]-n);
		while(targetIndex<arr.length){
			if(arr[targetIndex]==n) return targetIndex;
			else targetIndex=targetIndex+Math.abs(arr[targetIndex]-n);
		}
		return -1;
	}
	
	/*
	 * 6)	Given an array of numbers, split the array into two where one array contains the 
	 * sum of n-1 numbers and the other array with all the n-1 elements.
	 */
	public ArrayList<ArrayList<Integer>> splitArrayToContainSum(int[] arr) {
		ArrayList<ArrayList<Integer>> listWithList = new ArrayList<ArrayList<Integer>>();
		return listWithList;
	}
	
	/*
	 * Return the maximum sum of set of contiguous values within an array
	 */
	public static int maxContSum(int[] arr) {
		int largest = arr[0];
		for(int i=0; i<arr.length;){
			if(arr[i]<0) {
				if(arr[i]>largest) {
					largest = arr[i];
				}
				i++;
			}
			else {
				int sum=0;
				while (i<arr.length&&arr[i]>=0){
					sum = sum + arr[i];
					i++;
				}
				if(sum>largest) largest=sum;
			}
		}
		return largest;
	}
}
