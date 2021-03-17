import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
	
		int g = gcd(Math.max(a, b),Math.min(a, b));
		int l = a*b/g;
		StringBuilder sb = new StringBuilder();
		sb.append(g).append('\n').append(l);
		System.out.println(sb.toString());
	}
	
	private static int gcd(int a, int b) {
		while(b>0) {
			int tmp=a;
			a=b;
			b=tmp%b;
		}
		return a;
	}
}
