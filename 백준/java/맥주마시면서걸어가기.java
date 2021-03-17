import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			
			ArrayList<Pos> list = new ArrayList<>();
			for(int i=0; i<n+2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				list.add(new Pos(x,y));
			}
			
			ArrayList<Integer>[] graph = new ArrayList[n+2];
			for(int i=0; i<n+2; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0; i<n+2; i++) {
				for(int j=i+1; j<n+2; j++) {
					if(Math.abs(list.get(i).x-list.get(j).x) + Math.abs(list.get(i).y-list.get(j).y)<=1000) {
						graph[i].add(j);
						graph[j].add(i);
					}
				}
			}
			
			if(bfs(graph, n))
				System.out.println("happy");
			else
				System.out.println("sad");

		}
	}
	
	private static boolean bfs(ArrayList<Integer>[] graph, int n) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		
		boolean[] visited = new boolean[n+2];
		visited[0] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur==n+1) {
				return true;
			}
			
			for(int next : graph[cur]) {
				if(!visited[next]) {
					visited[next] =true;
					q.offer(next);
				}
			}
		}
		return false;
	}
	
	static class Pos{
		int x,y;
		Pos(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	
}
