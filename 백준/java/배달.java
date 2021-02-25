import java.io.*;
import java.util.*;

public class Main {

	static int n,m;
	static char[][] board;
	static boolean[][][][][] visited;
	static int[] dx = {-1,0,1,0}; static int[] dy = {0,-1,0,1};
	static class Pos{
		int x,y,dir,time;
		int find1,find2;
		Pos(int x,int y,int dir,int time, int find1, int find2){
			this.x=x;
			this.y=y;
			this.dir=dir;
			this.time=time;
			this.find1=find1;
			this.find2=find2;
		}
	}
	
	public static int bfs(int sx, int sy) {
		visited = new boolean[2][2][4][n][m];
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(sx,sy,-1,0,0,0));
		
		int x,y,dir,time=0;
		int find1,find2;
		int nx,ny,nfind1,nfind2;
		
		while(!q.isEmpty()) {
			Pos now=q.poll();
			x=now.x; y=now.y;
			dir=now.dir;
			time=now.time;
			find1=now.find1;
			find2=now.find2;
			
			if(find1==1 && find2==1) {
				return time;
			}
			
			for(int idx=0; idx<4; idx++) {
				nx=x+dx[idx]; ny=y+dy[idx];
				nfind1=find1;
				nfind2=find2;
				if(0<=nx && nx<n && 0<=ny && ny<m && board[nx][ny]!='#' && idx!=dir) {
					if(board[nx][ny]!='#' && !visited[nfind1][nfind2][idx][nx][ny]) {
						if(board[nx][ny]=='1')
							nfind1=1;
						if(board[nx][ny]=='2')
							nfind2=1;
						
						visited[nfind1][nfind2][idx][nx][ny]=true;
						q.offer(new Pos(nx,ny,idx,time+1,nfind1,nfind2));
					}
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new char[n][m];
		
		int sx=0,sy=0;
		int desCnt=0;
		for(int i=0; i<n; i++) {
			String data = br.readLine();
			for(int j=0; j<m; j++) {
				if(data.charAt(j)=='S'){
					sx=i; sy=j;
					board[i][j]=data.charAt(j);
				}
				else if(data.charAt(j)=='C') {
					if(desCnt==0) {
						board[i][j]='1';
						desCnt++;
					}
					else
						board[i][j]='2';
				}
				else
					board[i][j] = data.charAt(j);
			}
		}
		
		System.out.println(bfs(sx,sy));
	}

}
