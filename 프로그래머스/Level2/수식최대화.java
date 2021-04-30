import java.util.*;
import java.io.*;

class Solution {
	static char[] c = {'+','-','*'};
	static char[] combi = new char[3];
	static ArrayList<Long> number = new ArrayList<>();
	static ArrayList<Character> op = new ArrayList<>();
	static boolean[] visited = new boolean[3];
	static long answer;
    public long solution(String expression) {
        
        String num="";
        for(int i=0; i<expression.length(); i++) {
        	if('0'<= expression.charAt(i) && expression.charAt(i)<='9') {
        		num+=expression.charAt(i);
        	}
        	else {
        		number.add(Long.parseLong(num));
        		op.add(expression.charAt(i));
        		num="";
        	}
        }
        number.add(Long.parseLong(num));
        solve(0);
        return answer;
    }
    
    private static void solve(int cur) {
    	if(cur==3) {
    		ArrayList<Long> copyNum = new ArrayList<>(number);
    		ArrayList<Character> copyOp = new ArrayList<>(op);
    		
    		for(int i=0; i<combi.length; i++) {
    			for(int j=0; j<copyOp.size(); j++) {
    				if(combi[i] == copyOp.get(j)) {
    					long a = copyNum.remove(j);
    					long b = copyNum.remove(j);
    					long result = cal(a,b,combi[i]);
    					copyNum.add(j,result);
    					copyOp.remove(j);
    					j--;
    				}
    			}
    		}
    		answer = Math.max(answer, Math.abs(copyNum.get(0)));
    		return;
    	}
    	
    	for(int i=0; i<3; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			combi[cur]=c[i];
    			solve(cur+1);
    			visited[i]=false;
    		}
    	}
    }
    
    private static long cal(long a, long b, char op) {
    	long result = 0;
    	if(op=='+') result = a+b;
    	else if(op=='-') result = a-b;
    	else if(op=='*') result = a*b;
    	
    	return result;
    }
}

public class Main {
	
    public static void main(String[] args){
    	String expression = "100-200*300-500+20";
    	System.out.println(new Solution().solution(expression));
    }
}