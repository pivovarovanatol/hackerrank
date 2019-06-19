package com.hackerrank.interviewpreparationkit.sorting.FraudulentActivityNotifications;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\sorting\\FraudulentActivityNotifications\r\n" + 
        		"\r\n" + 
        		"\\data.txt");
        Scanner scanner = new Scanner(file);
        
        File file_result = new File("C:\\Users\\i855719\\git\\hackerrank\\HackerRank\\src\\com\\hackerrank\\interviewpreparationkit\\sorting\\FraudulentActivityNotifications\r\n" + 
        		"\r\n" + 
        		"\\result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file_result));
        int n = scanner.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scanner.next(), scanner.nextInt());
        }
        scanner.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
        
    }
}


class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

	
class Checker implements Comparator<Player> {
	  	// complete this method
		public int compare(Player a, Player b) {
			
			String name1 = a.name;
			int score1 = a.score;
			String name2 = b.name;
			int score2 = b.score;
			
			if (score1 < score2) {
				return 1;
			}
			else {
				if (score1 == score2) {
					int len1 = name1.length();
					int len2 = name2.length();
					int n = 0;
					char[] cname1 = name1.toCharArray();
					char[] cname2 = name2.toCharArray();

					//System.out.println("Comparing: " + name1 + " vs " + name2);
					if (len1 < len2) {
						n = len1;
					}
					else {
						n = len2;
					}
					
					for (int i=0;i<n;i++) {
						if (cname1[i] < cname2[i]) {
							//System.out.println(name1 + " is smaller than " + name2);
							return -1;
						} 
						if (cname1[i] > cname2[i]) {
							//System.out.println(name1 + " is bigger than " + name2);
							return 1;
						} 
					}
					if (len1 < len2) {
						//System.out.println(name1 + " is smaller than " + name2);
						return -1;
						} else { 
						//System.out.println(name2 + " is smaller than " + name1);
						return 1;
						}
				}
				return -1;
			}
		}
		
};