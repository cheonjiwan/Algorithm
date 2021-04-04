import java.util.*;
import java.io.*;

public class Main
{	
	static int n,m;
	static int[] show;
	static ArrayList<Node>[] graph;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static long[] distance;
	
	public static void main(String args[]) throws IOException
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n];
		for(int i=0; i<n; i++) {
			graph[i] = new ArrayList<>();
		}
		show = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			show[i] = Integer.parseInt(st.nextToken());
		}
		show[n-1]=0;
		
		int a,b;
		long c;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Long.parseLong(st.nextToken());
			if(show[a]==1 || show[b]==1) {
				continue;
			}
			graph[a].add(new Node(b,c));
			graph[b].add(new Node(a,c));
		}
		dijkstra(0);
		if(distance[n-1]==Long.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(distance[n-1]);
    }
	
	private static void dijkstra(int start) {
		distance = new long[n];
		Arrays.fill(distance, Long.MAX_VALUE);
		distance[start]=0;
		pq.offer(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			long dist;
			int now;
			dist = cur.cost;
			now = cur.cur;
			
			if(dist>distance[now])
				continue;
			
			for(Node next : graph[now]) {
				long cost = dist + next.cost;
				if(cost < distance[next.cur]) {
					distance[next.cur]=cost;
					pq.offer(new Node(next.cur,cost));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int cur;
		long cost;
		Node(int cur, long cost){
			this.cur = cur;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Main.Node o) {
			return (int)(this.cost - o.cost);
		}
	}
}