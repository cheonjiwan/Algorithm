import java.io.*;
import java.util.*;

public class Main {
	
	static int n,k;
	static int[] W,V;
	static int max=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		W = new int[n+1]; V = new int[n+1];
		int[][] dp = new int[n+1][k+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				if(W[i]<=j) {
					// 현재 수용가능한 가방의 무게 j
					// 물건을 가방에 넣고도 남는다면
					dp[i][j] = Math.max(dp[i-1][j], V[i] + dp[i-1][j-W[i]]);
				}
				else {
					// 현재 수용가능한 가방의 무게 j보다 크다면
					dp[i][j] = dp[i-1][j];
				}
					
				max = Math.max(dp[i][j], max);
			}
		}
		System.out.println(max);
	}
	
}