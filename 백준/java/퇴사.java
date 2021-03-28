import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[] T,P;
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st ;
    	
    	n = Integer.parseInt(br.readLine());
    	T = new int[n];
    	P = new int[n];
    	
    	for(int i=0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		int t = Integer.parseInt(st.nextToken());
    		int p = Integer.parseInt(st.nextToken());
    		
    		T[i] = t;
    		P[i] = p;
    	}
    	
    	dfs(0,0);
    	System.out.println(ans);
	}
	
	private static void dfs(int idx, int value) {
		if(idx>=n) {
			ans = Math.max(ans, value);
			return ;
		}
		
		if(idx+T[idx]<=n)
			dfs(idx+T[idx],value+P[idx]);
		else
			dfs(idx+T[idx],value);
		dfs(idx+1,value);
	}
}