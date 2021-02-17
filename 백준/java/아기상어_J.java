package babyshark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Temp{
	int x;
	int y;
	public Temp(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int n = 0;
	static int[][] board;
	static int now_size = 2;
	static int now_x,now_y = 0;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	public static int[][] bfs() {
		int[][] dist = new int[n][n];
		int s_x,s_y = 0;
		Queue<Temp> q = new LinkedList<>();
		for (int[] arr : dist) {
			Arrays.fill(arr, -1);
		}
		
		dist[now_x][now_y] = 0;
		q.add(new Temp(now_x,now_y));
		
		while(!q.isEmpty()) {
			Temp tmp = q.poll();
			s_x = tmp.x; s_y = tmp.y;
			for(int i=0; i<4; i++) {
				int nx = s_x + dx[i];
				int ny = s_y + dy[i];
				if(0<=nx && nx<n && 0<=ny && ny<n) {
					if(dist[nx][ny]==-1 && board[nx][ny]<=now_size) {
						dist[nx][ny] = dist[s_x][s_y]+1;
						q.add(new Temp(nx,ny));
					}
				}
			}
		}
		
		return dist;
	}
	
	public static int[] find(int[][] dist) {
		int[] arr = new int[3];
		int x = 0,y = 0;
		int minValue = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(dist[i][j]!=-1 && 1<=board[i][j] && board[i][j]<now_size) {
					if(minValue > dist[i][j]) {
						x=i; y=j;
						minValue = dist[i][j];
					}
				}
			}
		}
		
		if(minValue == Integer.MAX_VALUE) {
			return null;
		}
		else {
			arr[0] = x; 
			arr[1] = y; 
			arr[2] = minValue;
			return arr;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for (int j=0; j<n; j++)
			{
				if(board[i][j]==9) {
					board[i][j]=0;
					now_x = i;
					now_y = j;
				}
			}
		}
		
		int result = 0;
		int ate = 0;
		int value[];
		while(true) {
			value = find(bfs());
			
			if(value==null) {
				System.out.println(result);
				break;
			}
			else {
				now_x = value[0]; now_y = value[1]; result+=value[2];
				board[now_x][now_y]=0;
				ate+=1;
				
				if(ate>=now_size) {
					now_size+=1;
					ate=0;
				}
			}
		}
	}

}
