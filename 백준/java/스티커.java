import java.util.*;
import java.io.*;

public class Main {

	static int t,n;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t=Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			n=Integer.parseInt(br.readLine());
			int[][] data = new int[2][n+1];
			int[][] dp = new int[2][n+1];
			
			for(int row=0; row<2; row++)
			{
				st = new StringTokenizer(br.readLine());
				for(int col=1; col<=n; col++) {
					data[row][col]=Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][0]=dp[1][0]=0;
			dp[0][1]=data[0][1];
			dp[1][1]=data[1][1];
			
			for(int x=2; x<=n; x++)
			{
				dp[0][x] = Math.max(dp[1][x-1], dp[1][x-2])+data[0][x];
				dp[1][x] = Math.max(dp[0][x-1], dp[0][x-2])+data[1][x];
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
		
	}

}
