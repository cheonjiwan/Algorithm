import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static int[][] board,ans;
	static boolean[][] visited;
	static int sx,sy;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	board = new int[n][m];
    	visited = new boolean[n][m];
    	ans = new int[n][m];
    	for(int i=0; i<n; i++) {
    		Arrays.fill(ans[i], -1);
    	}
    	
    	for(int i=0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<m; j++) {
    			int cur = Integer.parseInt(st.nextToken());
    			board[i][j] = cur;
    			if(cur==2) {
    				ans[i][j]=0;
    				sx=i;sy=j;
    			}
    			else if(cur==0) {
    				ans[i][j]=0;
    			}
    		}
    	}
    	
    	bfs(sx,sy);
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			sb.append(ans[i][j]).append(" ");
    		}
    		sb.append('\n');
    	}
    	
    	System.out.println(sb.toString());
	}
	
	private static void bfs(int sx, int sy) {
		Queue<Pos> q = new LinkedList<>();
		visited[sx][sy]=true;
		q.offer(new Pos(sx,sy,0));
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			int x,y,cnt;
			x = cur.x;
			y = cur.y;
			cnt = cur.cnt;
			
			int nx,ny;
			for(int idx=0; idx<4; idx++) {
				nx = x+dx[idx];
				ny = y+dy[idx];
				
				if(check(nx,ny) && board[nx][ny]!=0 && !visited[nx][ny]) {
					visited[nx][ny]=true;
					ans[nx][ny]=cnt+1;
					q.offer(new Pos(nx,ny,cnt+1));
				}
			}
		}
	}
	
	private static boolean check(int nx, int ny) {
		if(0<=nx && nx<n && 0<=ny && ny<m)
			return true;
		return false;
	}
	
	static class Pos{
		int x,y,cnt;
		Pos(int x,int y,int cnt){
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
	}
	
}