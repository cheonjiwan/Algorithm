import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left=0, right=0;
        for(int stone : stones)
        	right = Math.max(right, stone);
        
        while(left<=right) {
        	int cnt=0;
        	boolean flag=true;
        	int mid = (left+right)/2;
        	for(int stone : stones) {
        		if(stone-mid<0){
        			cnt++;
        			if(cnt>=k) {
        				flag = false;
        				break;
        			}
        		}
        		else cnt=0;
        	}
        	if(flag) {
        		left = mid+1;
        		answer = mid;
        	}
        	else
        		right = mid-1;
        }
        return answer;
    }
}

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		System.out.println(new Solution().solution(stones,k));		
	}
}
