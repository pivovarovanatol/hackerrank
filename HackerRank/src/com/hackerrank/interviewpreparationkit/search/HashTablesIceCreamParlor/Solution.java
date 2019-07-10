package com.hackerrank.interviewpreparationkit.search.HashTablesIceCreamParlor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

        long result = 0;

        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\search\\HashTablesIceCreamParlor\\data.txt");
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\search\\HashTablesIceCreamParlor\\result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }
        bufferedWriter.close();
        scanner.close();

    }
    
    
    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
    	
    	Hashtable<Integer, Integer> cost1 = new Hashtable<Integer, Integer>();
    	int n = cost.length;
    	for (int i=0;i<n;i++) {
    		cost1.put(cost[i], i);
    	}
    	
    	for (int i=0;i<n;i++) {
    		int price1 = cost[i];
    		int diff = money - price1;
    		
	    		if (cost1.containsKey(diff)) {
	    			int index1 = i+1;
	    			int index2 = cost1.get(diff)+1;
	    			
	    			if (index1!=index2) {
		    			if (index1 <= index2) {
		        			System.out.println(index1 + " " + index2);
		    			} else {
		        			System.out.println(index2 + " " + index1);
		    			}
		    			break;
	    			}
	    		} else {
	    			
	    			for (int j=0;j<n;j++) {
	    				if (cost[j]==diff && j !=i) {
	    	    			int index1 = i+1;
	    	    			int index2 = j+1;
	    	    			
	    	    			
	    	    			if (index1 <= index2) {
	    	        			System.out.println(index1 + " " + index2);
	    	    			} else {
	    	        			System.out.println(index2 + " " + index1);
	    	    			}
	    	    			break;
	    			}
	    		}
    		} 
    	}

    }
    
    
    
    
    
    
}


