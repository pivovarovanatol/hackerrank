package com.hackerrank.interviewpreparationkit.sorting.FraudulentActivityNotifications;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\sorting\\FraudulentActivityNotifications\\data.txt");
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\sorting\\FraudulentActivityNotifications\\result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        System.out.println(d + " " + n);
        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        //printArray(expenditure);
        int result = activityNotifications(expenditure, d);
        System.out.println(result);
    }


// Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
    	//printArray(expenditure);
    	int start = 0;
    	int finish=d;
    	int median = 0;
    	int count=0;
    	int n = expenditure.length;
    	boolean initial = true;
    	int[] freq = new int[201];
    	int prev_element=0;
    	
    	for (int index=d;index<n;index++) {
    		// Initial d-days spendings - put that into frequency array
    		if (initial) {
    			for (int i=0;i<d;i++) {
    				freq[expenditure[i]] ++;
    			}
    			initial = false;
    			
    		} else {
    			freq[expenditure[index-d-1]]--;
    			freq[expenditure[index-1]]++;
    		}
    			median = getMedian(freq, d);
				System.out.println("Median is " + median + ", Spent is " + expenditure[index]);
    			
    			if (expenditure[index] >= median * 2) {
    				//System.out.println("Median is " + median + ", Spent is " + expenditure[index] + " -> Sent notification!");
    				count++;
    			}
    	}
    	
    	return count;
    }

    static int getMedian(int freq[], int d) 
    { 
        int median = 0;
        int index = 0;
        int n = freq.length;
        int[] pref_sum = new int[n];
        
        
        pref_sum[0] = freq[0];
        
        for (int i=1; i<n;i++) {
        	pref_sum[i] = pref_sum[i-1]+freq[i];
        }
        
        //printArray(freq);
        //printArray(pref_sum);
        
        if (d%2==1) {
        	index = d/2;
        	
        	for (int i=0; i<n;i++) {
        		if(index<pref_sum[i]) {
        			median = i;
        			break;
        		}
        	}
        	
        } else {
        	int index1 = d/2;
        	int index2 = d/2+1;
        	int a = 0, b = 0;
        	int i=0;
        	
        	for (; i<n;i++) {
        		if(index1<pref_sum[i]) {
        			a = i;
        			break;
        		}
        	}
        	
        	for (; i<n;i++) {
        		if(index2<pref_sum[i]) {
        			b = i;
        			break;
        		}
        	}
        	
        	median = (a+b)/2;
        }

        return median;
    } 

    

    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 


    
    
};