package com.hackerrank.interviewpreparationkit.stacksandqueues.MinMaxRiddle;
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
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws IOException {

    	Instant programStart = Instant.now();
    	
        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\stacksandqueues\\MinMaxRiddle\\data.txt");
        //File file = new File(Solution.class.getClassLoader().getResource("data.txt").getFile());
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\stacksandqueues\\MinMaxRiddle\\result.txt");
        //File file_result = new File(Solution.class.getClassLoader().getResource("result.txt").getFile());
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        long[] res = riddle(arr);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));
            System.out.print(res[i] + " ");
            if (i != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }
        
        System.out.println();
        
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();

        Instant programEnd = Instant.now();
        Duration timeElapsed = Duration.between(programStart, programEnd);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

        
    }

    // Complete the riddle function below.
    static long[] riddle(long[] arr) {
      int N = arr.length;
      long[] result = new long[N];
      long[] span = new long[N];

      ArrayDeque<Long> deckValues = new ArrayDeque<>();
      ArrayDeque<Long> deckIndexes = new ArrayDeque<>();
      deckIndexes.push(-1L);

      // count number of ge elements to the left
      for (int i = 0; i < N; i++) {
        while (!deckValues.isEmpty() && deckValues.peek() >= arr[i]) {
          deckValues.pop();
          deckIndexes.pop();
        }
        span[i] = i - deckIndexes.peek() - 1;
        deckValues.push(arr[i]);
        deckIndexes.push((long) i);
      }

      // count number of ge elements to the right
      deckValues.clear();
      deckIndexes.clear();
      deckIndexes.push((long) N);
      for (int i = N - 1; i >= 0; i--) {
        while (!deckValues.isEmpty() && deckValues.peek() >= arr[i]) {
          deckValues.pop();
          deckIndexes.pop();
        }
        span[i] += deckIndexes.peek() - i - 1;
        deckValues.push(arr[i]);
        deckIndexes.push((long) i);
      }

      // fill results
      for (int i = 0; i < N; i++) {
        result[(int) span[i]] = Math.max(result[(int) span[i]], arr[i]);
      }

      // fill the gaps
      for (int i = N - 2; i >= 0; i--) {
        result[i] = Math.max(result[i], result[i + 1]);
      }

      return result;
    }

    
    
    
    
    // Complete the riddle function below.
    static long[] riddle_good(long[] arr) {
        // complete this function
    	int n = arr.length;
    	long[] result = new long[n]; 
    	long[] res = new long[n];
    	long[] resVals = new long[n];
    	

    	for (int j=0;j<n;j++) {
        	Deque<Integer> q = new LinkedList<Integer>(); 
        	int windowSize = j+1;
        	long currMax = Long.MIN_VALUE;  
        	for (int i=0;i<n;i++) {
        		//analyzing first window -> getting the minimum
        		if (i<windowSize) {
        			while (!q.isEmpty() && arr[i] < arr[q.peekLast()]) {
        				q.removeLast();
        			}
        			q.addLast(i);
        		} else
        		//analyzing the rest of the array 
        		{
        			res[i-windowSize] = q.peekFirst();
        			resVals[i-windowSize] = arr[q.peekFirst()];
        			
        			if (arr[q.peekFirst()] > currMax) {
        				currMax = arr[q.peekFirst()]; 
        			}
        			
        			while (!q.isEmpty() && arr[i] < arr[q.peekLast()]) {
        				q.removeLast();
        			}
        			q.addLast(i);

        			while (!q.isEmpty() && q.peekFirst() <= i - windowSize) {
        				q.removeFirst();
        			}
        		}
        	}
        	
    		res[n-windowSize] = q.peekFirst();
    		resVals[n-windowSize] = arr[q.peekFirst()];
			if (arr[q.peekFirst()] > currMax) {
				currMax = arr[q.peekFirst()]; 
			}
			
			result[j] = currMax;
    	}
    	
    	return result;
    }    

    
    
}


