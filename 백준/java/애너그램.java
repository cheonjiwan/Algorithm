import java.util.*;
import java.io.*;

public class Main
{
	
	static int n;
	static int[] arr = new int[26];
	static char[] res;
	
	public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        while(n-->0) {
        	for(int i=0; i<26; i++) {
        		arr[i]=0;
        	}
        	
        	String data = br.readLine();
        	res = new char[data.length()];
        	for(int i=0; i<data.length(); i++) {
        		arr[data.charAt(i)-'a']++;
        	}
        	
        	solve(0,0,data.length());
        }        
    }
	
	private static void solve(int idx, int cnt,int len) {
		if(cnt==len) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<len; i++) {
				sb.append(res[i]);
			}
			System.out.println(sb.toString());
			return;
		}
		
		for(int i=0; i<26; i++) {
			if(arr[i]>0) {
				arr[i]--;
				res[cnt]=(char)('a'+i);
				solve(i,cnt+1,len);
				arr[i]++;
			}
		}
	}
}