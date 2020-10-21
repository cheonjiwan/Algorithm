package samsung;

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
	
	public static int direction(int dir) {
		return (dir+1)%4;
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
		int dir = 0;
		int alpha = 1;
		int nx=0,ny=0;
		
		while(alpha<n) {
			int sand = board[t_x][t_y];
			for(int idx=0; idx<2; idx++) 
			{
				int cost = 0;
				switch (dir) {
					case 0:
						cost = board[t_x][t_y+(alpha*(-1))];
						board[t_x][t_y+(alpha*(-1))]=0;
						break;
					case 1:
						cost = board[t_x+(alpha)][t_y];
						board[t_x+(alpha)][t_y]=0;
						break;
					case 2:
						cost = board[t_x][t_y+(alpha)];
						board[t_x][t_y+(alpha)]=0;
						break;
					case 3:
						cost = board[t_x+(alpha*(-1))][t_y];
						board[t_x+(alpha*(-1))][t_y]=0;
						break;
					default:
						break;
				}
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
				
				
				switch (dir) {
					case 0:
						t_y = t_y+(alpha*(-1));
						break;
					case 1:
						t_x = t_x+(alpha);
						break;
					case 2:
						t_y = t_y+alpha;
						break;
					case 3:
						t_x = t_x+(alpha*(-1));
						break;
					default:
						break;
				}
				dir = direction(dir);
			}
			
			alpha+=1;
			
		}
		int cost = 0;
		
		cost = board[0][0];
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
		System.out.println(result);
		
	}

}
