import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static ArrayList<Integer>[] tree;
	static Queue<Integer> q;
	static int[] parent;
	static int[] depth;
	
	public static void bfs() {
		int start=1;
		parent[start]=1;
		depth[start]=1;
		
		q = new LinkedList<>();
		q.offer(start);
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
	
	public static int find(int a,int b) {
		int depA,depB;
		depA=depth[a];
		depB=depth[b];
		if(depA<depB) {
			while(depA!=depB) {
				b=parent[b];
				depB=depth[b];
			}
		}
		else {
			while(depB!=depA) {
				a=parent[a];
				depA=depth[a];
			}
		}
		
		while(parent[a]!=parent[b]) {
			a=parent[a];
			b=parent[b];
		}
		if(a==b)
			return a;
		else
			return parent[a];
	
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n=Integer.parseInt(br.readLine());
		tree = new ArrayList[n+1];
		for (int i = 1; i < tree.length; i++) {
			tree[i] = new ArrayList<>();
		}
		
		parent = new int[n+1];
		depth = new int[n+1];
		
		int a,b;
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		bfs();
		
		m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			System.out.println(find(a,b));
		}
		
	}

}
