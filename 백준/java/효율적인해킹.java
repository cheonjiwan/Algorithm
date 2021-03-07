import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static ArrayList<Integer> tree[];
	public static int bfs(int start) {
		boolean[] visited = new boolean[n+1];
		Arrays.fill(visited, false);
		
		int cnt=0;
		Queue<Integer> q = new LinkedList<>();
		q.offer(start); visited[start]=true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int nextNode : tree[cur])
			{
				if(!visited[nextNode])
				{
					cnt++;
					visited[nextNode]=true;
					q.offer(nextNode);
				}
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		tree = new ArrayList[n+1];
		for(int i=1; i<=n; i++)
			tree[i] = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			int a,b;
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			tree[b].add(a);
		}
		
		int[] result = new int[n+1];
		Arrays.fill(result,0);
		for(int i=1; i<=n; i++)
			result[i]=bfs(i);
		
		int maxValue = 0;
		for(int i=1; i<=n; i++) {
			maxValue = Math.max(maxValue, result[i]);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			if(result[i]==maxValue)
				sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
	}
}