import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n];
        dp[0] = 1; dp[1] = 2;
        for(int i=2; i<n; i++) {
        	dp[i] = (dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n-1];
    }
}

public class Main {
	public static void main(String[] args){
		
		Solution solution = new Solution();
		int n=4;
		System.out.println(solution.solution(n));
		
	}
}