import java.io.*;
import java.util.*;

public class Main {
	
	static int n,l,r;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0}; static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	l = Integer.parseInt(st.nextToken());
    	r = Integer.parseInt(st.nextToken());
    	
    	board = new int[n][n];
    	
    	for(int i=0; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<n; j++) {
    			board[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int cnt=0;
    	while(true) {
    		int group=0;
    		visited = new boolean[n][n];
    		for(int i=0; i<n; i++) {
    			for(int j=0; j<n; j++) {
    				if(!visited[i][j]) {
    					bfs(new Pos(i,j));
    					group++;
    				}
    			}
    		}
    		if(group==n*n) {
    			System.out.println(cnt);
    			break;
    		}
    		cnt++;
    	}
    	
	}
	
	private static void bfs(Pos data) {
		Queue<Pos> q = new LinkedList<>();
		visited[data.x][data.y]=true;
		
		q.offer(data);
		ArrayList<Pos> newgroup = new ArrayList<>();
		newgroup.add(data);
		
		int sum=board[data.x][data.y],cnt=1;
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			int x,y;
			x = cur.x;
			y = cur.y;
			
			int nx,ny;
			
			for(int idx=0; idx<4; idx++) {
				nx = x + dx[idx];
				ny = y + dy[idx];
				if(check(nx,ny) && !visited[nx][ny]) {
					int gap = Math.abs(board[x][y] - board[nx][ny]);
					if(gap>=l && gap<=r) {
						visited[nx][ny]=true;
						Pos newData = new Pos(nx,ny);
						newgroup.add(newData);
						q.offer(newData);
						cnt++;
						sum+=board[nx][ny];
					}
				}
			}
		}
		
		for(Pos country : newgroup) {
			int x,y;
			x = country.x;
			y = country.y;
			board[x][y] = (int)sum/cnt;
		}
		newgroup.clear();
	}
	
	private static boolean check(int nx, int ny) {
		if(0<=nx && nx<n && 0<=ny && ny<n)
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