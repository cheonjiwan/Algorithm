import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
    	
    	String[] setLists = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(setLists,(a,b) -> (a.length() - b.length()));
		  
		int[] answer = new int[setLists.length]; 
		int resultIdx=0;
		
		HashMap<String,Integer> mymap = new HashMap<>();
		for(String setList : setLists) {
			for(String num : setList.split(",")) {
				if(!mymap.containsKey(num)) {
					answer[resultIdx++]=Integer.parseInt(num);
					mymap.put(num, 1);				
				}
			}
		}
		 
		return answer;
    }
}

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String s = "{{20,111},{111}}";
		System.out.println(new Solution().solution(s).toString());		
	}
}
