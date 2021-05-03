import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int move : moves) {
        	int row=0;
        	while(row<board.length && board[row][move-1]==0)
        		row++;
        	
        	if(row==board.length)
        		continue;
        	int cur = board[row][move-1];
        	board[row][move-1]=0;
        	if(stack.isEmpty())
        		stack.push(cur);
        	else {
        		if(stack.peek()==cur) {
        			stack.pop();
        			answer+=2;
        		}
        		else
        			stack.push(cur);
        	}
        }
        return answer;
    }
}

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(new Solution().solution(board, moves));		
	}

}
