import java.util.*;

import java.io.*;
class Solution {
	static int userLen,bannedLen;
	static boolean[] visited;
	static String[] user,banned;
	static HashSet<String> set = new HashSet<>();
	
    public int solution(String[] user_id, String[] banned_id) {
    	int answer = 0;
    	
    	user = user_id;
    	banned = banned_id;
    	userLen = user_id.length;
    	bannedLen = banned_id.length;
    	visited = new boolean[userLen];
    	
    	dfs(0,"");
        
        return set.size();
    }
    
    private static void dfs(int cur, String str) {
    	if(cur==banned.length) {
    		StringBuilder sb = new StringBuilder();
    		for(int i=0; i<userLen; i++) {
    			if(str.contains(""+i))
    				sb.append(""+i);
    		}
    		if(!set.contains(sb.toString()))
    			set.add(sb.toString());
    		
    		return;
    	}
    	
    	for(int i=0; i<userLen; i++) {
    		if(!visited[i]) {
    			if(isSame(user[i],banned[cur])) {
    				visited[i] = true;
    				dfs(cur+1,str+i);
    				visited[i] = false;
    			}
    		}
    	}
    }
    
    private static boolean isSame(String a, String b) {
    	if(a.length()!=b.length())
    		return false;
    	for(int i=0; i<a.length(); i++) {
    		if(b.charAt(i) == '*') continue;
    		if(a.charAt(i)!=b.charAt(i)) return false;
    	}
    	return true;
    }
}

public class Main {
    public static void main(String[] args){
    	String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
    	String[] banned_id = {"fr*d*", "abc1**"};
    	
    	System.out.println(new Solution().solution(user_id, banned_id));
    }
}