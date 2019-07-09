package com.hackerrank.interviewpreparationkit.sorting.MergeSortCountingInversions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

        long result = 0;

        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\sorting\\MergeSortCountingInversions\\data.txt");
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\sorting\\MergeSortCountingInversions\\result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];
            String line = scanner.nextLine();
            String[] arrItems = line.split(" ");
            
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            result = countInversions(arr);

            System.out.println(result);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }


        bufferedWriter.close();

        scanner.close();

        

    }
    
    
    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
    	long result=0;

    	mergeSort(arr);
    	printArray(arr);

    	return result;
    }
    
    // Merge Sort algorithm
    static void mergeSort(int[] arr) {
    	int n = arr.length;
    	int[] temp = new int[n];
    	
    	sortHalves(arr, temp, 0, n-1);
    }
    
    
    static void sortHalves(int[] arr, int[] temp, int start, int end) {
    	
    	if (start >= end) {
    		return;
    	}
    	
    	int middle = (start+end)/2;
    	sortHalves(arr, temp, start, middle);
    	sortHalves(arr, temp, middle+1, end);
    	mergeHalves(arr, temp, start, end);
    	
    }
    

    static void mergeHalves(int[] arr, int[] temp, int start, int end) {
    	
    	int leftStart = start;
    	int leftEnd = (start+end)/2;
    	int rightStart = leftEnd+1;
    	int rightEnd = end;
    	int index = start;
    	
    	int indexLeft = leftStart;
    	int indexRight = rightStart;
    	
    	while (indexLeft < leftEnd && indexRight < rightEnd) {
    		if (arr[indexLeft] < arr[indexRight]) {
    			temp[index] = arr[indexLeft];
    			index++;
    			indexLeft++;
    		} else {
    			temp[index] = arr[indexRight];
    			index++;
    			indexRight++;
    		}
    	}
    	
    	
    	System.arraycopy(arr, indexLeft, temp, index, end-index-1);
    	System.arraycopy(arr, indexRight, temp, index, end-index-1);
    	System.arraycopy(temp, start, arr, start, end-start);
    	
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


