import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static ArrayList<Integer> data = new ArrayList<>();
	static int ans;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0; i<n; i++) {
    		data.add(Integer.parseInt(st.nextToken()));
    	}
    	
    	solve(0);
    	System.out.println(ans);
	}
	
	private static void solve(int sum) {
		if(data.size()==2) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int i=1; i<data.size()-1; i++) {
			int num = data.get(i-1)*data.get(i+1);
			int energy = data.get(i);
			data.remove(i);
			solve(sum+num);
			data.add(i, energy);
		}
	}
}