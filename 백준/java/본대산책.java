import java.io.*;
import java.util.*;

public class Main {
    
	static int d;
	static int[][] dp;
	static int[][] graph = {
			{1,2},
			{0,3},
			{0,3,4},
			{1,2,4,5},
			{2,3,5,6},
			{3,4,6,7},
			{4,5,7},
			{5,6}
	};
	
	public static void solution() {
		for(int i=0; i<8; i++) {
			dp[1][i]=0;
			for(int j=0; j<graph[i].length; j++) {
				dp[1][i]=((dp[1][i]%1000000007)+dp[0][graph[i][j]%1000000007])%1000000007;
			}
		}
		
		for(int i=0; i<8; i++) {
			dp[0][i]=dp[1][i];
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		d = Integer.parseInt(br.readLine());
		dp = new int[2][8];
		dp[0][7]=1;
		for(int i=0; i<d; i++) {
			solution();
		}
		System.out.println(dp[0][7]);
	}
}