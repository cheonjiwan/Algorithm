import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m,h;
	static int[][] board;
	static int ans=4;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	h = Integer.parseInt(st.nextToken());
    	
    	board = new int[h+1][n+1];
    	for(int i=0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		board[a][b]=1;
    		board[a][b+1]=2;
    	}
    	
    	solution(1,0);
    	if(ans!=4)
    		System.out.println(ans);
    	else
    		System.out.println(-1);
	}
	
	private static void solution(int x, int cnt) {
		if(cnt>=ans)
			return;
		else {
			if(check()) {
				ans = cnt;
				return;
			}
		}
		
		for(int i=x; i<h+1; i++) {
			for(int j=1; j<n; j++) {
				if(board[i][j]==0 && board[i][j+1]==0) {
					board[i][j]=1;
					board[i][j+1]=2;
					solution(i,cnt+1);
					board[i][j]=0;
					board[i][j+1]=0;
				}
			}
		}
	}
	
	private static boolean check() {
		
		for(int i=1; i<=n; i++) {
			int x=1,y=i;
			for(int j=0; j<h; j++) {
				if(board[x][y]==1) {
					y++;
				}
				else if(board[x][y]==2) {
					y--;
				}
				x++;
			}
			if(y!=i)
				return false;
		}
		return true;
	}
	
}