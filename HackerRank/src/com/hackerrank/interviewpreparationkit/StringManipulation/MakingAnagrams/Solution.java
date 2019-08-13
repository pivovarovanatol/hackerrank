package com.hackerrank.interviewpreparationkit.StringManipulation.MakingAnagrams;
// https://www.hackerrank.com/challenges/ctci-making-anagrams/

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
    	
        long result = 0;

        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\StringManipulation\\MakingAnagrams\\data.txt");
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\StringManipulation\\MakingAnagrams\\result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);
        System.out.println(res);
        
        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();
        scanner.close();

        Instant programEnd = Instant.now();
        Duration timeElapsed = Duration.between(programStart, programEnd);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

        
    }
    
    
    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
    		
    	char[] aa = a.toCharArray();
    	char[] bb = b.toCharArray();
    	int lenA = aa.length;
    	int lenB = bb.length;
    	int count=0;
    	
    	int[] arr1 = new int[28];
    	int[] arr2 = new int[28];
    	
    	for (int i=0;i<lenA;i++) {
    		arr1[aa[i]-97]++;
    	}
    	for (int i=0;i<lenB;i++) {
    		arr2[bb[i]-97]++;
    	}
    	
    	for (int i=0;i<28;i++) {
    		count += Math.abs(arr1[i]-arr2[i]);
    	}
    	
    	return count;
    }
    
}


