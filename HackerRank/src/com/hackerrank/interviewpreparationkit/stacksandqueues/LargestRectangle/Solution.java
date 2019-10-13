package com.hackerrank.interviewpreparationkit.stacksandqueues.LargestRectangle;
// https://www.hackerrank.com/challenges/largest-rectangle/

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
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws IOException {

    	Instant programStart = Instant.now();
    	
        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\stacksandqueues\\LargestRectangle\\data.txt");
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\stacksandqueues\\LargestRectangle\\result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);
        System.out.println(result);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();

        Instant programEnd = Instant.now();
        Duration timeElapsed = Duration.between(programStart, programEnd);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

        
    }

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
    	//get the length of the array
    	int n = h.length;
    	// running max sum
    	long sum=0;
    	Stack<Integer> s = new Stack<>();
    	int i = 0;
    	int height = 0;
    	int width = 0;
    	
    	while (i<n) {
    		if (s.empty() || h[s.peek()] <= h[i]) {
    			s.push(i);
    			i++;
    		} else {
    			int index = s.pop();
    			height = h[index];
    			width = (s.empty() ? i : i - s.peek() - 1);
    			long tmp = height * width;
    			if (tmp > sum) {
    				sum = tmp;
    			}
    		}
    	}

    	while (!s.empty()) {
			int index = s.pop();
			height = h[index];
			width = (s.empty() ? i : i - s.peek() - 1);
			long tmp = height * width;
			if (tmp > sum) {
				sum = tmp;
			}
    	}
    	
    	
    	return sum;
    }

    
}


