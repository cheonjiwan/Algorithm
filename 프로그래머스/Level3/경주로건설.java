import java.io.*;
import java.util.*;

class Solution {
	
	static int[] dx = {-1,0,1,0}; static int[] dy = {0,-1,0,1};
	static Queue<Pos> q = new LinkedList<>();
	static boolean[][] visited;
	static int n,ans=Integer.MAX_VALUE;
	
    public int solution(int[][] board) {
        
        n = board.length;
        
        if(board[0][1]==0) {
        	q.offer(new Pos(0,1,100,3));
        	board[0][1]=100;
        }
        
        if(board[1][0]==0) {
        	q.offer(new Pos(1,0,100,2));
        	board[1][0]=100;
        }

        
        while(!q.isEmpty()) {
        	Pos cur = q.poll();
        	int x = cur.x;
        	int y = cur.y;
        	int cost = cur.cost;
        	int dir = cur.dir;
        	
        	if(x==n-1 && y==n-1) {
        		ans = Math.min(ans, cost);
        		continue;
        	}
        	
        	for(int idx=0; idx<4; idx++) {
        		int newCost;
        		if(dir!=idx)
        			newCost = cost+600;
        		else
        			newCost = cost+100;
        		
        		int nx = x + dx[idx];
        		int ny = y + dy[idx];
        		if(check(nx,ny)) {
        			if(board[nx][ny]==0)
        			{
        				board[nx][ny]=newCost;
        				q.offer(new Pos(nx,ny,newCost,idx));
        			}
        			else if(board[nx][ny]>=newCost) {
        				board[nx][ny]=newCost;
        				q.offer(new Pos(nx,ny,newCost,idx));
        			}
        		}
        	}
        }
        return ans;
    }
    
    private static boolean check(int nx, int ny) {
    	if(0<=nx && nx<n && 0<=ny && ny<n)
    		return true;
    	return false;
    }
    static class Pos{
    	int x,y,cost,dir;
    	Pos(int x, int y,int cost,int dir){
    		this.x=x;
    		this.y=y;
    		this.cost=cost;
    		this.dir=dir;
    	}
    }
}

public class Main {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
		System.out.println(solution.solution(board));
	}

}