import java.io.*;
import java.util.*;

public class Main { 
	
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] data = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			data[i] = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(br.readLine());
		
		Arrays.sort(data);
		int cnt=0,tmp=0;
		int left=0,right=n-1;
		while(left<right) {
			tmp = data[left]+data[right];
			if(tmp==x) {
				cnt++;
				left++;
				right--;
			}
			else if(tmp>x)
				right--;
			else if(tmp<x)
				left++;
				
		}
		System.out.println(cnt);
	}
}