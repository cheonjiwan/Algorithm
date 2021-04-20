import java.io.*;
import java.util.*;

class Solution {
    public static int[] solution(String[] gems) {
            int resultStart =0, resultEnd=Integer.MAX_VALUE;
            int start = 0, end = 0;
            
            HashSet<String> set = new HashSet<>();
            for(int i = 0; i < gems.length; i++) 
            	set.add(gems[i]);
            
            int size = set.size();
            HashMap<String, Integer> map = new HashMap<>();  
            
            while(start < gems.length) {  
                if(map.size() >= size) {  
                    if(map.get(gems[start]) == 1) 
                    	map.remove(gems[start++]); 
                    else 
                    	map.put(gems[start], map.get(gems[start++])-1); 
                } 
                else if(end == gems.length) 
                	break; 
                else {
                    if(!map.containsKey(gems[end])) 
                    	map.put(gems[end++], 1);
                    else 
                    	map.put(gems[end], map.get(gems[end++])+1); 
                }
                
                if(size == map.size()) {  
                    if(resultEnd-resultStart > (end-start)) { 
                        resultStart = start;
                        resultEnd = end;
                    } else if(resultEnd-resultStart == (end-start)) { 
                        if(resultStart > start) {
                            resultStart = start;
                            resultEnd = end;    
                        }
                    }
                }
            }
            
            resultStart++;
            return new int[] {resultStart,resultEnd};
    }
}

public class Main {
	
	public static void main(String[] args){
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		System.out.println(Arrays.toString(new Solution().solution(gems)));
	}
	
}