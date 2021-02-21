import java.io.*;
import java.util.*;

class Pos{
	int x,y;
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int n,m;
	static int[][] board;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void bfs(int h) {
		board[0][0]=h;
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(0,0));
		
		int x,y,nx,ny;
		while(!q.isEmpty()) {
			Pos tmp = q.poll();
			x = tmp.x; y = tmp.y;
			for(int i=0; i<4; i++) {
				nx=x+dx[i]; ny=y+dy[i];
				if(0<=nx && nx<=n+1 && 0<=ny && ny<=m+1 && board[nx][ny]<h) {
					board[nx][ny]=h;
					q.offer(new Pos(nx,ny));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n+2][m+2];
		
		String data;
		int maxV = Integer.MIN_VALUE;
		for(int i=1; i<=n; i++) {
			data = br.readLine();
			for(int j=0; j<m; j++) {
				board[i][j+1] = data.charAt(j)-'0';
				maxV = Math.max(maxV, data.charAt(j)-'0');
			}
		}
		
		int ans=0;
		for(int h=2; h<=maxV; h++) {
			bfs(h);
			
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=m; j++) {
					if(board[i][j]<h) {
						ans+=1;
						board[i][j]=h;
					}
				}
			}
		}
		
		System.out.println(ans);	
	}
}