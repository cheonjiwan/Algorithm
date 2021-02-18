import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static long[][] graph;
	
	public static void floyd_warshall() {
		for(int k=1; k<=n; k++)
		{
			for(int i=1; i<=n; i++)
			{
				for(int j=1; j<=n; j++) 
				{
					graph[i][j]=Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		int a,b,c;
		graph = new long[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j)
					graph[i][j]=0;
				else
					graph[i][j]=Integer.MAX_VALUE;
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(graph[a][b]>c)
				graph[a][b]=c;
		}
		
		floyd_warshall();
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n; j++) {
				if(graph[i][j]==Integer.MAX_VALUE)
					sb.append(0).append(' ');
				else
					sb.append(graph[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
