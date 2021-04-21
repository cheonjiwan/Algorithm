import java.io.*;
import java.util.*;

public class Main {
	
	static int t;
	static long[] min;
	static String[] max;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(br.readLine());
		
		min = new long[101]; max = new String[101];
		Arrays.fill(min, Long.MAX_VALUE);
		min[2] = 1;
		min[3] = 7;
		min[4] = 4;
		min[5] = 2;
		min[6] = 6;
		min[7] = 8;
		min[8] = 10;
		
		String[] add = {"1","7","4","2","0","8"};
		for(int i=9; i<=100; i++) {
			for(int j=2; j<=7; j++) {
				String cur = min[i-j] + add[j-2];
				min[i] = Math.min(min[i], Long.parseLong(cur));
			}
		}
		
		String[] add2 = {"0","0","1","7","4","2","6","8"};
		max[2] = "1";
		
		while(t-->0) {
			StringBuilder sb = new StringBuilder();
			int num = Integer.parseInt(br.readLine());
			int len = num/2;
			
			if(num%2==0) {
				sb.append("1");
			}
			else {
				sb.append("7");
			}
			
			for(int i=0; i<len-1; i++) {
				sb.append("1");
			}
			
			System.out.println(min[num]+" "+sb.toString());
		}
	}
}