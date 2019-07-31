package com.hackerrank.interviewpreparationkit.search.Pairs;
// https://www.hackerrank.com/challenges/pairs/problem

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
    	
        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\search\\Pairs\\data.txt");
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\search\\Pairs\\result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();

        System.out.println(result);
        Instant programEnd = Instant.now();
        Duration timeElapsed = Duration.between(programStart, programEnd);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

        
    }
    
    

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
    	int result=0;
    	int n = arr.length;
    	int diff=0;
    	Hashtable<Integer, Integer> numbers = new Hashtable<Integer, Integer>();
    	
    	for (int i=0;i<n;i++) {
        	int count = 0;
    		if (numbers.containsKey(arr[i])) {
    			count = numbers.get(arr[i]);
    			count++;
        		numbers.put(arr[i], count);
    		}
    		numbers.put(arr[i], 1);
    	}
    	
    	for (int i=0;i<n;i++) {
    		diff = arr[i] - k;
    		
    		if (diff < 0) {
    			continue;
    		}
    		
    		if (numbers.containsKey(diff)) {
    			if (diff==arr[i]) {
        			int count = numbers.get(arr[i]);
        			if (count > 1) {
        				result++;
        			} else {
        				continue;
        			}
    			}
    			result++;
    		}
    	}
    	
    	return result;
    }
    
    
    
    

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        Map<Integer,Integer> map = new HashMap<>();
        
        // Put first difference in the map
        map.put(money-cost[0],1);
        
        // Iterate over costs to find match
        for(int i=1; i<cost.length; i++) {
        	
        	// check if map already has a diff - then just print it out and return
            if(map.containsKey(cost[i])) {
                System.out.println(map.get(cost[i])+" "+(i+1));
                break;
            }
            // else put current difference in the map with it's index
            else if(!map.containsKey(cost[i])&&money-cost[i]>0) {
                map.put(money-cost[i], i+1);
            }
        }

    }    
    
    
    
    
    
}


