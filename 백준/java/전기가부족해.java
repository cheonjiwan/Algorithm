import java.io.*;
import java.util.*;

class Data implements Comparable<Data>{
	int a,b,cost;
	Data(int a,int b, int cost){
		this.a=a;
		this.b=b;
		this.cost=cost;
	}
	
	@Override
	public int compareTo(Data o) {
		return this.cost-o.cost;
	}
}

class Main {
	
	static int n,m,k;
	static boolean[] before;
	static int[] parent;
	static ArrayList<Data> edges = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		before = new boolean[n+1];
		parent = new int[n+1];
		for(int i=1; i<=n; i++) parent[i] = i;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			int num = Integer.parseInt(st.nextToken());
			parent[num] = -1;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges.add(new Data(a,b,c));
		}
		Collections.sort(edges);
		int cnt=0;
		int ans=0;
		for(Data edge : edges) {
			int a = edge.a;
			int b = edge.b;
			int cost = edge.cost;
			if(find(a) != find(b)) {
				ans+=cost;
				union(a,b);
				if(check())
					break;
			}
		}
		System.out.println(ans);
	}
	
	public static boolean check() {
		for(int i=1; i<=n; i++) {
			if(parent[i]!=-1)
				return false;
		}
		return true;
	}
	
	public static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x<y) parent[y] = x;
		else parent[x] = y;
	}
	
	public static int find(int x) {
		if(parent[x]==-1)
			return -1;
		if(x!=parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
}