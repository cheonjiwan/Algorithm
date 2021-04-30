import java.util.*;
import java.io.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        // 1
        String lower = new_id.toLowerCase();
        
        // 2
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<lower.length(); i++) {
        	char ch = lower.charAt(i);
        	if('0'<= ch && ch<='9') sb.append(ch);
        	else if('a'<=ch && ch<='z') sb.append(ch);
        	else if(ch=='-') sb.append(ch);
        	else if(ch=='_') sb.append(ch);
        	else if(ch=='.') sb.append(ch);
        }
        
        // 3
        String replacePoint=sb.toString();
        while(replacePoint.contains("..")) {
        	replacePoint = replacePoint.replace("..", ".");
        }
        
        // 4
        sb = new StringBuilder(replacePoint);
        if(sb.charAt(0)=='.') sb.deleteCharAt(0);
        else if(sb.charAt(sb.length()-1)=='.') sb.deleteCharAt(sb.length()-1);
        
        // 5
        if(sb.toString().length()==0) sb.append("a");
        else if(sb.toString().length()>=16) sb.delete(15, sb.toString().length()); // 6   	
        if(sb.charAt(sb.length()-1)=='.') sb.deleteCharAt(sb.length()-1);
        
        // 7
        if(sb.toString().length()<=2) {
        	char ch = sb.toString().charAt(sb.toString().length()-1);
        	while(sb.length()<3)
        		sb.append(ch);
        }
        return sb.toString();
    }
}

public class Main {
	
    public static void main(String[] args){
    	String new_id = "abcdefghijklmn.p";
    	System.out.println(new Solution().solution(new_id));
    }
}