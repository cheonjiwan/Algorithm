import java.io.*;
import java.util.*;

public class Main {
	static int n,l,r,x;
	static int[] data;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		data = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0,0,Integer.MAX_VALUE,0,0);
		System.out.println(answer);
	}
	
	public static void solve(int start,int cnt, int minValue, int maxValue, int sum) {
		
		if(cnt>=2) {
			if(sum>=l && sum<=r && maxValue-minValue>=x)
				answer++;
		}
		for(int i=start; i<n; i++) {
			solve(i+1,cnt+1,Math.min(minValue, data[i]), Math.max(maxValue, data[i]),sum+data[i]);
		}
	}
	
}