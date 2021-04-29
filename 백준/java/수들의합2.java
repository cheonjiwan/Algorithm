import java.util.*;
import java.io.*;

public class Main {
	static int n,m;
	static int[] data;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	data = new int[n];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<n; i++)
    		data[i] = Integer.parseInt(st.nextToken());
    	
    	int left=0,right=0;
    	int cnt=0,sum=0;
    	
    	while(true) {
    		if(sum>=m) {
    			sum-=data[left++];
    		}
    		else if(right>=n) break;
    		else if(sum<m) {
    			sum+=data[right++];
    		}
    		
    		if(sum==m)
    			cnt++;
    	}
    	System.out.println(cnt);
    }
}