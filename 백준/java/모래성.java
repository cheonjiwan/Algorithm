import java.io.*;
import java.util.*;

public class Main {
	
	static int h,w;
	static int board[][];
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,-1,-1,-1,0,1,1,1};
	static int cnt=0;
	static boolean[][] visited;
	static Queue<Pos> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		board = new int[h][w];
		for(int i=0; i<h; i++) {
			String data = br.readLine();
			for(int j=0; j<w; j++) {
				char ch = data.charAt(j);
				if(ch=='.') {
					q.offer(new Pos(i,j));
					board[i][j]=0;
				}
				else
					board[i][j] = ch-'0';
			}
		}
		bfs();
		System.out.println(cnt);
	}
	
	private static void bfs() {
		while(true) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				Pos cur = q.poll();
				int x,y;
				x = cur.x; y = cur.y;
				for(int idx=0; idx<8; idx++) {
					int nx = x + dx[idx];
					int ny = y + dy[idx];
					if(check(nx,ny) && board[nx][ny]>0) {
						board[nx][ny]-=1;
						if(board[nx][ny]==0) {
							q.offer(new Pos(nx,ny));
						}
					}
				}
			}
			if(q.isEmpty()) 
				break;
			cnt++;
		}
	}
	
	private static boolean check(int nx, int ny) {
		if(0<=nx && nx<h && 0<=ny && ny<w)
			return true;
		return false;
	}
	
	static class Pos{
		int x,y;
		Pos(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
}