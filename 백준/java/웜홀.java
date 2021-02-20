import java.io.*;
import java.util.*;

public class Main {

	static int n,m,w;
	static class Edge{
		int e,t;
		Edge(int e, int t){
			this.e = e;
			this.t = t;
		}
	}
	
	static ArrayList<Edge>[] road;
	
	public static boolean bellmanFord(int start) {
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start]=0;
		boolean check =false;
		
		for(int i=1; i<=n; i++) // v-1¹ø
		{
			check=false;
			for(int j=1; j<=n; j++) { // Relax
				for(Edge tmp : road[j]) {
					if(dist[j] != Integer.MAX_VALUE && dist[tmp.e] > dist[j] + tmp.t) {
						dist[tmp.e]= dist[j] + tmp.t;
						check=true;
					}
				}
			}
			if(!check)
				break;
		}
		
		if(check) {
			for(int i=1; i<=n; i++) {
				for(Edge tmp : road[i]) {
					if(dist[i]!=Integer.MAX_VALUE && dist[tmp.e] > dist[i] + tmp.t)
						return true;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T;
		T = Integer.parseInt(br.readLine());
		int s,e,t;
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			road = new ArrayList[n+1];
			for(int i=1; i<=n; i++) {
				road[i] = new ArrayList<>();
			}
			
			for(int i=0; i<m+w; i++) {
				st = new StringTokenizer(br.readLine());
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				t = Integer.parseInt(st.nextToken());
				if(i<m) {
					road[s].add(new Edge(e,t));
					road[e].add(new Edge(s,t));
				}
				else {
					road[s].add(new Edge(e,-t));
				}
			}
			
			boolean cycle = false;
			for(int i=1; i<=n; i++) {
				if(bellmanFord(i)) {
					System.out.println("YES");
					cycle=true;
					break;
				}
			}
			if(!cycle)
				System.out.println("NO");
		}
	}

}
