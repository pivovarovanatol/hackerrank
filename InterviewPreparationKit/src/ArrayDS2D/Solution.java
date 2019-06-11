package ArrayDS2D;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

    	int max = -10000;
    	int tmp = 0;
    	int n = arr.length;
    	
    	for (int i = 1; i <n-1; i++) {
    		for (int j=1;j<n-1;j++) {
    			
    			tmp = arr[i][j] + arr[i-1][j] + arr[i+1][j] + arr[i-1][j-1] + arr[i+1][j+1] + arr[i-1][j+1] + arr[i+1][j-1]; 
    			if (tmp > max) {
    				max = tmp;
    			}
    		}
    	}
    	
    	return max;
    }

    
    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        File file_result = new File("C:\\Users\\AAP\\Desktop\\DEVL\\HackerRank\\Interview Preparation Kit\\src\\ArrayDS2D\\result.txt");
    	
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        File file = new File("C:\\Users\\AAP\\Desktop\\DEVL\\HackerRank\\Interview Preparation Kit\\src\\ArrayDS2D\\data.txt");
        Scanner scanner = new Scanner(file);
        
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
        System.out.println(result);
    }
}
