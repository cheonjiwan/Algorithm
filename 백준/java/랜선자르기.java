import java.io.*;
import java.util.*;
import java.util.*;
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		long[] data = new long[k];
		long max=0;
		for(int i=0; i<k; i++) {
			data[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, data[i]);
		}
		
		long answer=0;
		long left=1,right=max;
		while(left<=right) {
			long mid = (long)(left+right)/2;
			long total=0;
			for(int i=0; i<k; i++) {
				total+=data[i]/mid;
			}
			
			if(total>=n) {
				left=mid+1;
				answer=mid;
			}
			else {
				right=mid-1;
			}
		}
		
		System.out.println(answer);
	}
}