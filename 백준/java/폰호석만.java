import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static int[][] distance;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	String a,b;
    	a = st.nextToken();
    	b = st.nextToken();
    	ArrayList<Data> ans = new ArrayList<>();
    	for(int i=2; i<=36; i++) {
    		for(int j=2; j<=36; j++) {
    			if(i==j)
    				continue;
    			if(toint(a,i)==-1 || toint(b,j)==-1)
    				continue;
    			if(toint(a,i)==toint(b,j)) {
    				ans.add(new Data(i,j));
    			}
    		}
    	}
    	
    	if(ans.size()==0) {
    		System.out.println("Impossible");
    	}
    	else if(ans.size()>1) {
    		System.out.println("Multiple");
    	}
    	else {
    		StringBuffer sb = new StringBuffer();
    		sb.append(toint(a,ans.get(0).i)).append(' ').append(ans.get(0).i).append(' ').append(ans.get(0).j);
    		System.out.println(sb.toString());
    	}
    	
	}
	
	private static long toint(String a, int i) {
		long sum=0;
		for(int idx=0; idx<a.length(); idx++) {
			if(tonum(a.charAt(idx))>=i){
				return -1;
			}
			sum*=i;
			sum+=tonum(a.charAt(idx));
		}
		if(sum>=(long)Math.pow(2, 63))
			return -1;
		
		return sum;
	}
	
	private static int tonum(char ch) {
		if('0'<=ch && ch<='9')
			return ch-'0';
		else {
			return ch-'a'+10;
		}
	}
	
	static class Data{
		int i,j;
		Data(int i,int j){
			this.i=i;
			this.j=j;
		}
	}
}