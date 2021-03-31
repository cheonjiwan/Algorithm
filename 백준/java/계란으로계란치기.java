import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[] S,W;
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    
    	n = Integer.parseInt(br.readLine());
    	S = new int[n];
    	W = new int[n];
    	
    	for(int i=0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		S[i] = Integer.parseInt(st.nextToken());
    		W[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	solve(0);
    	System.out.println(ans);
	}
	
	private static void solve(int idx) {
		if(idx==n) {
			int cnt=0;
			for(int i=0; i<n; i++) {
				if(S[i]<=0)
					cnt++;
			}
			ans = Math.max(ans, cnt);
			return;
		}
		
		if(S[idx]<=0) {
			solve(idx+1);
		}
		else {
			boolean flag=false;
			for(int i=0; i<n; i++) {
				if(i==idx || S[i]<=0)
					continue;
				flag=true;
				S[i]-=W[idx];
				S[idx]-=W[i];
				solve(idx+1);
				S[i]+=W[idx];
				S[idx]+=W[i];
			}
			if(!flag)
				solve(idx+1);
		}
	}
}