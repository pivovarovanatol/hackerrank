package MinimumSwaps2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
    		int res = 0;
    		int tmp = 0;
    		int index = 0;
    		int n = arr.length;
    		//int arr1[] = new int[n];
    		
    		while (index < n) {
    			if (arr[index] == index+1) {
    				index++;
    			}
    			else
    			{
    				tmp = arr[arr[index]-1];
    				arr[arr[index]-1] = arr[index];
    				arr[index]=tmp;
    				res++;
    			}
    		}
    		
//    		System.out.println("Result array:");
//    		
//    		for (int i=0;i<n;i++) {
//    			System.out.print(arr[i]);
//    			System.out.print(" ");
//    		}
//    		System.out.println();
    		return res;
	    }

    
    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        File file_result = new File("C:\\Users\\AAP\\Desktop\\DEVL\\HackerRank\\Interview Preparation Kit\\src\\MinimumSwaps2\\result.txt");
    	
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        File file = new File("C:\\Users\\AAP\\Desktop\\DEVL\\HackerRank\\Interview Preparation Kit\\src\\MinimumSwaps2\\data.txt");
        Scanner scanner = new Scanner(file);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        
        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
        System.out.println(res);
    }
}
