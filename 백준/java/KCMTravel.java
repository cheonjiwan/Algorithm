import java.util.*;
import java.io.*;

public class Main {

	static int n,m,k;
	static int[][] distance;
	
	static class Data implements Comparable<Data>{
		int v,c,d;
		Data(int v,int c,int d){
			this.v=v;
			this.c=c;
			this.d=d;
		}
		@Override
		public int compareTo(Main.Data o) {
			return this.d-o.d;
		}	
	}
	
	static ArrayList<Data>[] graph;
	
	public static int dijkstra(){
		int start=1;
		PriorityQueue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(start,0,0));
		distance[start][0]=0;
		
		while(!pq.isEmpty()) {
			Data tmp = pq.poll();
			int now,money,dist;
			now = tmp.v;
			money = tmp.c;
			dist = tmp.d;
			
			if(now==n) 
				break;
			
			int nextNode,nextMoney,nextDist;
			for(Data cur : graph[now]) {
				nextNode = cur.v;
				nextMoney = money+cur.c;
				nextDist = dist+cur.d;
				if(nextMoney>m)
					continue;
				
				if(distance[nextNode][nextMoney]>nextDist)
				{
					for(int i=nextMoney; i<=m; i++) {
						distance[nextNode][i] = Math.min(distance[nextNode][i], nextDist);
					}
					pq.offer(new Data(nextNode,nextMoney,nextDist));
				}	
			}
		}
		int result=Integer.MAX_VALUE;
		for(int i=1; i<=m; i++) {
			result = Math.min(result, distance[n][i]);
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			distance=new int[n+1][m+1];
			graph = new ArrayList[n+1];
			for(int i=1; i<=n; i++)
			{
				graph[i] = new ArrayList<>();
				Arrays.fill(distance[i], 987654321);
			}
				
			int u,v,c,d;
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				graph[u].add(new Data(v,c,d));
			}
			
			int result=dijkstra();
			if(result==987654321)
				System.out.println("Poor KCM");
			else
				System.out.println(result);

		}
	}

}
