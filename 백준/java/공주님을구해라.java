import java.io.*;
import java.util.*;

public class Main {

	static int n,m,t,gx,gy;
	static int[][] board;
	static boolean[][][] visited;
	static int[] dx = {-1,0,1,0}; static int[] dy = {0,-1,0,1};
	
	static class Pos{
		int x,y,time;
		int flag;
		Pos(int x,int y,int time,int flag){
			this.x=x;
			this.y=y;
			this.time=time;
			this.flag=flag;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		board = new int[n+1][m+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; j++) {
				int num = Integer.parseInt(st.nextToken());
				board[i][j] = num;
				if(num==2) {
					gx=i;
					gy=j;
				}
			}
		}
		
		bfs();
	}
	
	private static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(1,1,0,0));
		visited = new boolean[2][n+1][m+1];
		visited[0][1][1]=true;
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			int nx,ny,x,y,time;
			int flag;
			x = cur.x;
			y = cur.y;
			time = cur.time;
			flag = cur.flag;
			if(time>t) {
				System.out.println("Fail");
				return;
			}
			if(x==n && y==m) {
				System.out.println(time);
				return;
			}
				
			for(int idx=0; idx<4; idx++) {
				nx = x+dx[idx];
				ny = y+dy[idx];
				if(check(nx,ny) && !visited[flag][nx][ny]) {
					if(flag==0) {
						if(board[nx][ny]==1) continue;
						if(board[nx][ny]==2) {
							q.offer(new Pos(nx,ny,time+1,1));
							visited[flag][nx][ny]=true;
						}
						else {
							q.offer(new Pos(nx,ny,time+1,0));
							visited[flag][nx][ny]=true;
						}
					}
					else {
						visited[flag][nx][ny]=true;
						q.offer(new Pos(nx,ny,time+1,1));
					}
						
				}
			}
		}
		System.out.println("Fail");
	}
	
	private static boolean check(int nx,int ny) {
		if(1<=nx && nx<=n && 1<=ny && ny<=m)
			return true;
		return false;
	}
	
}
