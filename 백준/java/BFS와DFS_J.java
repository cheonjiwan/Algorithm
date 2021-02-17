package solve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void dfs(ArrayList<Integer>[] graph, boolean[] visited, int v) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for (Integer tmp : graph[v]) {
			if(!visited[tmp]) {
				dfs(graph,visited,tmp);
			}
		}
	}
	
	public static void bfs(ArrayList<Integer>[] graph, boolean[] visited, int v) {
		Queue<Integer> q = new LinkedList();
		q.add(v);
		visited[v] = true;
		int x;
		
		while(!q.isEmpty()) {
			x = q.poll();
			System.out.print(x+" ");
			for (Integer tmp : graph[x]) {
				if(!visited[tmp]) {
					q.add(tmp);
					visited[tmp] = true;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int a,b = 0;
		
		ArrayList<Integer>[] graph = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}
		br.close();
		
		boolean[] visited = new boolean[n+1];
		Arrays.fill(visited, false);
		dfs(graph,visited,v);
		System.out.println();
		visited = new boolean[n+1];
		Arrays.fill(visited, false);
		bfs(graph,visited,v);
		
	}

}
