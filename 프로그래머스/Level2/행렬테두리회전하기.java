import java.io.*;
import java.util.*;

class Solution {
	
	int[][] board;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        this.board = new int[rows+1][columns+1];
        
        for(int i=1; i<=rows; i++) {
        	for(int j=1; j<=columns; j++) {
        		board[i][j] = (i-1)*columns + j;
        	}
        }
        
        for(int i=0; i<queries.length; i++) {
        	answer[i] = rotate(queries[i]);
        }
        
        return answer;
    }
    
    public int rotate(int[] query) {
    	int x1 = query[0]; int y1 = query[1];
    	int x2 = query[2]; int y2 = query[3];
    	
    	int tmp = this.board[x1][y1];
    	int minValue = tmp;
    	for(int i = x1; i < x2; i++) {
    		this.board[i][y1] = this.board[i+1][y1];
    		minValue = Math.min(minValue, this.board[i][y1]);
    	}
    	for(int i = y1; i < y2; i++){ 
            this.board[x2][i] = this.board[x2][i+1];
            minValue = Math.min(minValue, this.board[x2][i]);
        }
        for(int i = x2; i > x1; i--){ 
            this.board[i][y2] = this.board[i-1][y2];
            minValue = Math.min(minValue, this.board[i][y2]);
        }
        for(int i = y2; i > y1; i--){ 
            this.board[x1][i] = this.board[x1][i-1];
            minValue = Math.min(minValue, this.board[x1][i]);
        }
        this.board[x1][y1+1] = tmp; 
        
        return minValue;
    }
}

public class Main {	
	public static void main(String[] args) throws IOException {
		int rows = 6;
		int cols = 6;
		int[][] queris = {
				{2,2,5,4},
				{3,3,6,6},
				{5,1,6,3}
		};
		
		System.out.println(new Solution().solution(rows, cols, queris));
	}
}