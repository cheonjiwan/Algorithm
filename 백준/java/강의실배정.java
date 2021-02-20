package ps;
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {
	
	static int n;
	
	static class Data{
		int s,e;
		Data(int s, int e){
			this.s = s;
			this.e = e;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		Data[] data = new Data[n];	
		int s,e;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			data[i]=new Data(s,e);
		}
		
		Arrays.sort(data,(a,b) -> a.s==b.s ? a.e - b.e : a.s - b.s);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(data[0].e);
		for(int i=1; i<n; i++) {
			if(pq.peek()<=data[i].s) {
				pq.poll();
			}
			pq.offer(data[i].e);
		}
		
		System.out.println(pq.size());
		
	}

}
