package com.hackerrank.interviewpreparationkit.search.MaximumSubarraySum;
// https://www.hackerrank.com/challenges/maximum-subarray-sum/problem

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
    	
        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\search\\MaximumSubarraySum\\data.txt");
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\search\\MaximumSubarraySum\\result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);
            System.out.println(result);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();

        Instant programEnd = Instant.now();
        Duration timeElapsed = Duration.between(programStart, programEnd);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
        
    }
    
    

    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {
    	long result = 0;
    	int n = a.length;

        long[] s = new long[a.length];
        TreeSet<Long> tree = new TreeSet<>();

        s[0] = a[0] % m;
        tree.add(s[0]);
        result = s[0];

        for (int i = 1; i < n; i++) {

            s[i] = (s[i - 1] + a[i]) % m;

            // find least element in the tree strictly greater than s[i]
            Long v = tree.higher(s[i]);

            if (v == null) {
                // can't find v, then compare v and s[i]
                result = Math.max(s[i], result);
            } else {
                result = Math.max((s[i] - v + m) % m, result);
            }
            tree.add(s[i]);
        }
    	
    	//printArray(a);
    	return result;
    }    
    
    
    
    static void printArray(long[] arr) {
    	for (int i=0;i<arr.length;i++) {
    		System.out.print(arr[i] + " ");
    	}
    	System.out.println();
    }
}


