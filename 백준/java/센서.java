import java.io.*;
import java.util.*;

public class Main { 
	
	static int n,k;
	static int[] data;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static int solve() {
		Arrays.sort(data);
		for(int i=0; i<n-1; i++) {
			list.add(Math.abs(data[i+1]-data[i]));
		}
		
		Collections.sort(list,Collections.reverseOrder());
		for(int i=0; i<k-1; i++)
			list.set(i, 0);
		
		int sum=0;
		for(int i=0; i<n-1; i++)
			sum+=list.get(i);
		return sum;
	}
	
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		data = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		if(k>=n)
			System.out.println(0);
		else {
			System.out.println(solve());
		}		
	} 
}