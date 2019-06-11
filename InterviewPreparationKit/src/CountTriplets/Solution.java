package CountTriplets;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
	
    // Complete the countTriplets function below.
    static long countTripletsOld(List<Long> arr, long r) {
    	long result=0;
    	int size = arr.size();
    	int i = 0;
    	long[] a = new long[size];
   
    	for (long e : arr) {
    		long count = 0;
    		long tmp = 0;
    		
    		if ((e > 1) && (e < r)) {
    			i++;
    			break;
    		}
    		if (e == 1) {
    			a[i]=0;
    		}
    		else
    		{
    			if (e == r) {
    				a[i]=1;
    				i++;
    				continue;
    			}
    			tmp = e;
    			do {
    				count++;
    				tmp = tmp/r;
    				if (tmp < 1) {
    					a[i]=-1;
    					break;
    				}
    				else {
    					if (tmp == 1) {
    						a[i]=count;
    						break;
    					}
    				}
    			}
    			while (true);
    		}
    		i++;
    	}
    	
    	for (int j=1; j<size-1;j++) {
    		if (a[j]<1) {
    			continue;
    		}
    		long bellow = 0;
    		long above = 0;
    		for (int k = 0; k < j; k++) {
    			if (a[k] == a[j]-1) {bellow++;}
    		}

    		for (int k = j+1; k < size; k++) {
    			if (a[k] == a[j]+1) {above++;}
    		}
        	result += bellow * above;
    	}
    	
    	return result;
    }
	


    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
    	Map<Long, Long> t2 = new HashMap<>();
    	Map<Long, Long> t3 = new HashMap<>();
    	long result = 0L;
            
    	for(Long a : arr) {
    		result += t3.getOrDefault(a, 0L);
    		if (t2.containsKey(a)){
    			t3.put(a*r, t3.getOrDefault(a*r, 0L) + t2.get(a));
    		}
    		t2.put(a*r, t2.getOrDefault(a*r, 0L) + 1);
    	}
    	return result;
    }

    
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\AAP\\Desktop\\DEVL\\HackerRank\\Interview Preparation Kit\\src\\CountTriplets\\data.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\AAP\\Desktop\\DEVL\\HackerRank\\Interview Preparation Kit\\src\\CountTriplets\\result.txt"));

        //String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");


        File file = new File("C:\\Users\\AAP\\Desktop\\DEVL\\HackerRank\\Interview Preparation Kit\\src\\CountTriplets\\data.txt");
        Scanner scanner = new Scanner(file);
        
        String[] nm = scanner.nextLine().split(" ");

        long n = Integer.parseInt(nm[0]);
        long r = Long.parseLong(nm[1]);
        List<Long> arr = new ArrayList();
        
        String[] str = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int j = 0; j < n; j++) {
            long item = Integer.parseInt(str[j]);
            System.out.println(item);
            arr.add(item);
        }
        
        
        long ans = countTriplets(arr, r);

        System.out.println(ans);
        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        
        //bufferedReader.close();
        bufferedWriter.close();
        scanner.close();
    }
}
