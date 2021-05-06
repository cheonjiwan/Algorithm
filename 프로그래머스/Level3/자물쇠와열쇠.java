import java.io.*;
import java.util.*;

class Solution {
	
	static int n,m;
	static int[][] newLock,newKey;
	
    public boolean solution(int[][] key, int[][] lock) {
        n = lock.length; m = key.length;
        
        newLock = new int[n*3][n*3];
        for(int i=n; i<2*n; i++) {
        	for(int j=n; j<2*n; j++) {
        		newLock[i][j] = lock[i-n][j-n];
        	}
        }
        newKey = key;
        int k=4;
        while(k-->0) {
        	newKey = rotate(newKey);
        	for(int i=0; i<=newLock.length - m; i++) {
        		for(int j=0; j<=newLock[0].length - m; j++) {
        			if(pushKey(i,j)) return true;
        		}
        	}
        }
        return false;
    }
    
    public boolean pushKey(int startRow, int startCol) {
    	int[][] copyNewLock = new int[n*3][n*3];
    	for(int i=0; i<n*3; i++) {
    		for(int j=0; j<n*3; j++) {
    			copyNewLock[i][j] = newLock[i][j];
    		}
    	}
    	
    	for(int i=startRow,x=0; i<startRow+m; i++,x++) {
    		for(int j=startCol,y=0; j<startCol+m; j++,y++) {
    			copyNewLock[i][j] = copyNewLock[i][j]^newKey[x][y];
    		}
    	}
    	return check(copyNewLock) ? true : false;
    }
    
    public boolean check(int[][] copyNewLock) {
    	for(int i=n; i<2*n; i++) {
    		for(int j=n; j<2*n; j++) {
    			if(copyNewLock[i][j]!=1) return false;
    		}
    	}
    	return true;
    }
    
    public int[][] rotate(int[][] key) {
        int row = key[0].length, col = key.length;
        int[][] rotate = new int[row][col];

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
            	rotate[i][j] = key[row-1-j][i];

        return rotate;
    }
}

public class Main {
	
	public static void main(String[] args){
		int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
		int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};
		System.out.println(new Solution().solution(key, lock));
	}
	
}