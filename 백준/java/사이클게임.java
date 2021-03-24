import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	parent = new int[n];
    	for(int i=0; i<n; i++) {
    		parent[i]=i;
    	}
    	
    	ArrayList<Edge> list = new ArrayList<>();
    	int a,b;
    	for(int i=0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
    		a = Integer.parseInt(st.nextToken());
    		b = Integer.parseInt(st.nextToken());
    		list.add(new Edge(a,b));
    	}
    	
    	int cnt=1;
    	boolean flag=false;
    	for(Edge cur : list) {
    		if(find(cur.a)!=find(cur.b)) {
    			union(cur.a,cur.b);
    			cnt++;
    		}
    		else {
    			flag=true;
    			System.out.println(cnt);
    			break;
    		}
    	}
    	if(!flag) {
    		System.out.println(0);
    	}    	
    }
	
	private static int find(int x) {
		if(x!=parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	private static void union(int a, int b) {
		int x,y;
		x = find(a);
		y = find(b);
		
		if(x<y) parent[y] = x;
		else parent[x]=y;
	}
	
	static class Edge{
		int a,b;
		Edge(int a, int b){
			this.a=a;
			this.b=b;
		}
	}
	
}