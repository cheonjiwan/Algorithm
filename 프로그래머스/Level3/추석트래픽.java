import java.util.*;
import java.io.*;

class Solution {
	static int[] startTimes, endTimes;
	static int len,answer;
	
    public int solution(String[] lines) {
        
        len=lines.length; 
        startTimes = new int[len];
        endTimes = new int[len];
        
        timeToMilliseconds(lines);
        findStartWindow();
        findEndWindow();
        
        return answer;
    }
    
    public void findEndWindow() {
    	for(int i=0; i<len; i++) {
        	int start = endTimes[i];
        	int end = start+1000;
        	
        	int cnt=0;
        	for(int j=0; j<startTimes.length; j++) {
        		if(start<=startTimes[j] && startTimes[j]<end)
        			cnt++;
        		else if(start<=endTimes[j] && endTimes[j] < end) {
        			cnt++;
        		}
        		else if(startTimes[j]<=start && endTimes[j]>=end)
        			cnt++;
        	}
        	
        	answer = Math.max(answer, cnt);
        }
    }
    
    public void findStartWindow() {
    	for(int i=0; i<len; i++) {
        	int start = startTimes[i];
        	int end = start+1000;
        	
        	int cnt=0;
        	for(int j=0; j<startTimes.length; j++) {
        		if(start<=startTimes[j] && startTimes[j]<end)
        			cnt++;
        		else if(start<=endTimes[j] && endTimes[j] < end) {
        			cnt++;
        		}
        		else if(startTimes[j]<=start && endTimes[j]>=end)
        			cnt++;
        	}
        	
        	answer = Math.max(answer, cnt);
        }
    }
    
    public void timeToMilliseconds(String[] lines) {
    	int idx=0;
    	for(String line : lines) {
    		String[] log = line.split(" ");
    		String[] responseTime = log[1].split(":");
    		int start=0,end=0;
    		end += Integer.parseInt(responseTime[0])*3600*1000;
    		end += Integer.parseInt(responseTime[1])*60*1000;
    		end += (int)((Double.parseDouble(responseTime[2])) * 1000);
    		start = end - (int)(Double.parseDouble(log[2].substring(0,log[2].length()-1))*1000) + 1;
    		
    		startTimes[idx] = start;
    		endTimes[idx++] = end;
    	}
    }
}

public class Main {  
   public static void main(String[] args){
      String[] line = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
      System.out.println(new Solution().solution(line));
   }
     
}


