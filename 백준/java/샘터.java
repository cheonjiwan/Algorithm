import java.io.*;
import java.util.*;
import java.util.*;
class Main {

	static int n,k;
	static Queue<Long> q;
	static HashSet<Long> set = new HashSet<>();
	static long answer=0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		q = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			Long num = Long.parseLong(st.nextToken());
			q.offer(num);
			set.add(num);
		}
		bfs();
		System.out.println(answer);
	}
	
	private static void bfs() {
		int dist=1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				long cur = q.poll();
				long left=cur-1;
				long right=cur+1;
				
				if(!set.contains(left))
				{
					set.add(left);
					q.offer(left);
					answer+=dist;
					k--;
					if(k==0)
						return;
				}
				if(!set.contains(right)) {
					set.add(right);
					q.offer(right);
					answer+=dist;
					k--;
					if(k==0)
						return;
				}
			}
			dist++;
		}
	}
}