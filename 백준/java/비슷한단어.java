import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
	// write your code here
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        int n = Integer.parseInt(br.readLine());
        
        String first = br.readLine();
        int len = first.length();
        int[] alphabet = new int[26];
        for(int i=0; i<len; i++) {
            alphabet[first.charAt(i)-'A']++;
        }
        
        int ans = 0;
        while(n-->1) {
            int[] temp = alphabet.clone();
            String input = br.readLine();
            
            int cnt = 0;
            for(int i=0; i<input.length(); i++) {
                if(temp[input.charAt(i)-'A'] > 0){
                    cnt++;
                    temp[input.charAt(i)-'A']--;
                }
            }
            if(len-1 == input.length() && cnt == input.length()) {
                ans++;
            } 
            else if(len == input.length() && (cnt == len || cnt == len-1)) {
                ans++;
            } 
            else if(len+1 == input.length() && cnt == len) {
            	ans++;	
            }
        }
        System.out.println(ans);
    }
}