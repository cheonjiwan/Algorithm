import java.io.*;
import java.util.*;

public class Main {
	
	static int n,start;
	static ArrayList<Integer>[] tree;
	static int[] parent;
	static int[] depth;
	static Queue<Integer> q;

	public static void bfs() {
		q = new LinkedList<>();
		q.offer(start);
		parent[start]=start;
		depth[start]=1;
		
		int now;
		while(!q.isEmpty()) {
			now = q.poll();
			for(int nextNode : tree[now]) {
				if(parent[nextNode]==0) {
					parent[nextNode]=now;
					depth[nextNode]=depth[now]+1;
					q.offer(nextNode);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			tree = new ArrayList[n+1];
			for(int i=1; i<=n; i++) {
				tree[i] = new ArrayList<>();
			}
			parent = new int[n+1];
			depth = new int[n+1];
			
			int[] indegree = new int[n+1];
			Arrays.fill(indegree, 0);
			
			for(int i=0; i<n-1; i++) {
				int a,b;
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				tree[a].add(b);
				indegree[b]++;
				tree[b].add(a);
			}
			
			for(int i=1; i<=n; i++) {
				if(indegree[i]==0)
					start=i;
			}
			
			int find1, find2;
			st = new StringTokenizer(br.readLine());
			find1 = Integer.parseInt(st.nextToken());
			find2 = Integer.parseInt(st.nextToken());
			bfs();
			
			int depA,depB;
			depA = depth[find1];
			depB = depth[find2];
			
			if(depA<=depB) {
				while(depA!=depB) {
					find2 = parent[find2];
					depB = depth[find2];
				}	
			}
			else if(depA>=depB) {
				while(depA!=depB) {
					find1 = parent[find1];
					depA = depth[find1];
				}	
			}
			
			while(parent[find1]!=parent[find2]) {
				find1 = parent[find1];
				find2 = parent[find2];
			}
			if(find1==find2)
				System.out.println(find1);
			else
				System.out.println(parent[find1]);
		}
	}

}
