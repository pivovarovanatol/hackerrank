package com.hackerrank.interviewpreparationkit.stacksandqueues.CastleOnTheGrid;
// https://www.hackerrank.com/challenges/castle-on-the-grid/

import java.awt.List;
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
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws IOException {

    	Instant programStart = Instant.now();
    	
        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\stacksandqueues\\CastleOnTheGrid\\data.txt");
        //File file = new File(Solution.class.getClassLoader().getResource("data.txt").getFile());
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\stacksandqueues\\CastleOnTheGrid\\result.txt");
        //File file_result = new File(Solution.class.getClassLoader().getResource("result.txt").getFile());
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        System.out.println(result);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();


        Instant programEnd = Instant.now();
        Duration timeElapsed = Duration.between(programStart, programEnd);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

        
    }

    // Complete the minimumMoves function below.
    // Let's try recursive solution
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
    	
    	int n = grid.length;
    	//boolean[][] visited = new boolean[n][n];
    	char[][] arr = new char[n][n];
    	Queue<Node> elements = new LinkedList<Node>();
    	HashMap<Node,Boolean> visited = new HashMap<Node, Boolean>();
    	// convert grid to char matrix
    	for (int i=0;i<n;i++) {
    		char[] tmp = grid[i].toCharArray();
    		for (int j=0;j<n;j++) {
    			arr[i][j] = tmp[j];
    		}
    	}
    	
    	Node start = new Node(startX,startY,0);
    	elements.add(start);
    	
    	while (1==1) {
    		if (elements.isEmpty()) {
    			break;
    		}
    		
    		Node node = elements.poll();
    		visited.put(node, true);
    		// Check if we found the goal node. If yes -> return the distance!
    		if (node.x == goalX && node.y == goalY) {
    			return node.dist;
    		}	

    		Node next1 = new Node(node.x+1, node.y, node.dist+1);
    		if (isValid(next1, n, arr, visited)) {
    			elements.add(next1);
    		}

    		Node next2 = new Node(node.x, node.y+1, node.dist+1);
    		if (isValid(next2, n, arr, visited)) {
    			elements.add(next2);
    		}
    		
    		Node next3 = new Node(node.x-1, node.y, node.dist+1);
    		if (isValid(next3, n, arr, visited)) {
    			elements.add(next3);
    		}

    		Node next4 = new Node(node.x, node.y-1, node.dist+1);
    		if (isValid(next4, n, arr, visited)) {
    			elements.add(next4);
    		}
    	
    	
    	}
    	
    	return 0;
    }

    static class Node {
    	public int x;
    	public int y;
    	public int dist;
    	public char direction;
    	
    	Node (int x, int y, int dist) {
    		this.x = x;
    		this.y = y;
    		this.dist = dist;
    	}
    }


    
    static boolean isValid(Node node, int n, char[][] arr, HashMap<Node,Boolean> visited) {
    	
    	if (node == null) {
    		return false;
    	}
    	
    	if (visited.containsKey(node)) {
    		return false;
    	}
    		
    	if (node.x < 0 || node.x >= n || node.y < 0 || node.y >= n || arr[node.x][node.y] == 'X') {
    		return false;
    	} else {
    		return true;
    	}
    }
    
}

