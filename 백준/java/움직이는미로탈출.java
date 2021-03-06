import java.io.*;
import java.util.*;

public class Main { 
	public static final int[] dx = {0,1,0,-1,0,1,-1,-1,1}; 
	public static final int[] dy = {0,0,1,0,-1,1,1,-1,-1}; 
	public static int ans; 
	public static char[][] board; 
	public static Queue<Pos> q;
	
	static class Pos{ 
		int x,y; 
		public Pos(int x, int y) 
		{ 
			this.x=x; 
			this.y=y; 
		} 
	}
	
	public static void move() { 
		for (int i=7; i>=0; i--) { 
			for (int j=7; j>=0; j--) { 
				if(i-1<0) 
					board[i][j]='.'; 
				else board[i][j]=board[i-1][j]; 
			}
		} 
	} 
	
	public static boolean bfs() { 
		q.add(new Pos(7,0)); 
		
		while(!q.isEmpty()) { 
			int size = q.size(); 
			for (int i=0; i<size; i++) { 
				Pos pos = q.poll();
				
				if(board[pos.x][pos.y] == '#') 
					continue;
				
				for(int idx=0; idx<9; idx++) { 
					int nx = pos.x + dx[idx]; 
					int ny = pos.y + dy[idx]; 
					
					if(nx==0 && ny==7)
						return true;
					if(0<=nx && nx<8 && 0<=ny && ny<8) {
						if(board[nx][ny] != '#') { 
							q.add(new Pos(nx,ny)); 
						}
					}
				} 
			} 
			move(); 
		}
		return false; 
	} 
	
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new char[8][8]; 
		q = new LinkedList<>(); 
		
		for(int i=0; i<8; i++) { 
			String data = br.readLine();
			for (int j=0; j<8; j++) {
				board[i][j] = data.charAt(j);
			} 
		} 
		
		boolean flag = bfs();
		if(flag)
			System.out.println(1);
		else
			System.out.println(0); 
	} 
}