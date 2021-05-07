import java.util.*;
import java.io.*;

class Solution {
	
	static ArrayList<String> combis = new ArrayList<>();
	static ArrayList<String> result = new ArrayList<>();
	static boolean[] visited;
	static int n,m;
	
    public int solution(String[][] relation) {
    	n = relation.length;
		m = relation[0].length;
		visited = new boolean[m];
		
		for(int i=1; i<=m; i++)
			combi(0,i);
		
		for(String combi : combis) {
			HashSet<String> set = new HashSet<>();
			for(int row=0; row<n; row++) {
				String tmp = "";
				for(int idx=0; idx<combi.length(); idx++) {
					char key = combi.charAt(idx);
					tmp += relation[row][key-'0'];
				}
				set.add(tmp);
			}
			
			if(n==set.size()) {
				boolean flag=true;
				for(int i=0; i<result.size(); i++) {
					if(!check(combi))
					{
						flag=false;
						break;
					}
				}
				
				if(flag)
					result.add(combi);
			}
		}
		
        return result.size();
    }
    
    public static boolean check(String combi) {
    	for(int i=0; i<result.size(); i++) {
    		String candi = result.get(i);
    		int cnt=0;
    		for(int j=0; j<combi.length(); j++) {
    			int num = combi.charAt(j)-'0';
    			if(candi.contains(""+num))
    				cnt++;
    		}
    		if(cnt==candi.length())
    			return false;
    	}
    	return true;
    }
    
    public static void combi(int start, int len) {
    	if(len==0) {
    		String result="";
    		for(int i=0; i<m; i++) {
    			if(visited[i])
    				result+=i;
    		}
    		combis.add(result);
    		return;
    	}
    	
    	for(int i=start; i<m; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			combi(i+1,len-1);
    			visited[i] = false;
    		}
    	}
    }
}

public class Main {  
   public static void main(String[] args){
      String[][] relation = {
    		  {"100","ryan","music","2"},
    		  {"200","apeach","math","2"},
    		  {"300","tube","computer","3"},
    		  {"400","con","computer","4"},
    		  {"500","muzi","music","3"},
    		  {"600","apeach","music","2"}
      };
      System.out.println(new Solution().solution(relation));
   }
     
}


