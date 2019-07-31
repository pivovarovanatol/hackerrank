package com.hackerrank.interviewpreparationkit.search.TripleSum;
// https://www.hackerrank.com/challenges/triple-sum/problem
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

    	Instant programStart = Instant.now();
    	
        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\search\\TripleSum\\data1.txt");
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\search\\TripleSum\\result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();


        System.out.println(ans);
        Instant programEnd = Instant.now();
        Duration timeElapsed = Duration.between(programStart, programEnd);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

        
    }
    
    

    // Complete the triplets function below.
    static long triplets_naive(int[] a, int[] b, int[] c) {
    	long count=0;
    	
    	Hashtable<String, Integer> triplets= new Hashtable<String, Integer>();
    	int len_a = a.length;
    	int len_b = b.length;
    	int len_c = c.length;
    	
    	// rewrite as custom code
    	Arrays.sort(a);
    	Arrays.sort(b);
    	Arrays.sort(c);
    	
    	int max_b = b[len_b-1]; 
    	int end_a = len_a; 
    	int end_c = len_c; 
    	
    	for (int i=0;i<len_a;i++) {
    		if (a[i]>max_b) {
    			end_a = i;
    			break;
    		}
    	} 
    	
    	for (int i=0;i<len_c;i++) {
    		if (c[i]>max_b) {
    			end_c = i;
    			break;
    		}
    	} 
    	
    	
    	for (int i=0;i<len_b;i++) {
    		//get 
    		
    		for (int j=0;j<end_a;j++) {
        		for (int k=0;k<end_c;k++) {
        			if (a[j]<=b[i] && c[k]<=b[i]) {
            			triplets.put(a[j] + "|" + b[i] + "|"+c[k], 0);
            			//System.out.println(a[j] + "|" + b[i] + "|"+c[k]);
        			}
        		}
    		}
    	}
    	
    	count = triplets.size();
    	
    	return count;

    }    
    

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
    	long count=0;
    	int len_a = a.length;
    	int len_b = b.length;
    	int len_c = c.length;

        int[] a1 = Arrays.stream(a).sorted().distinct().toArray();
        int[] b1 = Arrays.stream(b).sorted().distinct().toArray();
        int[] c1 = Arrays.stream(c).sorted().distinct().toArray();
        
    	// printArray(c);
    	

//    	for (int i=0;i<len_b;i++) {
//    		int currValue = b[i];
//    		long countA = getIndex(a, currValue, 0, len_a-1)+1;
//    		long countC = getIndex(c, currValue, 0, len_c-1)+1;
//    		
//    		count += (countA * countC);
//    	}
    	
    	for (int i=0;i<b1.length;i++) {
    		long index_a = 0;
    		long index_c = 0;
    		for (int j=0;j<a1.length;j++) {
    			if (a1[j]>b1[i]) {
    				break;
    			}
    			index_a=j+1;
    		}
    		
    		for (int k=0;k<c1.length;k++) {
    			if (c1[k]>b1[i]) {
    				break;
    			}
    			index_c=k+1;
    		}
    		
    		count += (long)index_a * (long)index_c; 
    	}
    	
    	
    	return count;

    }    

    static int getIndex(int[] arr, int value, int start, int end) {
    	// looking for an index of the element or next smaller element in the sorted array.
    	
    	if (start==end-1) {
    		
    		if (arr[start]>value) {
    			return -1;
    		}

    		if (arr[start]<=value && arr[end]>value) {
    			return start;
    		}
    		
    		if (arr[end]<=value) {
    			return end;
    		}
    		
    	}

    	int mid = start + (end - start)/2;
    	
    	int midValue = arr[mid];
    	
    	if (midValue > value) {
    		return getIndex(arr, value, start, mid);
    	}
    	
    	if (midValue <= value) {
    		return getIndex(arr, value, mid, end);
    	}
    	
    	return 0;
    }


    static void printArray(int[] arr) {
    	for (int i=0;i<arr.length;i++) {
    		System.out.print(arr[i] + " ");
    	}
    	System.out.println();
    }
}


