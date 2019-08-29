package com.hackerrank.interviewpreparationkit.StringManipulation.CommonChild;
// https://www.hackerrank.com/challenges/special-palindrome-again/

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
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

    	Instant programStart = Instant.now();
    	
        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\StringManipulation\\CommonChild\\data1.txt");
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\StringManipulation\\CommonChild\\result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();

        System.out.println(result);

        Instant programEnd = Instant.now();
        Duration timeElapsed = Duration.between(programStart, programEnd);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

        
    }
    

        // Complete the commonChild function below.
        static int commonChild(String s1, String s2) {
        	
        	char[] str1 = s1.toCharArray();
        	char[] str2 = s2.toCharArray();
        	int result = 0;

        	HashMap<String,Integer> hm = new HashMap<String,Integer>();
        	result = commonChildHelper(str1,str2, str1.length-1, str2.length-1, hm);
        	//System.out.println(result);
        	//result = commonChildHelper2(str1,str2, str1.length-1, str2.length-1, hm);

        	return result;
        }
        
        
        static int commonChildHelper(char[] str1, char[] str2, int index1, int index2, HashMap<String,Integer> hm) {
        	
        	if (hm.containsKey(index1 + " " + index2)) {
        		return hm.get(index1 + " " + index2);
        	}

        	
        	if (index1 < 0 || index2 < 0) {
        		hm.put(index1 + " " + index2, 0);
        		return 0;
        	}
        	int ret = 0;
        	
        	if (str1[index1] == str2[index2]) {
        		ret = 1 + commonChildHelper(str1, str2, index1-1, index2-1, hm);
        	} else {
        		int count1 = commonChildHelper(str1, str2, index1-1, index2, hm);
        		int count2 = commonChildHelper(str1, str2, index1, index2-1, hm);
        		
        		ret = count1 > count2 ? count1 : count2;
        	}
    		
    		hm.put(index1 + " " + index2, ret);
        	return ret;
        }        
        
        
        
    
}


