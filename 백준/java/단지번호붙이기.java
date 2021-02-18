import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] board;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean[][] visited;
	static ArrayList<Integer> result = new ArrayList<>();
	static class Pos{
		int x;
		int y;
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static int bfs() {
		Queue<Pos> q = new LinkedList<>();
		visited = new boolean[n][n];
		int group=0,cnt;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(board[i][j]==1 && !visited[i][j]) {
					q.offer(new Pos(i,j));
					visited[i][j]=true;
					group+=1;
					cnt=1;
					int nx,ny;
					while(!q.isEmpty()) {
						Pos now = q.poll();
						for(int idx=0; idx<4; idx++) {
							nx = now.x+dx[idx];
							ny = now.y+dy[idx];
							if(0<=nx && nx<n && 0<=ny && ny<n && !visited[nx][ny] && board[nx][ny]==1) {
								q.offer(new Pos(nx,ny));
								visited[nx][ny]=true;
								cnt+=1;
							}
						}
					}
					result.add(cnt);
				}
			}
		}
		
		return group;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n=Integer.parseInt(br.readLine());
		board = new int[n][n];
		for(int i=0; i<n; i++) {
			String data = br.readLine();
			for(int j=0; j<n; j++) {
				board[i][j] = data.charAt(j)-'0';
			}
		}
		
		System.out.println(bfs());
		Collections.sort(result);
		for(int num : result) {
			System.out.println(num);
		}
		
	}

}
