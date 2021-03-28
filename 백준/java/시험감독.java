import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	int[] data = new int[n];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0; i<n; i++) {
    		data[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	int b = Integer.parseInt(st.nextToken());
    	int c = Integer.parseInt(st.nextToken());
    	
    	for(int i=0; i<n; i++) {
    		data[i]= Math.max(0, data[i]-b);
    	}
    	
    	long ans=n;
    	for(int i=0; i<n; i++) {
    		if(data[i]%c!=0)
    			ans+=(long)(data[i]/c)+1;
    		else
    			ans+=(long)data[i]/c;
    	}
    	System.out.println(ans);
	}
}