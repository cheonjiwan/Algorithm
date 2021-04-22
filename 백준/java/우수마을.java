import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[] people;
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		dp = new int[2][n+1];
		visited = new boolean[n+1];
		people = new int[n+1];
		tree = new ArrayList[n+1];
		for(int i=1; i<=n; i++) 
			tree[i] = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) 
			people[i] = Integer.parseInt(st.nextToken());
		
		int u,v;
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			tree[u].add(v);
			tree[v].add(u);
		}
		
		dfs(1);
		System.out.println(Math.max(dp[0][1], dp[1][1]));
	}
	
	private static void dfs(int cur) {
		if(visited[cur])
			return;
		
		visited[cur] = true;
		dp[0][cur] = 0;
		dp[1][cur] = people[cur];
		
		for(int next : tree[cur]) {
			if(!visited[next]) {
				dfs(next);
				
				dp[0][cur] += Math.max(dp[0][next], dp[1][next]);
				dp[1][cur] += dp[0][next];
			}
		}
		
	}
}