package com.hackerrank.interviewpreparationkit.stacksandqueues.balancedbrackets;
// https://www.hackerrank.com/challenges/balanced-brackets/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues

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
    	
        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\stacksandqueues\\balancedbrackets\\data.txt");
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\stacksandqueues\\balancedbrackets\\result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);
            System.out.println(result);


            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();

        Instant programEnd = Instant.now();
        Duration timeElapsed = Duration.between(programStart, programEnd);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

        
    }
    

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
    	
    	char[] arr = s.toCharArray();
    	Stack<Character> stack = new Stack<Character>(); 
    	
    	for (int i=0;i<arr.length;i++) {
    		
    		//check if character is opening bracket -> push to stack
    		if (arr[i]=='(' || arr[i]=='{' || arr[i]=='[') {
    			stack.push(arr[i]);
    		} else {
    			if (stack.size() == 0) {
    				return "NO";
    			}
    			char top = stack.peek();
    			
    			if (top=='(' && arr[i]==')') {
    				stack.pop();
    				continue;
    			}
    			if (top=='{' && arr[i]=='}') {
    				stack.pop();
    				continue;
    			}
    			if (top=='[' && arr[i]==']') {
    				stack.pop();
    				continue;
    			}
    			return "NO";
    		}
    	}
    	
    	if (stack.size() != 0) {
			return "NO";
    	} else {
        	return "YES";
    	}

    }

    
    
}


