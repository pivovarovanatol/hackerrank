package com.hackerrank.interviewpreparationkit.search.SwapNodesAlgo;

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
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws IOException {

    	Instant programStart = Instant.now();
    	
        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\search\\SwapNodesAlgo\\data2.txt");
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\search\\SwapNodesAlgo\\result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }
        
        bufferedWriter.close();
        scanner.close();

        Instant programEnd = Instant.now();
        Duration timeElapsed = Duration.between(programStart, programEnd);
        //System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

        
    }
    
    
    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {

    	Node root = createTree(indexes);
    	
    	//root.printInOrder();
		//System.out.println();
		//System.out.println();
		//System.out.println();

		
		int n = queries.length;
    	int[][] arr = new int[n][indexes.length];
		
		for (int i = 0; i<n;i++) {
			swapElements(root, queries[i]);
			
			//root.returnInOrder(root, arr[i], 0);
			

	        Stack<Node> s = new Stack<Node>(); 
	        Node curr = root; 
	        int index=0;
	        
	        // traverse the tree 
	        while (curr != null || s.size() > 0) 
	        { 
	  
	            /* Reach the left most Node of the curr Node */
	            while (curr !=  null) 
	            { 
	                /* place pointer to a tree node on 
	                   the stack before traversing 
	                  the node's left subtree */
	                s.push(curr); 
	                curr = curr.left; 
	            } 
	  
	            /* Current must be NULL at this point */
	            curr = s.pop(); 
	  
	            arr[i][index]=curr.key;
	            index++;
	            //System.out.print(curr.key + " "); 
	  
	            /* we have visited the node and its 
	               left subtree.  Now, it's right 
	               subtree's turn */
	            curr = curr.right; 
	        } 			
			
			
			//printArray(arr[i]);
	    	//root.printInOrder();
			//System.out.println();
		}
		
    	return arr;
    }

    static void printArray(int[] arr) {
    	
    	for (int i=0;i<arr.length;i++) {
    		System.out.print(arr[i] + " ");
    	}
    	
    	System.out.println();
    }
    
	public static void swapElements(Node root, int level) {
		if (root == null) {
			return;
		}

		int depth = root.level;
		Node tmp = null;

		if (root.level%level==0) {
			tmp = root.left;
			root.left = root.right;
			root.right = tmp;
		}
		
		swapElements(root.left, level);
		swapElements(root.right, level);
		
	}
	
    
    
    public static Node createTree(int[][] arr) {
    	Node root = null;    	
    	
    	int n = arr.length;
    	Node[] nodes = new Node[n];
    	
    	for (int i=0;i<n;i++) {
    		nodes[i] = new Node(i+1);
    	}
    	int depth;
    	
    	for (int i=0;i<n;i++) {
    		depth = (i+1)/2 + 1;
    		int left = arr[i][0];
    		int right = arr[i][1];
    		
    		if (left!=-1) {
    			nodes[i].left = nodes[left-1];
    		}
    		
    		if (right!=-1) {
    			nodes[i].right = nodes[right-1];
    		}
    		int key = nodes[i].key;
    		depth = nodes[i].depth(nodes[0], nodes[i].key, 0);
    		nodes[i].level = depth;
    		
    		//System.out.println(nodes[i].key + " depth is: " + nodes[i].depth(nodes[0], nodes[i].key, 0));
    	}

//    	for (int i=0;i<n;i++) {
//    		nodes[i].printNode();
//    	}
    	return nodes[0];
    }
    

}
    
    class Node {
    	
    	public int key;
    	public Node left;
    	public Node right;
    	public int level;
    	
    	public Node(int id) {
    		this.key = id;
    		left = null;
    		right = null;
    	}
    	
    	public Node(int key, Node left, Node right) {
    		this.key = key;
    		this.left = left;
    		this.right = right;
    	}
    	
    	public int depth(Node root, int key, int depth) {
    		
    		depth = getLevel(root, key);
    		
    		return depth;
    	}
    	
    	
        int getLevelUtil(Node node, int data, int level)  
        { 
            if (node == null) 
                return 0; 
       
            if (node.key == data) 
                return level; 
       
            int downlevel = getLevelUtil(node.left, data, level + 1); 
            if (downlevel != 0) 
                return downlevel; 
       
            downlevel = getLevelUtil(node.right, data, level + 1); 
            return downlevel; 
        } 
       
        /* Returns level of given data value */
        int getLevel(Node node, int data)  
        { 
            return getLevelUtil(node, data, 1); 
        } 
    	
    	
    	
    	public void printNode () {
    		System.out.println("Node key is: " + this.key);
    		System.out.println("Depth is: " + this.level);
    		if (this.left != null) {
        		System.out.println("Left child is: " + this.left.key);
    		} else {
        		System.out.println("Left child is: " + null);
    		}
    		
    		if (this.right != null) {
        		System.out.println("Right child is: " + this.right.key);
    		} else {
        		System.out.println("Rigth child is: " + null);
    		}
    	
    		System.out.println();
    	}
    	
    	
    	public void printInOrder() {
    		if (left != null) {
    			left.printInOrder();
    		}
    		System.out.print(key + " ");
    		if (right != null) {
    			right.printInOrder();
    		}
    	}

    	public int returnInOrder(Node root,int arr[], int index) {
    		if (root == null) {
    			return index;
    			}
    		
    		if (root.left != null) {
    			index = returnInOrder(root.left,arr, index);
    		}
    		arr[index]=root.key;
    		index++;
    		
    		if (root.right != null) {
    			index = returnInOrder(root.left,arr, index);
    		}

    		return index;
    		
    	}

    	
    
    }   
    
    
    
    
