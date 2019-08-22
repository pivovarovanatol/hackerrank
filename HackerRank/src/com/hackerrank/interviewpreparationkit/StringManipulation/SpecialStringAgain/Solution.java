package com.hackerrank.interviewpreparationkit.StringManipulation.SpecialStringAgain;
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
    	
        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\StringManipulation\\SpecialStringAgain\\data1.txt");
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\StringManipulation\\SpecialStringAgain\\result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        String s = scanner.nextLine();

        long result = substrCount(n, s);

        System.out.println(result);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();


        Instant programEnd = Instant.now();
        Duration timeElapsed = Duration.between(programStart, programEnd);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");

        
    }
    

    static class Point {
        public char key;
        public long count;

        public Point(char x, long y) {
            key = x;
            count = y;
        }
    }

    
    
    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        long result = 0;
        char ch = '0';
        char oldCh = '0';
        long counter = 0;
        long oldCounter = 0;
        long leftCounter = 0;
        boolean special = false;
        for(char val : s.toCharArray()) {
            if (val == ch) {
            	++counter;
            	}
            else
            {
                if (special) {
                    result += counter < leftCounter ? counter : leftCounter;
                }
                special = counter == 1 && val == oldCh;
                if (special) {
                    leftCounter = oldCounter;
                }
                result += counter * (counter + 1) / 2;
                oldCh = ch;
                ch = val;
                oldCounter = counter;
                counter = 1;
            }
        };
        if (special)
            result += counter < leftCounter ? counter : leftCounter;
        result += counter * (counter + 1) / 2;
        return result;
    }
    
    
    // Complete the substrCount function below.
    static long substrCount3(int n, String s) {
        s = s + " ";
        ArrayList<Point> l = new ArrayList<Point>();
        long count = 1;
        char ch = s.charAt(0);
        for(int i = 1; i <= n ; i++) {
            if(ch == s.charAt(i))
                count++;
            else {
                l.add(new Point(ch, count));
                count = 1;
                ch = s.charAt(i);
            }
        }
        count = 0;
        if(l.size() >= 3) {   
            Iterator<Point> itr = l.iterator();
            Point prev, curr, next;
            curr = (Point)itr.next();
            next = (Point)itr.next();
            count = (curr.count * (curr.count + 1)) / 2;
            for(int i = 1; i < l.size() - 1; i++) {
                prev = curr;
                curr = next;
                next = itr.next();
                count += (curr.count * (curr.count + 1)) / 2;
                if(prev.key == next.key && curr.count == 1)
                    count += prev.count > next.count ? next.count : prev.count;
            }
            count += (next.count * (next.count + 1)) / 2;
        } else {
            for(Point curr:l){
                count += (curr.count * (curr.count + 1)) / 2;
            }
        }
        return count;
    }  
    

    
    // Complete the substrCount function below.
    static long substrCount2(int n, String s) {

    	char[] arr = s.toCharArray();
    	//System.out.println(isSpecial(arr,0,arr.length));
    	int count =0;
    	for (int i=0;i<n;i++) {
    		for (int j=i;j<n;j++) {
    			count +=isSpecial(arr,i,j);
    		}
    	}
    	
    	return count;
    }   
    
    
    static int isSpecial(char[] chrs, int start, int end) {
    	
    	if (end-start<1) {
			//System.out.println(chrs.toString() + ": " + start + " - " + end + " is special");
    		return 1;
    	}
    	
    	char tmp = chrs[start];
    	int n = end-start+1;
		int mid = n/2;
    	for (int i=0;i<n;i++) {
    		if (chrs[start+i]!=tmp) {
    			if (n%2==0) {
    				//System.out.println(chrs.toString() + ": " + start + " - " + end + " not special");
        			return 0;
    			}
    			if (i!=mid) {
    				//System.out.println(chrs.toString() + ": " + start + " - " + end + " not special");
        			return 0;
    			}
    		}
    	}
		//System.out.println(chrs.toString() + ": " + start + " - " + end + " is special");
    	return 1;
    } 
    
}


