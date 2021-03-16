import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] have = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			have[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] find = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			find[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(have);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			if(binarySearch(have,find[i]))
				sb.append("1 ");
			else
				sb.append("0 ");
		}
		
		System.out.println(sb.toString());
	}
	
	private static boolean binarySearch(int[] have, int find) {
		int left,right;
		left=0;
		right=have.length-1;
		while(left<=right) {
			int mid=(int)(left+right)/2;
			if(have[mid]==find) {
				return true;
			}
			else if(have[mid]<find) {
				left=mid+1;
			}
			else if(have[mid]>find) {
				right=mid-1;
			}
		}
		
		return false;
	}

}
