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
    	
    	for (int i = d; i<expenditure.length;i++) {
    		start = i-d;
    		finish = i-1;
    		median = getMedian(expenditure, start, finish);
    		//System.out.println(median);
    		if (expenditure[i]>= median*2) {
    			count++;
    		}
    	}
    	
    	return count;
    }

    static int getMedian(int arr[], int start, int finish) 
    { 

    	int n = finish - start+1;
        int[] tmp = new int[n];
    	
        for (int i=start;i<=finish;i++) {
        	tmp[i-start]=arr[i];
        }
        
        Arrays.sort(tmp);
        int median = 0;
        
        if (n%2 == 0) {
            int index = n/2;
            median = (tmp[index]+tmp[index+1])/2;
        } else {
            int index = n/2;
            median = (tmp[index]);
        }
        
        //printArray(tmp);
        //System.out.println(median);
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