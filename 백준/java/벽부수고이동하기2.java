import java.io.*;
import java.util.*;

public class Main {

	static int n,m,k;
	static int[][] board;
	static boolean[][][] visited;
	static int[] dx = {-1,0,1,0}; static int[] dy = {0,-1,0,1};
	static int ans=-1;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	
    	board = new int[n+1][m+1];
    	visited = new boolean[n+1][m+1][k+1];
    	for(int i=1; i<=n; i++) {
    		String data = br.readLine();
    		for(int j=1; j<=m; j++) {
    			board[i][j] = data.charAt(j-1)-'0';
    		}
    	}
    	
    	bfs();
    	System.out.println(ans);
	}
	
	private static void bfs() {
		PriorityQueue<Data> pq = new PriorityQueue<>();
		visited[1][1][0]=true;
		pq.offer(new Data(1,1,1,0));
		
		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			int x,y,dist,cnt;
			x = cur.x;
			y = cur.y;
			dist = cur.dist;
			cnt = cur.cnt;
			if(x==n && y==m) {
				ans = dist;
				return;
			}
			
			for(int idx=0; idx<4; idx++) {
				int nx = x + dx[idx];
				int ny = y + dy[idx];
				if(check(nx,ny)) {
					if(board[nx][ny]==0 && !visited[nx][ny][cnt]) {
						visited[nx][ny][cnt]=true;
						pq.offer(new Data(nx,ny,dist+1,cnt));
					}
					else if(board[nx][ny]==1 && cnt+1<=k && !visited[nx][ny][cnt+1]) {
						visited[nx][ny][cnt+1]=true;
						pq.offer(new Data(nx,ny,dist+1,cnt+1));
					}
				}
			}
		}
	}
	
	private static boolean check(int nx, int ny) {
		if(1<=nx && nx<=n && 1<=ny && ny<=m)
			return true;
		return false;
	}
	
	static class Data implements Comparable<Data>{
		int x,y,dist,cnt;
		Data(int x, int y,int dist,int cnt){
			this.x=x;
			this.y=y;
			this.dist=dist;
			this.cnt=cnt;
		}
		
		@Override
		public int compareTo(Main.Data o) {
			return this.dist - o.dist;
		}
	}
	
}