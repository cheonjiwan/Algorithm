import java.io.*;
import java.util.*;

public class Main {

	static int t;
	static int n,k,w;
	static ArrayList<Integer>[] graph;
	static int[] indegree;
	static int[] result;
	
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			n=Integer.parseInt(st.nextToken());
			k=Integer.parseInt(st.nextToken());
			
			int[] time = new int[n+1];
			int[] indegree = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				time[j]=Integer.parseInt(st.nextToken());
			}
			
			graph = new ArrayList[n+1];
			for(int j=1; j<=n; j++) {
				graph[j] = new ArrayList<>();
			}
			int before,after;
			for(int j=0; j<k; j++) {
				st = new StringTokenizer(br.readLine());
				before = Integer.parseInt(st.nextToken());
				after = Integer.parseInt(st.nextToken());
				graph[before].add(after);
				indegree[after]+=1;
			}
			
			q = new LinkedList<>();
			result = new int[n+1];
			for(int j=1; j<=n; j++) {
				result[j] = time[j];
				if(indegree[j]==0) {
					q.offer(j);
				}
			}
			
			while(!q.isEmpty()) {
				int now = q.poll();
				for(int nextNode : graph[now]) {
					result[nextNode] = Math.max(result[nextNode], result[now]+time[nextNode]);
					indegree[nextNode]--;
					if(indegree[nextNode]==0) {
						q.offer(nextNode);
					}
				}
			}
			
			w = Integer.parseInt(br.readLine());
			System.out.println(result[w]);
		}
	}

}
