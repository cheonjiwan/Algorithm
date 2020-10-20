package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Temp implements Comparable<Temp>{
	int v;
	int cost;
	
	public Temp(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Temp o) {
		// TODO Auto-generated method stub
		if(this.cost < o.cost) return -1;
		else if(this.cost == o.cost) return 0;
		else return 1;
	}
}

public class Main {
	
	static int v;

	public static int[] dijkstra(ArrayList<Temp>[] graph, int start) {
		int[] dist = new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start]= 0;
		PriorityQueue<Temp> pq = new PriorityQueue<>();
		pq.add(new Temp(start,0));
		
		while(!pq.isEmpty()) {
			Temp tmp = pq.poll();
			int cost = tmp.cost;
			int now = tmp.v;
			
			if(dist[now] < cost) {
				continue;
			}
			
			for (Temp i : graph[now]) {
				int value = cost+i.cost;
				if(value < dist[i.v]) {
					dist[i.v]= value;
					pq.add(new Temp(i.v,value));
				}
			}
		}
		return dist;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		
		ArrayList<Temp>[] graph = new ArrayList[v+1];
		for (int i = 1; i <= v; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Temp(b,c));
		}
		
		int[] result = new int[v+1];
		result = dijkstra(graph,start);
		
		for(int i=1; i<=v; i++) {
			if(result[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else {
				System.out.println(result[i]);
			}
		}
	}

}
