package com.hackerrank.interviewpreparationkit.sorting.MarkAndToys;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MarkAndToys {

	
	
	
    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
    	sort(prices);
    	//printArray(prices);
    	//sort2(prices);
    	for (int i=0;i<prices.length;i++) {
    		k -= prices[i];
    		
    		if (k < 0) {
    			return i;
    		}
    	}
    	return prices.length;
    }

    //private static final Scanner scanner = new Scanner(System.in);

    public static void makeHeap2(int[] arr, int i, int n) {
    	int smallest = i;
    	int left = i*2 +1;
    	int right = i*2 +2;
    	
    	if (left < n && arr[left] < arr[smallest]) {
        	smallest = left;
    	}
    	
    	if (right < n && arr[right] < arr[smallest]) {
        	smallest = right;
    	}
    	
    	if (smallest != i) {
    		int swap = arr[i];
    		arr[i] = arr[smallest];
    		arr[smallest] = swap;
    		
    		makeHeap2(arr, smallest, n);
    	}
    	
    }
    
    
    
    public static void sort2(int[] arr) {
    	
    	int n = arr.length;
    	
    	for (int i=n; i>=0;i--) {
        	makeHeap2(arr, i, n);
    	}

    	printArray(arr);

        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 

            printArray(arr);
  
            // call max heapify on the reduced heap 
            makeHeap2(arr, 0, i); 
            printArray(arr);
        }     	
    	
    	printArray(arr);
        
        
    }
    
    
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\sorting\\MarkAndToys\\data.txt");
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\sorting\\MarkAndToys\\result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        //printArray(prices);
        int result = maximumToys(prices, k);

        //System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }


    public static void sort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 
    } 


    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    static void heapify(int arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
    } 

    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 




}
