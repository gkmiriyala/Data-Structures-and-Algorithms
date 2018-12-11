/*
 * Consider an array of numeric strings, unsorted, where each string is a positive number with anywhere from 1 to 10^6 digits.
 * Sorth the array's elements in non-decreasing (i.e., ascending) order of their real-world integer values and print each 
 * element of the sorted array on a new line.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        // your code goes here
        
        Comparator<String> sortStrings = new Comparator<String>(){
        public int compare(String o1, String o2) {
            if (o1.length()>o2.length()) return 1;
            if(o1.length()<o2.length()) return -1;
            int i = 0;
            while (i<o2.length()||i<o1.length()) {
                if (o1.charAt(i)>o2.charAt(i)) return 1;
                if (o1.charAt(i)<o2.charAt(i)) return -1;
                i++;
            }
            return 0;
        }
    };
        
	Map<String, Integer> sortedTreeMap = new TreeMap<String, Integer>(sortStrings);                
    
    for (int i = 0; i<n; i++) {
        if (sortedTreeMap.containsKey(unsorted[i])) {
            sortedTreeMap.put(unsorted[i], sortedTreeMap.get(unsorted[i])+1); 
        }
        else {
            sortedTreeMap.put(unsorted[i], 1);
        }
    }
        
	for(Map.Entry<String, Integer> entry : sortedTreeMap.entrySet()) {
        while(sortedTreeMap.get(entry.getKey())>0) {
		  System.out.println(entry.getKey());
          sortedTreeMap.put(entry.getKey(), sortedTreeMap.get(entry.getKey())-1);           
	    }
    }
    }
};