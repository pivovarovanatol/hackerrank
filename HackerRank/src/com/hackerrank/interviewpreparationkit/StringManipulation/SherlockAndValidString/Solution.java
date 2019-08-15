package com.hackerrank.interviewpreparationkit.StringManipulation.SherlockAndValidString;
// https://www.hackerrank.com/challenges/sherlock-and-valid-string/

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
    	
        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\StringManipulation\\SherlockAndValidString\\data.txt");
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\StringManipulation\\SherlockAndValidString\\result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        String s = scanner.nextLine();

        String result = isValid(s);

        System.out.println(result);
        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();

        Instant programEnd = Instant.now();
        Duration timeElapsed = Duration.between(programStart, programEnd);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

        
    }
    
    
    // Complete the isValid function below.
    static String isValid(String s) {
    	// Convert string to char array
    	char[] arr = s.toCharArray();
    	
    	// Traverse thru array and appearance count for every letter. Use hashmap for that?
    	int[] chars = new int[28];
    	
    	for (int i=0;i<arr.length;i++) {
    		chars[arr[i]-97]++;
    	}
    	
//    	Arrays.sort(chars);
    	
    	HashMap<Integer, Integer> charCounts = new HashMap<Integer, Integer>();
    	for (int i=0;i<28;i++) {
    		
    		if (chars[i]==0) {
    			continue;
    		}
    		if (charCounts.containsKey(chars[i])) {
        		charCounts.put(chars[i], charCounts.get(chars[i]) + 1);
    		} else {
        		charCounts.put(chars[i], 1);
    		}
    	}

    	// All letters have single occurrence
    	if (charCounts.size() == 1) {
    		return "YES";
    	}
    	
    	// If total count of frequencies > 2 - no way we can have one frequency by just one delete -> return "NO" 
    	if (charCounts.size() > 2) {
    		return "NO";
    	}
    	
    	// If two frequencies exists and none of them have only one occurrence - we can't match them with one delete -> return "NO"
    	if (!charCounts.containsValue(1)) {
    		return "NO";
    	}
    	
    	// If only two frequencies and one of them appears only once - check the difference between - should be no more than 1 or actually equal 1. Otherwise return "NO"
    	int currFrequency = 0;
    	int currOccurrence = 0;
    	
        for (Map.Entry<Integer,Integer> freq : charCounts.entrySet()) {
        	
        		if (currFrequency != 0) {
        			if (Math.abs(currFrequency - freq.getKey()) == 1 && (currOccurrence==1 || freq.getValue() ==1)) {
        				return "YES";
        			}
        		}
        		
        		currFrequency=freq.getKey();
        		currOccurrence=freq.getValue();
        		if (currFrequency == 1 && currOccurrence == 1) {
        			return "YES";
        		}
        		
        }    	
    	
    	return "NO";
    }
    
}


