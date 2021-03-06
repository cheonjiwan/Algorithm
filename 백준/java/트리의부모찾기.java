import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[] parent;
	static ArrayList<Integer>[] tree;
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		parent[1]=1;
		
		boolean[] visited = new boolean[n+1];
		Arrays.fill(visited, false);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int nextNode : tree[cur]) {
				if(!visited[nextNode]) {
					parent[nextNode]=cur;
					visited[nextNode]=true;
					q.offer(nextNode);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		tree = new ArrayList[n+1];
		for(int i=1; i<=n; i++)
			tree[i] = new ArrayList<>();
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a,b;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		
		bfs();
		for(int i=2; i<=n; i++)
			System.out.println(parent[i]);
	}

}
