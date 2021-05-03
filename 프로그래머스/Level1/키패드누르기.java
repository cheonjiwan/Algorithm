import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        Hand left = new Hand(3,0);
        Hand right = new Hand(3,2);
        
        StringBuilder sb = new StringBuilder();
        for(int number : numbers) {
        	if(number==0)
        		number=11;
        	
        	if(number==1 || number==4 || number==7) {
        		sb.append('L');
        		left.x = (int)((number-1)/3);
        		left.y = (number-1)%3;
        	}
        	else if(number==3 || number==6 || number==9) {
        		sb.append('R');
        		right.x = (int)((number-1)/3);
        		right.y = (number-1)%3;
        	}
        	else {
        		Hand tmp = new Hand(number/3, 1);
        		
        		int leftDistance=Math.abs(left.x-tmp.x) + Math.abs(left.y-tmp.y);
        		int rightDistance=Math.abs(right.x-tmp.x) + Math.abs(right.y-tmp.y);
        		if(leftDistance<rightDistance)
        		{
        			left.x=tmp.x; left.y=tmp.y;
        			sb.append('L');
        		}
        		else if(leftDistance>rightDistance) {
        			right.x=tmp.x; right.y = tmp.y;
        			sb.append('R');
        		}
        		else {
        			if(hand.equals("left")) {
        				sb.append('L');
        				left.x=tmp.x; left.y=tmp.y;
        			}
        			else {
        				sb.append('R');
        				right.x=tmp.x; right.y = tmp.y;
        			}
        		}
        	}
        	
        }
        
        return sb.toString();
    }
    
    static class Hand{
    	int x,y;
    	Hand(int x, int y){
    		this.x=x;
    		this.y=y;
    	}
    }
}

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";
		System.out.println(new Solution().solution(numbers,hand));		
	}

}
