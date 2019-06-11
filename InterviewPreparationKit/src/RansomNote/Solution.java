package RansomNote;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

    	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    	
    	for (int i = 0; i < magazine.length; i++) {
    		int count = hm.getOrDefault(magazine[i].hashCode(),0);

    		hm.put(magazine[i].hashCode(), ++count);
    	}

    	boolean canFind = true;
    	
    	for (int i=0;i<note.length;i++) {
        	String wordToFind = note[i];
        	int hashCodeToFind = wordToFind.hashCode();
        	
        	if (hm.containsKey(hashCodeToFind)) {
        		int count = hm.get(hashCodeToFind);
        		if (count <= 0) {
        			canFind = false;
        			break;
        		}
        		else {
        			count--;
        			hm.put(hashCodeToFind,count);
        		}
        		
        	}
        	else {
    			canFind = false;
    			break;
        	}
        	
    	}
    	
    	if (canFind) {
    		System.out.println("Yes");
    	}
    	else {
    		System.out.println("No");
    	}
    	
    }
    
    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        File file_result = new File("C:\\Users\\AAP\\Desktop\\DEVL\\HackerRank\\Interview Preparation Kit\\src\\RansomNote\\result.txt");
    	
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        File file = new File("C:\\Users\\AAP\\Desktop\\DEVL\\HackerRank\\Interview Preparation Kit\\src\\RansomNote\\data.txt");
        Scanner scanner = new Scanner(file);
        
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);


        
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
        //System.out.println(result);
    }
}
