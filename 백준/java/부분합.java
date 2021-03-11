import java.io.*;
import java.util.*;

public class Main { 
	
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n =Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] data = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		int minLength = Integer.MAX_VALUE;
		int end=1;
		int sum=data[0];
		for(int start=0; start<n; start++) {
			while(sum<s && end<n) {
				sum+=data[end];
				end++;
			}
			
			if(sum>=s) {
				minLength = Math.min(minLength, end-start);
			}
			sum-=data[start];
		}
		minLength = minLength==Integer.MAX_VALUE ? 0 : minLength;
		System.out.println(minLength);
	}
}