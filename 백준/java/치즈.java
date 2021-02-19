import java.io.*;
import java.util.*;

public class Main {
	
	static int r,c;
	static int[][] board;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int result;
	static boolean visited[][];
	
	
	static class Pos{
		int x;
		int y;
		Pos(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void find_out() {
		Queue<Pos> q = new LinkedList<>();
		boolean[][] check = new boolean[r][c];
		for(int i=0; i<r; i++) {
			Arrays.fill(check[i], false);
		}
		q.offer(new Pos(0,0));
		check[0][0]=true;
		int x,y,nx,ny;
		while(!q.isEmpty()) {
			Pos tmp = q.poll();
			x = tmp.x; y = tmp.y;
			for(int idx=0; idx<4; idx++) {
				nx = x+dx[idx]; ny = y + dy[idx];
				if(0<=nx && nx<r && 0<=ny && ny<c && !check[nx][ny] ) {
					if(board[nx][ny]==9) {
						q.offer(new Pos(nx,ny));
						check[nx][ny]=true;
					}
					else if(board[nx][ny]==0) {
						board[nx][ny]=9;
						q.offer(new Pos(nx,ny));
						check[nx][ny]=true;
					}
				}
			}
		}
	}
	
	public static boolean solve() {
		int nx,ny;
		
		boolean flag=false;

		find_out();
		Queue<Pos> melted = new LinkedList<>();
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(board[i][j]==1) {
					flag=true;
					int cnt=0;
					for(int idx=0; idx<4; idx++) {
						nx = i + dx[idx];
						ny = j + dy[idx];
						if(0<=nx && nx<r && 0<=ny && ny<c) {
							if(board[nx][ny]==9) {
								cnt+=1;
							}
						}
					}
					if(cnt>=1) {
						if(!visited[i][j])
							visited[i][j]=true;
							melted.add(new Pos(i,j));
					}
				}
			}
		}
		if(flag) {
			result = melted.size();
			while(!melted.isEmpty()) {
				Pos tmp = melted.poll();
				board[tmp.x][tmp.y]=9;
			}
		}
		
		return flag;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		board = new int[r][c];
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int time=0;
		visited = new boolean[r][c];
		while(true) {
			if(solve()) {
				time+=1;
			}
			else {
				System.out.println(time);
				System.out.println(result);
				break;
			}
		}
		
	}

}
