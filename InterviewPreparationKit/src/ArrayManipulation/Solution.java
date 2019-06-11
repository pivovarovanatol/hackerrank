package ArrayManipulation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation_old(int n, int[][] queries) {
    	long res = 0;
    	int len = queries.length;
    	long arr[] = new long[n];
    	
    	for (int i=0; i<len; i++) {
    		for (int j = queries[i][0]-1; j<=queries[i][1]-1;j++) {
    			arr[j] += queries[i][2];

    		}
    	}
    	
    	for (int i=0;i<n;i++) {
			if (arr[i] > res) {
				res = arr[i];
			}
    	}
    	
    	return res;
    }

	
	
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
    	        
    	//This will be the "difference array". The entry arr[i]=k indicates that arr[i] is exactly k units larger than arr[i-1]
    	long[] arr = new long[n];
    	int m = queries.length;        
    	
    	int lower;
    	int upper;
    	long sum;

    	for(int i=0;i<n;i++) arr[i]=0;

    	for(int i=0;i<m;i++){
    	    lower=queries[i][0];
    	    upper=queries[i][1];
    	    sum=queries[i][2];
    	    
    	    arr[lower-1]+=sum;
    	    if(upper<n) arr[upper]-=sum; 
    	}
    	        
    	long max=0;
    	long temp=0;
    	
    	for(int i=0;i<n;i++){
    	    temp += arr[i];
    	    if(temp > max) max=temp;
    	}

    	return max;
    }

    
    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        File file_result = new File("C:\\Users\\AAP\\Desktop\\DEVL\\HackerRank\\Interview Preparation Kit\\src\\ArrayManipulation\\result.txt");
    	
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        File file = new File("C:\\Users\\AAP\\Desktop\\DEVL\\HackerRank\\Interview Preparation Kit\\src\\ArrayManipulation\\data.txt");
        Scanner scanner = new Scanner(file);
        
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
        System.out.println(result);
    }
}
