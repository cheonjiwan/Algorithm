import java.io.*;
import java.util.*;
import java.util.*;
class Main {

	static int n,m;
	static int[][] board;
	static int[][] dp;
	static int[] dx = {-1,0,1,0}; static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		dp = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j]=-1;
			}
		}
		
		System.out.println(dfs(n-1,m-1));
	}
	
	private static int dfs(int x,int y) {
		if(x==0 && y==0)
			return 1;
		
		if(dp[x][y]==-1) {
			dp[x][y]=0;
			int nx,ny;
			for(int idx=0; idx<4; idx++) {
				nx = x+dx[idx];
				ny = y+dy[idx];
				if(check(nx,ny)) {
					if(board[x][y]<board[nx][ny])
						dp[x][y]+=dfs(nx,ny);
				}
			}
		}
		
		return dp[x][y];
	}
	
	private static boolean check(int nx, int ny) {
		if(0<=nx && nx<n && 0<=ny && ny<m)
			return true;
		return false;
	}
	
}