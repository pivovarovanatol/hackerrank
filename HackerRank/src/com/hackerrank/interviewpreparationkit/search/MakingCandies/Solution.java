package com.hackerrank.interviewpreparationkit.search.MakingCandies;
// https://www.hackerrank.com/challenges/making-candies/problem

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
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) throws IOException {

    	Instant programStart = Instant.now();
    	
        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\search\\MakingCandies\\data.txt");
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\search\\MakingCandies\\result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        String[] mwpn = scanner.nextLine().split(" ");
        
        long m = Long.parseLong(mwpn[0]);

        long w = Long.parseLong(mwpn[1]);

        long p = Long.parseLong(mwpn[2]);

        long n = Long.parseLong(mwpn[3]);

        long result = minimumPasses(m, w, p, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
        
        System.out.println(result);
        Instant programEnd = Instant.now();
        Duration timeElapsed = Duration.between(programStart, programEnd);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
        
    }
    
    

    // Complete the minimumPasses function below.
    static long minimumPasses(long m, long w, long p, long n) {

    	double currentAmount = 0;
    	long count=1;
    	double currentCapacity=0;
    	long newHires=0; 
    	long newMachines=0; 

    	
    	while (currentAmount < n) {
    		
			currentAmount -= (newHires+newMachines)*p; 
			newHires=0;
			newMachines=0;
    		currentCapacity = m * w; 
    		currentAmount+=currentCapacity;
    		if (currentAmount>=n) {
    			break;
    		}

    		if (currentCapacity < p) {
    			
    			double diff = p / (currentCapacity)-1;
    			currentAmount += diff * currentCapacity;
    			count+=diff;
    		}
    		else {
           		count++;
    		}
    		
    		
    		
    		if (n > currentCapacity + currentAmount) {
	    			
	    		if (currentAmount >= p*2) {
	    			newHires = (long) (currentAmount/p/2);
	    			newMachines = (long) (currentAmount/p/2);
	    			m+=newMachines;
	    			w+=newHires;
	    		} else {
	        		if (currentAmount >= p) {
	        			if (m > w) {
	        				currentAmount-=p;
	        				w++;
	        			} else {
	        				currentAmount-=p;
	        				m++;
	        			}
	    		}
    		}
    			
    		}


    		
    	}
    	
    	return count;
    }    
    
    static void printArray(long[] arr) {
    	for (int i=0;i<arr.length;i++) {
    		System.out.print(arr[i] + " ");
    	}
    	System.out.println();
    }
}


