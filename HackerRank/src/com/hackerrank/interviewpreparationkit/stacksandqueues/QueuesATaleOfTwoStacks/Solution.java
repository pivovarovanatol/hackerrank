package com.hackerrank.interviewpreparationkit.stacksandqueues.QueuesATaleOfTwoStacks;
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
    	
        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\stacksandqueues\\QueuesATaleOfTwoStacks\\data.txt");
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\stacksandqueues\\QueuesATaleOfTwoStacks\\result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        int n = scanner.nextInt();
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
        for (int i = 0; i < n; i++) {
            int operation = scanner.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scanner.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        bufferedWriter.close();

        scanner.close();

        Instant programEnd = Instant.now();
        Duration timeElapsed = Duration.between(programStart, programEnd);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

        
    }
    

	static class MyQueue<T> {
    	
		private Stack<T> head;
		private Stack<T> tail;
    	
    	public MyQueue() {
    		head = new Stack<T>();
    		tail = new Stack<T>();
    	}
    	
    	public void enqueue(T value) {
    		tail.add(value);
    	}
    	
    	public T dequeue() {
    		// if head is empty - move all from tail to head. Else - pop from the head
    		if (head.isEmpty()) {
    			while (!tail.isEmpty()) {
    				head.push(tail.pop());
    			}
    		}
    		return head.pop();
    	}
    	
    	public T peek() {
    		// if head is empty - move all from tail to head. Else - pop from the head
    		if (head.isEmpty()) {
    			while (!tail.isEmpty()) {
    				head.push(tail.pop());
    			}
    		}
    		return head.peek();
    	}
    	
    }
    
}


