import java.io.*;
import java.util.*;

public class Main {
	
	static int n,r,q;
	static ArrayList<Integer>[] tree;
	static int[] dp;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		dp = new int[n+1];
		Arrays.fill(dp, 1);
		visited = new boolean[n+1];
		tree = new ArrayList[n+1];
		for(int i=1; i<=n; i++) tree[i] = new ArrayList<>();
		
		int u,v;
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}
		
		dfs(r);
		for(int i=0; i<q; i++) {
			System.out.println(dfs(Integer.parseInt(br.readLine())));
		}
	}
	
	private static int dfs(int cur) {
		if(visited[cur]) 
			return dp[cur];
		visited[cur]=true;
		
		for(int next : tree[cur]) {
			if(!visited[next])
				dp[cur] = dp[cur] + dfs(next);
		}
		return dp[cur];
		
	}
}