package com.hackerrank.interviewpreparationkit.search.MakingCandies;
// https://www.hackerrank.com/challenges/making-candies/problem

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
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
    	
        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\search\\MakingCandies\\data1.txt");
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

    	long currentAmount = 0;
    	long count=0;
    	double currentCapacity=(double)m*w;
    	long newHires=0; 
    	long newMachines=0; 
    	
    	if (currentCapacity>n) {
    		return 1;
    	}
    	
    	while (currentAmount < n) {
    		
			currentAmount -= (newHires+newMachines)*p; 
			newHires=0;
			newMachines=0;
    		currentCapacity = (double)m * w; 
    		if (currentAmount>=n) {
    			break;
    		}

    		//if (currentCapacity + currentAmount < p) {
       		if (currentCapacity + currentAmount < p) {
    			
    			//long diff = p / currentCapacity;
    			long diff = p / (long)currentCapacity;
    			currentAmount += (double)diff * currentCapacity;
    			count+=diff;
    		}
    		else {
           		count++;
        		currentAmount+=(long)currentCapacity;
    		}
    		

    		//count++;
    		
    		
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
    
    
    
 // Complete the minimumPasses function below.
    static long minimumPasses2(long m, long w, long p, long n) {
            long candies = 0;
            long invest = 0;
            long spend = Long.MAX_VALUE;

            while (candies < n) {
                    // preventing overflow in m*w
                    long passes = (long) (((p - candies) / (double) m) / w);

                    if (passes <= 0) {
                            // machines we can buy in total
                            long mw = candies / p + m + w;
                            long half = mw >>> 1;
                            if (m > w) {
                                    m = Math.max(m, half);
                                    w = mw - m;
                            } else {
                                    w = Math.max(w, half);
                                    m = mw - w;
                            }
                            candies %= p;
                            passes++;
                    }

                    // handling overflowing
                    // if overflowing is encountered -> candies count are definitely more than long
                    // thus it is more than n since n is long
                    // so we've reached the goal and we can break the loop
                    long mw;
                    long pmw;
                    try {
                            mw = Math.multiplyExact(m, w);
                            pmw = Math.multiplyExact(passes, mw);
                    } catch (ArithmeticException ex) {
                            // we need to add current pass
                            invest += 1;
                            // increment will be 1 because of overflow
                            spend = Math.min(spend, invest + 1);
                            break;
                    }

                    candies += pmw;
                    invest += passes;
                    long increment = (long) Math.ceil((n - candies) / (double) mw);
                    spend = Math.min(spend, invest + increment);
            }

            return Math.min(spend, invest);
    }
    
    
    
    
    
    
    static void printArray(long[] arr) {
    	for (int i=0;i<arr.length;i++) {
    		System.out.print(arr[i] + " ");
    	}
    	System.out.println();
    }
}


