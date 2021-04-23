import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static int[] minTree,data;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		minTree = new int[n*4];
		data = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		
		init(1,n,1);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(findmin(1,n,1,a,b)+"\n");
		}
		System.out.println(sb.toString());
	}
	private static int findmin(int start, int end, int node, int left, int right) {
		if(end<left || right<start)
			return Integer.MAX_VALUE;
		
		if(left <= start && end <= right) {
			return minTree[node];
		}
		
		int mid = (start+end)/2;
		return Math.min(findmin(start,mid,node*2,left,right), findmin(mid+1,end,node*2+1,left,right));
	}
	
	private static int init(int start, int end, int node) {
		if(start==end) {
			return minTree[node] = data[start];
		}
		int mid = (start+end)/2;
		return minTree[node] = Math.min(init(start,mid,node*2), init(mid+1,end,node*2+1));
	}
}