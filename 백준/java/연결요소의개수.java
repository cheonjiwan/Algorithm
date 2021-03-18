import java.io.*;
import java.util.*;
import java.util.*;
class Main {

	static int n,m;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		int result=0;
		visited = new boolean[n+1];
		for(int i=1; i<=n; i++) {
			if(!visited[i])
				result+=bfs(i);
		}
		System.out.println(result);
	}
	
	private static int bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start]=true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : graph[cur]) {
				if(!visited[next]) {
					q.offer(next);
					visited[next]=true;
				}
			}
		}
		
		return 1;
	}
}