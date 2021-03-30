import java.util.*;
import java.io.*;


public class Main
{
	
	static int n,k;
	static String data;
	static boolean[] visited;
	
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        data = br.readLine();
        
        int cnt=0;
        for(int i=0; i<n; i++) {
        	if(data.charAt(i)=='P') {
        		for(int j=i-k; j<=i+k; j++) {
        			if(0<=j && j<n && data.charAt(j)=='H' && !visited[j]) {
        				visited[j]=true;
        				cnt++;
        				break;
        			}
        		}
        	}
        }
        
        System.out.println(cnt);
    }
    
    
}

