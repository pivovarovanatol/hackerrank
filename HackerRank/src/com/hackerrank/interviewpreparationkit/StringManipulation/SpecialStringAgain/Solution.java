package com.hackerrank.interviewpreparationkit.StringManipulation.SpecialStringAgain;
// https://www.hackerrank.com/challenges/special-palindrome-again/

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
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

    	Instant programStart = Instant.now();
    	
        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\StringManipulation\\SpecialStringAgain\\data1.txt");
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\StringManipulation\\SpecialStringAgain\\result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        String s = scanner.nextLine();

        long result = substrCount(n, s);

        System.out.println(result);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();


        Instant programEnd = Instant.now();
        Duration timeElapsed = Duration.between(programStart, programEnd);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

        
    }
    
    
    // Complete the substrCount function below.
    static long substrCount(int n, String s) {

    	char[] arr = s.toCharArray();
    	//System.out.println(isSpecial(arr,0,arr.length));
    	int count =0;
    	for (int i=0;i<n;i++) {
    		for (int j=i;j<n;j++) {
    			count +=isSpecial(arr,i,j);
    		}
    	}
    	
    	return count;
    }   
    
    
    static int isSpecial(char[] chrs, int start, int end) {
    	
    	if (end-start<1) {
			//System.out.println(chrs.toString() + ": " + start + " - " + end + " is special");
    		return 1;
    	}
    	
    	char tmp = chrs[start];
    	int n = end-start+1;
		int mid = n/2;
    	for (int i=0;i<n;i++) {
    		if (chrs[start+i]!=tmp) {
    			if (n%2==0) {
    				//System.out.println(chrs.toString() + ": " + start + " - " + end + " not special");
        			return 0;
    			}
    			if (i!=mid) {
    				//System.out.println(chrs.toString() + ": " + start + " - " + end + " not special");
        			return 0;
    			}
    		}
    	}
		//System.out.println(chrs.toString() + ": " + start + " - " + end + " is special");
    	return 1;
    } 
    
}


