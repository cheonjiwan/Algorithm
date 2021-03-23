import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = {-1,0,1,0}; static int[]dy = {0,-1,0,1};
	static int n;
	static int[][] board;
	static int[][] retMap;
	static int max = Integer.MIN_VALUE;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	n = Integer.parseInt(br.readLine());
    	board = new int[n][n];
    	retMap = new int[n][n];
    	for(int i=0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<n; j++) {
    			int num = Integer.parseInt(st.nextToken());
    			board[i][j] = num;
    			retMap[i][j] = num;
    		}
    	}
    	solution(board, 0);
    	System.out.println(max);
    }
    
    private static void solution(int[][] argMap,int depth) {
    	if(depth==5) {
    		for(int i=0; i<n; i++) {
    			for(int j=0; j<n; j++) {
    				max = Math.max(max, argMap[i][j]);
    			}
    		}
    		return;
    	}
    	for(int i=0; i<4; i++) {
    		retMap = moveMap(argMap,i);
    		solution(retMap,depth+1);
    	}	
    }
    
    private static int[][] moveMap(int[][] board, int dir) {
    	
    	int[][] movedMap = new int[n][n];
    	int[][] sumMap = new int[n][n];
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			movedMap[i][j]=0;
    			sumMap[i][j]=0;
    		}
    	}
    	
    	// 0 ºÏ 1 ¼­ 2 ³² 3 µ¿
    	if(dir==0){
    		for(int col=0; col<n; col++) {
    			int row=0;
    			int idx=0;
    			while(row<n) {
    				if(board[row][col]==0) {
    					while(row<n && board[row][col]==0) {
    						row++;
    					}
    					if(row<n) {
    						movedMap[idx][col]=board[row][col];
    						idx++;
    					}
    					else
    						continue;
    				}
    				else {
    					movedMap[idx][col]=board[row][col];
    					idx++;
    				}
    				row++;
    			}
    		}
    		
    		for(int col=0; col<n; col++) {
    			int row=0;
    			int idx=0;
    			while(row<n) {
    				if(row==n-1) {
    					sumMap[idx][col]=movedMap[row][col];
    					idx++;
    					break;
    				}
    				if(movedMap[row][col]==movedMap[row+1][col]) {
    					sumMap[idx][col]=movedMap[row][col]*2;
    					idx++;
    					row++;
    				}
    				else {
    					sumMap[idx][col]=movedMap[row][col];
    					idx++;
    				}
    				row++;
    			}
    		}
    	}
    	
    	else if(dir==1) {
    		for(int row=0; row<n; row++) {
    			int col=0;
    			int idx=0;
    			while(col<n) {
    				if(board[row][col]==0) {
    					while(col<n && board[row][col]==0) {
    						col++;
    					}
    					if(col<n) {
    						movedMap[row][idx]=board[row][col];
    						idx++;
    					}
    					else
    						continue;
    				}
    				else {
    					movedMap[row][idx]=board[row][col];
    					idx++;
    				}
    				col++;
    			}
    		}
    		
    		for(int row=0; row<n; row++) {
    			int col=0;
    			int idx=0;
    			while(col<n) {
    				if(col==n-1) {
    					sumMap[row][idx]=movedMap[row][col];
    					idx++;
    					break;
    				}
    				if(movedMap[row][col]==movedMap[row][col+1]) {
    					sumMap[row][idx]=movedMap[row][col]*2;
    					idx++;
    					col++;
    				}
    				else {
    					sumMap[row][idx]=movedMap[row][col];
    					idx++;
    				}
    				col++;
    			}
    		}
    	}
    	else if(dir==2) {
    		for(int col=0; col<n; col++) {
    			int row=n-1;
    			int idx=n-1;
    			while(row>=0) {
    				if(board[row][col]==0) {
    					while(row>=0 && board[row][col]==0) {
    						row--;
    					}
    					if(row>=0) {
    						movedMap[idx][col]=board[row][col];
    						idx--;
    					}
    					else
    						continue;
    				}
    				else {
    					movedMap[idx][col]=board[row][col];
    					idx--;
    				}
    				row--;
    			}
    		}
    		
    		for(int col=0; col<n; col++) {
    			int row=n-1;
    			int idx=n-1;
    			while(row>=0) {
    				if(row==0) {
    					sumMap[idx][col]=movedMap[row][col];
    					idx--;
    					break;
    				}
    				if(movedMap[row][col]==movedMap[row-1][col]) {
    					sumMap[idx][col]=movedMap[row][col]*2;
    					idx--;
    					row--;
    				}
    				else {
    					sumMap[idx][col]=movedMap[row][col];
    					idx--;
    				}
    				row--;
    			}
    		}
    	}
    	else if(dir==3) {
    		for(int row=0; row<n; row++) {
    			int col=n-1;
    			int idx=n-1;
    			while(col>=0) {
    				if(board[row][col]==0) {
    					while(col>=0 && board[row][col]==0) {
    						col--;
    					}
    					if(col>=0) {
    						movedMap[row][idx]=board[row][col];
    						idx--;
    					}
    					else
    						continue;
    				}
    				else {
    					movedMap[row][idx]=board[row][col];
    					idx--;
    				}
    				col--;
    			}
    		}
    		
    		for(int row=0; row<n; row++) {
    			int col=n-1;
    			int idx=n-1;
    			while(col>=0) {
    				if(col==0) {
    					sumMap[row][idx]=movedMap[row][col];
    					idx--;
    					break;
    				}
    				if(movedMap[row][col]==movedMap[row][col-1]) {
    					sumMap[row][idx]=movedMap[row][col]*2;
    					idx--;
    					col--;
    				}
    				else {
    					sumMap[row][idx]=movedMap[row][col];
    					idx--;
    				}
    				col--;
    			}
    		}
    	}
    	
    	return sumMap;
    }
}