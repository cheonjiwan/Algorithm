import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] data = new String[n];
		for(int i=0; i<n; i++) {
			data[i] = br.readLine();
		}
		
		Arrays.sort(data,new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				if(a.length()==b.length()) {
					return a.compareTo(b);
				}
				return a.length()-b.length();
			}
		});
		
		StringBuilder sb = new StringBuilder();
		HashSet<String> set = new HashSet<>();
		for(int i=0; i<n; i++) {
			if(!set.contains(data[i])) {
				sb.append(data[i]+'\n');
				set.add(data[i]);
			}
		}
		System.out.println(sb.toString());
	}
	
}