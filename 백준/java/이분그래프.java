import java.io.*;
import java.util.*;

public class Main {
	
	static int v,e;
	static int[] color;
	static ArrayList<Integer>[] graph;
	static Queue<Integer> q = new LinkedList<>();
	
	public static boolean bfs(int start) {
		q.offer(start);
		color[start]=1;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int tmp : graph[now]) {
				if(color[tmp]==0) {
					color[tmp]=-color[now];
					q.offer(tmp);
				}
				else if(color[tmp]==color[now])
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int k;
		k = Integer.parseInt(br.readLine());
		while(k-->0) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[v+1];
			for(int i=1; i<=v; i++) {
				graph[i] = new ArrayList<>();
			}
			
			int a,b;
			for(int i=0; i<e; i++)	
			{
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				graph[a].add(b); graph[b].add(a);
			}
			
			color = new int[v+1];
			boolean flag=true;
			for(int i=1; i<=v; i++) {
				if(color[i]==0)
				{
					if(!bfs(i)) {
						flag=false;
						break;
					}
				}
			}
			if(flag)
				System.out.println("YES");
			else
				System.out.println("NO");
			q.clear();
		}
	}
}
