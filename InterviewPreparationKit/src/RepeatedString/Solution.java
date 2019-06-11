package RepeatedString;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    	
    	long result=0;
    	int l = s.length();
    	long reminder = n % l;
    	long even = (n - reminder) / l;
    	String part = s.substring(0, (int) reminder);
    	
    	result = (s.length() - s.replace("a", "").length()) * even + (part.length() - part.replace("a", "").length());
    	

    	return result;
    }
    
    
    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        File file_result = new File("C:\\Users\\AAP\\Desktop\\DEVL\\HackerRank\\Interview Preparation Kit\\src\\RepeatedString\\result.txt");
    	
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        File file = new File("C:\\Users\\AAP\\Desktop\\DEVL\\HackerRank\\Interview Preparation Kit\\src\\RepeatedString\\data.txt");
        Scanner scanner = new Scanner(file);
        
        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
        System.out.println(result);
    }
}
