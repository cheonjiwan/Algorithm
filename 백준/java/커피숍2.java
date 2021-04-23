import java.io.*;
import java.util.*;

import javax.xml.crypto.Data;

public class Main {
	
	static int n,q;
	static long[] data,tree;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		data = new long[n+1];
		tree = new long[n*4];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++)
			data[i] = Long.parseLong(st.nextToken());
		
		init(1,n,1);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			int x,y,a;
			long b;
			x= Integer.parseInt(st.nextToken());
			y= Integer.parseInt(st.nextToken());
			a= Integer.parseInt(st.nextToken());
			b= Integer.parseInt(st.nextToken());
			
			int first, last;
			if(x<y)
			{
				first = x;
				last = y;
			}
			else {
				first = y;
				last = x;
			}
		
			sb.append(sum(1,n,1,first,last)+"\n");
			
			long pre = data[a];
			data[a] = b;
			update(1,n,1,a,b-pre);
		}
		System.out.println(sb.toString());
	}
	
	private static long init(int start, int end, int node) {
		if(start==end) {
			return tree[node] = data[start];
			
		}
		int mid = (start+end)/2;
		return tree[node] = init(start,mid,node*2) + init(mid+1,end,node*2+1);
	}
	
	private static long sum(int start, int end, int node, int left, int right) {
		if(end<left || right<start)
			return 0;
		if(left<=start && end<=right)
			return tree[node];
		
		int mid = (start+end)/2;
		return sum(start,mid,node*2,left,right) + sum(mid+1,end,node*2+1,left,right);
	}
	
	private static void update(int start,int end, int node, int idx, long dif) {
		if(end<idx || idx<start)
			return;
		
		tree[node]+=dif;
		if(start==end)
			return;
		int mid = (start+end)/2;
		update(start,mid,node*2,idx,dif);
		update(mid+1,end,node*2+1,idx,dif);
	}

}