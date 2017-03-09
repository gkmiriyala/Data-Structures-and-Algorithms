package com.practice;

import java.util.ArrayList;

public class StringsPractice {
	public static void main(String[] args) {
		StringsPractice pal = new StringsPractice();
		//System.out.println(pal.numPal("abaaa"));
		//System.out.println(pal.isPalRecursion("abaab"));
		System.out.println(pal.minCharForPal("abcebec"));
	}
	
	/*
	 * Find all distinct palindromic substrings of a given string. Input: “abaaa”
	 * Output: Below are 5 palindrome sub-strings
	 * a, aa, aaa, aba, b
	 */
	public int numPal(String str) {
		String s = "";
		ArrayList<String> set = new ArrayList<String>();
		for (int i = 0; i<str.length();i++) {
			for (int j=i; j<str.length();j++) {
				s= s.concat(Character.toString(str.charAt(j)));
				if(isPal(s) && !set.contains(s)) {
					System.out.println(s);
					set.add(s);
				}	
			}
			s="";
		}
		return set.size();
	}
	
	/*
	 * Return whether a given String is a palindrome or not
	 */
	public boolean isPal(String s) {
		for (int i = 0; i<s.length(); i++) {
			if (s.charAt(i)!=(s.charAt(s.length()-1-i)))
				return false;
		}
		return true;
	}
	
	/*
	 * Return whether a given String is a palindrome or not
	 * Use Recursion
	 */
	public boolean isPalRecursion(String s) {
		if(s.length()<2)
			return true;
		else if((s.charAt(0)!=s.charAt(s.length()-1)))
			return false;
		return isPalRecursion(s.substring(1, s.length()-1));
	}
	
	/*
	 * Return the minimum number of characters to add to a String to make it a palindrome
	 */
	public int minCharForPal(String s) {
		int left = 0;
		int right = s.length()-1;
		while(left<right) {
			if (s.charAt(left)!=s.charAt(right))
				left++;
			else break;
		}
		int tempLeft=left;
		int tempRight = right;
		while (left<right) {
			if (s.charAt(left)!=s.charAt(right)) {
				return tempRight;
			}
			else {
				left++;
				right--;
			}
		}
		return tempLeft;
	}
}
