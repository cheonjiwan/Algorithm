import java.io.*;
import java.util.*;

public class Main { 
	
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] data = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] arr = new int[n];
		int cur=0;
		arr[cur++]=data[0];
		for(int i=1; i<n; i++) {
			if(arr[cur-1]<data[i]) {
				arr[cur++]=data[i];
			}
			else {
				int idx = Arrays.binarySearch(arr, 0, cur, data[i]);
				if(idx<0)
					idx = -idx-1;
				arr[idx]=data[i];
			}
		}
		System.out.println(n-cur);
	}
}