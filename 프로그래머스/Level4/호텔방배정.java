import java.io.*;
import java.util.*;

class Solution {
	
	static HashMap<Long, Long> map = new HashMap<>();
	static long size;
    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        size = k;
        long[] answer = new long[n];
        
        for(int i=0; i<n; i++) {
        	answer[i] = find(room_number[i]);
        }
        
        return answer;
    }
    
    public long find(long num) {
    	 if (!map.containsKey(num)) {
             map.put(num, num + 1);
             return num;
         }
         
         long next = map.get(num);
         long empty = find(next);
         map.put(num, empty);
         return empty;
    }
}

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long k = 10;
		long[] room_number = {1,3,4,1,3,1};
		System.out.println(new Solution().solution(k,room_number));		
	}
}
