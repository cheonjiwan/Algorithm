import java.util.*;
import java.io.*;

public class Main {
	
	static int n,m,k;
	static int[] data;
	static int result;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	m = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	int sum=0;
    	data = new int[m];
    	for(int i=0; i<m; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		data[i] = num;
    		sum+=num;
    	}
    	
    	k = Integer.parseInt(br.readLine());
    	double result = 0;
    	for(int i=0; i<m; i++) {
    		double tmp = 1;
    		if(data[i] >= k) {
    			for(int j=0; j<k; j++) {
    				tmp *= (data[i]-j)/(double)(sum-j);
    			}
    			result+=tmp;
    		}
    	}
    	System.out.println(result);
    }
}