import java.io.*;
import java.util.*;

public class Main {
	
	static int t;
	static int n,d,c;
	static int cnt;
	static int maxValue = 0;
	
	static PriorityQueue<Data> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			ArrayList<Data>[] graph = graph = new ArrayList[n+1];
			for(int i=1; i<=n; i++) graph[i] = new ArrayList<>();
			int a,b,s;
			
			for(int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				s = Integer.parseInt(st.nextToken());
				
				graph[b].add(new Data(a,s));
			}
			
			int[] result = dijkstra(graph,c);
			cnt=0;
			maxValue=0;
			for(int i=1; i<=n; i++) {
				if(result[i]!=Integer.MAX_VALUE) {
					cnt++;
					maxValue = Math.max(maxValue, result[i]);
				}
			}
			System.out.println(cnt+" "+maxValue);
		}
	}
	
	private static int[] dijkstra(ArrayList<Data>[] graph,int start) {
		int[] distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start]=0;
		
		pq.clear();
		pq.offer(new Data(start,0));
		
		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			int dist = cur.s;
			int now = cur.b;
			
			if(distance[now]<dist)
				continue;
			
			for(Data next : graph[now]) {
				int cost = dist + next.s;
				if(distance[next.b] > cost) {
					distance[next.b]= cost;
					pq.offer(new Data(next.b,cost));
				}
			}
		}
		
		return distance;
	}
	
	static class Data implements Comparable<Data>{
		int b,s;
		Data(int b, int s){
			this.b=b;
			this.s=s;
		}
		
		@Override
		public int compareTo(Main.Data o) {
			return this.s-o.s;
		}
	}
	
}