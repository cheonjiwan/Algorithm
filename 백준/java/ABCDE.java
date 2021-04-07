import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static int[] parent;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	static boolean flag=false;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	graph = new ArrayList[n];
    	for(int i=0; i<n; i++) {
    		graph[i] = new ArrayList<>();
    	}
    	
    	for(int i=0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		graph[a].add(b);
    		graph[b].add(a);
    	}
    	
    	for(int i=0; i<n; i++) {
    		visited = new boolean[n];
    		solve(i,0);
    		if(flag) {
    			System.out.println(1);
    			System.exit(0);
    		}
    	}
    	System.out.println(0);    	
	}
	
	private static void solve(int start,int depth) {
		if(depth==4) {
			flag=true;
			return;
		}
		visited[start]=true;
		for(int next : graph[start]) {
			if(!visited[next]) {
				solve(next,depth+1);
			}
		}
		visited[start]=false;
	}
}