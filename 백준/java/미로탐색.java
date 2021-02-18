package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static int[][] board;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static class Pos{
		int x;
		int y;
		Pos(int x,int y){
			this.x = x;
			this.y= y;
		}
	}
	
	public static int bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(0,0));
		
		int nx,ny;
		int cnt=0;
		while(!q.isEmpty()) {
			Pos tmp = q.poll();
			for(int i=0; i<4; i++) {
				nx = tmp.x+dx[i];
				ny = tmp.y+dy[i];
				if(0<=nx && nx<n && 0<=ny && ny<m) {
					if(board[nx][ny]==1) {
						board[nx][ny]=board[tmp.x][tmp.y]+1;
						q.offer(new Pos(nx,ny));
					}
				}	
			}
		}
		
		return board[n-1][m-1];
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		for(int i=0; i<n; i++) {
			String data = br.readLine();
			for(int j=0; j<m; j++) {
				board[i][j]=data.charAt(j)-'0';
			}
		}
		System.out.println(bfs());
		
	}

}
