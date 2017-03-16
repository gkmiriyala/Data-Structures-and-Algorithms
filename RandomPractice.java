package commonInterviewQuestions;

import java.util.ArrayList;

public class RandomPractice {
	public static void main(String[] args) {
		//RandomInterview rand = new RandomInterview();
		//printArr(rand.fibUptoNLoop(3));
		//System.out.println(rand.fibAtNRecur(3));
		String[] phoneMap = {"0", "1","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
		System.out.println(allPosStrPhonePad(phoneMap, "525"));
		System.out.println(allPosStrPhonePad(phoneMap, "525").size());
	}
	
	/*
	 * Print the sequence of fibonacci numbers upto a given nth elements using loops
	 */
	public int[] fibUptoNLoop(int n){
		int[] arr = new int[n+1];
		arr[0]=0;
		if(n==0) return arr;
		arr[1]=1;
		if(n==1) return arr;
		for(int i=2;i<=n;i++){
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr;
	}
	
	/*
	 *  Print the fibonacci number at the given nth element using Recursion
	 */
	public int fibAtNRecur(int n) {
		if (n==0) return 0;
		if (n==1) return 1;
		return fibAtNRecur(n-1) + fibAtNRecur(n-2);
	}
	
	/*
	 * Return all possible strings based on a given sequence of digits and
	 * the characters associated with the digits on a phone number pad
	 */
	public static ArrayList<String> allPosStrPhonePad(String[] phoneMap, String numberSeq) {
		ArrayList<String> allPosStrings = new ArrayList<String>();
		ArrayList<String> tempPosStrings = new ArrayList<String>();
		allPosStrings.add("");
		for (int i=0;i<numberSeq.length();i++){
			int digit = Character.getNumericValue(numberSeq.charAt(i));
			for (String s: allPosStrings) {
				String numPadString = phoneMap[digit];
				for (int j=0;j<numPadString.length();j++){
					String charFromMap = Character.toString(numPadString.charAt(j));
					tempPosStrings.add(s+charFromMap);
				}
			}
			allPosStrings = tempPosStrings;
			tempPosStrings = new ArrayList<String>();
		}
		return allPosStrings;
	}
	
	/*
	 * print characters from an array in sequence
	 */
	public static void printArr(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
}
