import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	
    	StringBuilder sb = new StringBuilder();
    	while(n-->0) {
    		String str = br.readLine();
    		if(str.matches("^(100+1+|01)+$"))
    			sb.append("YES"+'\n');
    		else
    			sb.append("NO"+'\n');
    	}
    	
    	System.out.println(sb.toString());
    }
}