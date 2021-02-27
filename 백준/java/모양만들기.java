import java.io.*;
import java.util.*;

public class Main {

	static int n,m;
	static Data[][] board;
	static boolean[][] visited;
	static boolean[] flag;
	static int[] dx = {-1,0,1,0}; static int[] dy = {0,-1,0,1};
	
	static class Data{
		int what;
		int com;
		Data(int what,int com){
			this.what=what;
			this.com=com;
		}
	}
	
	static class Pos{
		int x,y;
		Pos(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static class Pos2{
		int x,y,com;
		Pos2(int x,int y,int com){
			this.x=x;
			this.y=y;
			this.com=com;
		}
	}
	
	public static boolean check(int nx,int ny) {
		if(0<=nx && nx<n && 0<=ny && ny<m)
			return true;
		return false;			
	}
	
	public static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(0,0));
		
		visited = new boolean[n][m];
		
		ArrayList<Pos2> p;
		int size=Integer.MIN_VALUE;
		int cnt=0;
		int component=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(board[i][j].what==1 && !visited[i][j]) {
					p = new ArrayList<>();
					component++;
					p.add(new Pos2(i,j,component));
					cnt=1;
					
					visited[i][j]=true;
					q.offer(new Pos(i,j));
					
					int x,y,nx,ny;
					while(!q.isEmpty()) {
						Pos now = q.poll();
						x = now.x; y = now.y;
						for(int idx=0; idx<4; idx++) {
							nx = x + dx[idx];
							ny = y + dy[idx];
							if(check(nx,ny) && board[nx][ny].what==1 && !visited[nx][ny]) {
								visited[nx][ny]=true;
								q.offer(new Pos(nx,ny));
								cnt++;
								p.add(new Pos2(nx,ny,component));
							}
						}
					}
					for(Pos2 tmp : p) {
						board[tmp.x][tmp.y].what=cnt;
						board[tmp.x][tmp.y].com=component;
						
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		ArrayList<Pos> zero = new ArrayList<>();
		
		board = new Data[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==0)
					zero.add(new Pos(i,j));
				board[i][j]=new Data(num,0);
			}
		}
		bfs();
		
		flag = new boolean[500001];
		ArrayList<Pos> changeList = new ArrayList<>();
		int ans = Integer.MIN_VALUE;
		for(Pos now : zero) {	
			int x = now.x;
			int y = now.y;
			
			int sum=1;
			int nx,ny;
			for(int idx=0; idx<4; idx++) {
				nx = x+dx[idx];
				ny = y+dy[idx];
				if(check(nx,ny)) {
					if(board[nx][ny].what!=0 && !flag[board[nx][ny].com]) {
						sum+=board[nx][ny].what;
						flag[board[nx][ny].com]=true;
						changeList.add(new Pos(nx,ny));
					}
				}
			}
			ans = Math.max(ans, sum);
			for(Pos change : changeList) {
				flag[board[change.x][change.y].com]=false;
			}
			changeList.clear();
		}
		System.out.println(ans);	
	}

}
