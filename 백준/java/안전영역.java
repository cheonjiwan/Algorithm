import java.io.*;
import java.util.*;

public class Main { 
	
	static int n;
	static int[][] board;
	static int[] dx = {-1,0,1,0}; static int[] dy = {0,-1,0,1};
	static class Pos{
		int x,y;
		Pos(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static int find_safe(int[][] copy_board) {
		Queue<Pos> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];
		
		int cnt=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(copy_board[i][j]!=-1 && !visited[i][j]) {
					
					q.offer(new Pos(i,j));
					visited[i][j]=true;
					cnt++;
					while(!q.isEmpty()) {
						Pos cur = q.poll();
						int x,y;
						x=cur.x;
						y=cur.y;
						
						int nx,ny;
						for(int idx=0; idx<4; idx++) {
							nx = x+dx[idx];
							ny = y+dy[idx];
							if(0<=nx && nx<n && 0<=ny && ny<n && !visited[nx][ny] && copy_board[nx][ny]!=-1) {
								visited[nx][ny]=true;
								q.offer(new Pos(nx,ny));
							}
						}
					}
				}
			}
		}
		
		return cnt;
		
	}
	
	public static int rain(int height) {
		int[][] copy_board = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(height>=board[i][j])
					copy_board[i][j] = -1;
				else
					copy_board[i][j]=board[i][j];
			}
		}
		
		return find_safe(copy_board);
	}
	
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		board = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int num = Integer.parseInt(st.nextToken());
				max = Math.max(num, max);
				board[i][j] = num;
			}
		}
		
		int ans=Integer.MIN_VALUE;
		for(int i=0; i<=max; i++)
			ans = Math.max(rain(i),ans);
		
		System.out.println(ans);
	}
}