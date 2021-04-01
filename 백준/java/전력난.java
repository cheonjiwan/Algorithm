import java.util.*;
import java.io.*;

public class Main
{	
	static int m,n;
	static int[] parent;
	static ArrayList<Edge> edge;
	
	public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            if(n==0 && m==0)
            	break;
            
            parent = new int[n];
            for(int i=0; i<n; i++) {
            	parent[i] = i;
            }
            
            edge = new ArrayList<>();
            int total=0;
            for(int i=0; i<m; i++) {
            	st = new StringTokenizer(br.readLine());
            	int a = Integer.parseInt(st.nextToken());
            	int b = Integer.parseInt(st.nextToken());
            	int cost = Integer.parseInt(st.nextToken());
            	total+=cost;
            	edge.add(new Edge(a,b,cost));
            }
            Collections.sort(edge);
            
            int result=0;
            int cnt=0;
            for(Edge cur : edge) {
            	if(cnt==n-1)
            		break;
            	int a,b,cost;
            	cost = cur.cost;
            	a = cur.a;
            	b = cur.b;
            	
            	if(find(a)!=find(b)) {
            		result+=cost;
            		union(a,b);
            		cnt++;
            	}
            }
            System.out.println(total-result);
        }
    }
	
	private static int find(int x) {
		if(x!=parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	
	private static void union(int a,int b) {
		int x = find(a);
		int y = find(b);
		if(x<y) parent[y]=x;
		else parent[x]=y;
	}
	
	
	static class Edge implements Comparable<Edge>{
		int a,b,cost;
		Edge(int a,int b, int cost){
			this.a=a;
			this.b=b;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(Main.Edge o) {
			return this.cost-o.cost;
		}
	}
	
	
}