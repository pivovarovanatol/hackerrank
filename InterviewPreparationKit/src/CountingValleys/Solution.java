package CountingValleys;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

    	int currentLevel = 0;
    	int previousLevel = 0;
    	boolean initial = true;
    	int count = 0;
    	
    	for (char ch: s.toCharArray()) {
    		
    		if (ch == 'U') {
    			previousLevel = currentLevel;
    			currentLevel++;
    		}
    		else {
    			previousLevel = currentLevel;
    			currentLevel--;
    		}
    			
    		if ((currentLevel == 0) && (previousLevel < 0 ) && (!initial)) {
    			count++;
    		}
    		initial = false;
    	}
    	
    	return count;
    }


    
    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        File file_result = new File("C:\\Users\\AAP\\Desktop\\DEVL\\HackerRank\\Interview Preparation Kit\\src\\CountingValleys\\result.txt");
    	
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        File file = new File("C:\\Users\\AAP\\Desktop\\DEVL\\HackerRank\\Interview Preparation Kit\\src\\CountingValleys\\data.txt");
        Scanner scanner = new Scanner(file);
        
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
        System.out.println(result);
    }
}
