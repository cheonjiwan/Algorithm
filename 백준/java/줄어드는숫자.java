import java.io.*;
import java.util.*;

public class Main {
	
	static long n;
	static Queue<Long> q = new LinkedList<>();
	static long ans;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	n = Long.parseLong(br.readLine());
    	
    	long cnt=0;
    	for(long i=0; i<10; i++) {
    		if(i+1==n) {
    			ans=cnt;
    		}
    		q.offer(i);
    		cnt++;
    	}
    	
    	if(n>1023)
    		ans = -1;
    	else if(n>10) {
    		while(cnt<n) {
    			long cur = q.poll();
    			long tmp = cur%10;
    			for(int i=0; i<tmp; i++) {
    				long num = (long)cur*10+i;
    				q.offer(num);
    				ans = num;
    				cnt++;
    				
    				if(cnt==n) break;
    			}
    		}
    	}
    	System.out.println(ans);
	}
}