package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] per = {1,1,2,2,7,7,10,10,5};
	static int[][] dx = {
			{-1,1,-2,2,-1,1,-1,1,0,0},
			{0,0,1,1,1,1,2,2,3,2},
			{-1,1,-2,2,-1,1,-1,1,0,0},
			{0,0,-1,-1,-1,-1,-2,-2,-3,-2}
	};
	static int[][] dy = {
			{0,0,-1,-1,-1,-1,-2,-2,-3,-2},
			{-1,1,-2,2,-1,1,-1,1,0,0},
			{0,0,1,1,1,1,2,2,3,2},
			{1,-1,2,-2,1,-1,1,-1,0,0}
	};
	
	static int n; 
	static int [][] board;
	static int result = 0;
	
	public static void spread(int t_x, int t_y, int dir, int cost) {
		int nx=0,ny=0;
		
		int copy_cost = cost;
		for(int i=0; i<9; i++) 
		{
			nx = t_x + dx[dir][i];
			ny = t_y + dy[dir][i];
			
			int value = (int)(cost*((0.01)*per[i]));
			if(0<=nx && nx<n && 0<=ny && ny<n) 
			{
				board[nx][ny] += value;
			}
			else {
				result+=value;
			}
			copy_cost -= value;
		}
		nx = t_x + dx[dir][9];
		ny = t_y + dy[dir][9];
		if(0<=nx && nx<n && 0<=ny && ny<n) 
		{
			board[nx][ny] += copy_cost;
		}
		else {
			result+=copy_cost;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		board = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int t_x = (int)n/2, t_y = (int)n/2;
		
		int cnt = 1,cost=0;
		int x = t_x,y=t_y;
		int nx,ny;
		int alpha = 1;
		int d = -1,dir = 0;
		
		while(alpha<n) {
			for(int i=0; i<alpha; i++) { // 행
				nx = x ; ny = y; // 옮기기전 위치
				y = y+d;
				cost = board[x][y];
				board[x][y] = 0;
				spread(nx,ny,dir,cost);
			}
			d *=-1;
			dir = (dir+1)%4;
			for(int i=0; i<alpha; i++) { // 열
				nx = x; ny = y; 
				x = x+d;
				cost = board[x][y];
				board[x][y] = 0;
				spread(nx,ny,dir,cost);
			}
			alpha+=1;
			dir = (dir+1)%4;
		}
		for(int i=0; i<alpha-1; i++) {
			nx=x; ny=y;
			y = y+d;
			cost = board[x][y];
			board[x][y] = 0;
			spread(nx,ny,0,cost);
		}
		
		System.out.println(result);
	}
	

}
