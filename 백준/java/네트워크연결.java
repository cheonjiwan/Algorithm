import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Edge> edges = new ArrayList<>();
	static int[] parent = new int[1001];
	
	public static int find_parent(int x) {
		if(x!=parent[x]) {
			parent[x]=find_parent(parent[x]);
		}
		return parent[x];
	}
	
	public static void union(int a,int b) {
		int x = find_parent(a);
		int y = find_parent(b);
		if(x<y)
			parent[y]=x;
		else
			parent[x]=y;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int a,b,cost;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			edges.add(new Edge(a,b,cost));
		}
		
		Collections.sort(edges);
		for(int i=1; i<=n; i++) {
			parent[i]=i;
		}
		
		int ans=0;
		for(int i=0,cnt=0; i<m; i++) {
			if(cnt==n-1)
				break;
			Edge tmp = edges.get(i);
			if(find_parent(tmp.a)!=find_parent(tmp.b)) {
				union(tmp.a,tmp.b);
				ans+=tmp.cost;
				cnt+=1;
			}
		}
		
		System.out.println(ans);
	}
	
	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int cost;
		
		public Edge(int a,int b, int cost) {
			this.a=a;
			this.b=b;
			this.cost=cost;
		}

		@Override
		public int compareTo(Main.Edge o) {
			// TODO Auto-generated method stub
			if(this.cost<o.cost) return -1;
			else if(this.cost==o.cost) return 0;
			else return 1;
		}
	}

}
