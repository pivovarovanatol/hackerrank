package com.hackerrank.interviewpreparationkit.sorting.MergeSortCountingInversions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

        long result = 0;

        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\sorting\\MergeSortCountingInversions\\data1.txt");
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
    static long countInversions2(int[] arr) {
    	long result=0;
    	int n = arr.length;

    	if (isSorted(arr)) return 0;

    	//System.out.println(isReverseSorted(arr));
    	if (isReverseSorted(arr)) return ((n-1)*n);
    	
    	//printArray(arr);
    	result = mergeSort(arr);
    	//printArray(arr);
    	
    	return result;
    }
    
    // Merge Sort algorithm
    static long mergeSort(int[] arr) {
    	int n = arr.length;
    	int[] temp = new int[n];
    	long result=0;
    	int middle = n/2;
    	
    	result = sortHalves(arr, temp, 0, n-1);
    	return result;
    }
    
    
    static long sortHalves(int[] arr, int[] temp, int start, int end) {
    	long a =0;
    	long result=0;
    	if (start >= end) {
    		return 0;
    	}
    	
    	int middle = (start+end)/2;
    	result += sortHalves(arr, temp, start, middle);
    	result += sortHalves(arr, temp, middle+1, end);
    	result +=mergeHalves(arr, temp, start, end);
    	return result;
    }
    

    static int mergeHalves(int[] arr, int[] temp, int start, int end) {
    	
    	int leftStart = start;
    	int leftEnd = (start+end)/2;
    	int rightStart = leftEnd+1;
    	int rightEnd = end;
    	int index = start;
    	int count = 0;
    	
    	int indexLeft = leftStart;
    	int indexRight = rightStart;
    	
    	while (indexLeft <= leftEnd && indexRight <= rightEnd) {
    		if (arr[indexLeft] <= arr[indexRight]) {
    			temp[index] = arr[indexLeft];
    			index++;
    			indexLeft++;
    		} else {
    			temp[index] = arr[indexRight];
    			count += (indexRight-index);
    			index++;
    			indexRight++;
    		}
    	}
    	
    	for (int i=indexLeft;i<=leftEnd;i++) {
    		temp[index]=arr[i];
    		index++;
    	}
    	
    	for (int i=indexRight;i<=rightEnd;i++) { 
    		temp[index]=arr[i];
    		index++;
    	}
    	
    	for (int i=0;i<=end;i++) {
    		arr[i]=temp[i];
    	}
    	
    	//System.arraycopy(arr, indexLeft, temp, index, end-index-1);
    	//System.arraycopy(arr, indexRight, temp, index, end-index-1);
    	//System.arraycopy(temp, start, arr, start, end-start);
    	
    	return count;
    }
    
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 

    static boolean isSorted(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n-1; i++)
        	if (arr[i]>arr[i+1]) return false;
        return true;
    } 

    static boolean isReverseSorted(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n-1; i++)
        	if (arr[i]<arr[i+1]) return false;
        return true;
    } 



    
    
    
    
    
    
    
    private static long countInversions(int[] arr, int lo, int hi, int[] aux) {
        if (lo >= hi) return 0;

        int mid = lo + (hi - lo) / 2;

        long count = 0;
        count += countInversions(aux, lo, mid, arr);
        count += countInversions(aux, mid + 1, hi, arr);
        count += merge(arr, lo, mid, hi, aux);

        return count;
    }

    private static long merge(int[] arr, int lo, int mid, int hi, int[] aux) {
        long count = 0;
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid || j <= hi) {
            if (i > mid) {
                arr[k++] = aux[j++];
            } else if (j > hi) {
                arr[k++] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = aux[j++];
                count += mid + 1 - i;
            }
        }

        return count;
    }

    
    private static long countInversions(int[] arr) {
        int[] aux = arr.clone();
        return countInversions(arr, 0, arr.length - 1, aux);
    }    
    
    
    
    
}


