import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[] indegree;
	static int[] times;
	static int[] result;
	
	static Queue<Integer> q = new LinkedList<>();
	static ArrayList<Integer>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		indegree = new int[n+1];
		times = new int[n+1];
		graph = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int time,before;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			time = Integer.parseInt(st.nextToken());
			times[i]=time;
			
			while(st.hasMoreTokens()) {
				before = Integer.parseInt(st.nextToken());
				if(before==-1)
					break;
				indegree[i]+=1;
				graph[before].add(i);
			}
		}
		
		result = new int[n+1];
		for(int i=1; i<=n ;i++) {
			result[i]=times[i];
			if(indegree[i]==0)
				q.offer(i);
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int nextNode : graph[now]) {
				result[nextNode] = Math.max(result[nextNode], result[now]+times[nextNode]);
				
				indegree[nextNode]--;
				if(indegree[nextNode]==0)
					q.add(nextNode);
			}
		}
		
		for(int i=1; i<=n; i++) {
			System.out.println(result[i]);
		}
	}

}
