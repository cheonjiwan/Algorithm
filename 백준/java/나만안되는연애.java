import java.io.*;
import java.util.*;

public class Main {
    
	static int n,m;
	static String[] sex;
	static int[] parent;
	static class Edge implements Comparable<Edge>{
		int u,v,d;
		Edge(int u,int v,int d){
			this.u=u;
			this.v=v;
			this.d=d;
		}
		@Override
		public int compareTo(Main.Edge o) {
			// TODO Auto-generated method stub
			return this.d-o.d;
		}
	}
	public static int find_parent(int x) {
		if(x!=parent[x]){
			parent[x] = find_parent(parent[x]);
		}
		return parent[x];
	}
	
	public static void union(int a, int b) {
		int x = find_parent(a);
		int y = find_parent(b);
		
		if(x<y)
			parent[y]=x;
		else
			parent[x]=y;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		for(int i=1; i<=n; i++)
			parent[i] = i;
		
		st = new StringTokenizer(br.readLine());
		sex = new String[n+1];
		for(int i=1; i<=n; i++) {
			sex[i] = st.nextToken();
		}
		
		int u,v,d;
		Edge[] edges = new Edge[m];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(u,v,d);
		}
		
		Arrays.sort(edges,(a,b)-> a.d-b.d);
		int cnt=0,cost=0;
		for(Edge cur : edges) {
			if(cnt==n-1) {
				break;
			}
			if(!sex[cur.u].equals(sex[cur.v]) && find_parent(cur.u) != find_parent(cur.v)) {
				union(cur.u,cur.v);
				cost+=cur.d;
				cnt++;
			}	
		}
		if(cnt==n-1)
			System.out.println(cost);
		else
			System.out.println(-1);
	}
}