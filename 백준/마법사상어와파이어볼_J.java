package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Fireball{
	int r;
	int c;
	int m;
	int s;
	int d;
	public Fireball(int r, int c, int m, int s, int d) {
		super();
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}

}

public class Main {
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				board[i][j] = 0;
			}
		}
		
		Deque<Fireball> balls = new ArrayDeque<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			board[r-1][c-1] += 1;
			balls.add(new Fireball(r-1,c-1,m,s,d));
		}
		Deque<Fireball> tmpList = new ArrayDeque<>();
		
		for(int tmp=0; tmp<K; tmp++) 
		{
			int len = balls.size();
			for(int idx=0; idx<len; idx++) {
				Fireball ball = balls.removeFirst();
				
				int nx = (ball.r+ N + (dx[ball.d]*(ball.s%N)))%N;
//				if(nx<0)
//					nx+=N;
				int ny = (ball.c+ N + (dy[ball.d]*(ball.s%N)))%N;
//				if(ny<0)
//					ny+=N;
			
				board[ball.r][ball.c] -= 1;
				board[nx][ny]+=1;
				ball.r = nx;
				ball.c = ny;
				balls.addLast(ball);
			}
			
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++) {
					if(board[i][j]>=2) 
					{ // 파이어볼 2개 이상
						board[i][j]=0;
						len = balls.size();
						for(int tmpx = 0; tmpx<len; tmpx++) 
						{
							Fireball myball = balls.removeFirst();
							if(myball.r==i && myball.c==j)
							{
								tmpList.addLast(myball);
							}
							else {
								balls.addLast(myball);
//								board[i][j]+=1;
							}
						}
						int sumM = 0;
						int sumS = 0;
						int countOdd = 0, countEven=0;
						int size = tmpList.size();
						// 파이어볼 합치기
						while(!tmpList.isEmpty()) {
							Fireball mergeball = tmpList.removeFirst();
							sumM+=mergeball.m;
							sumS+=mergeball.s;
							if(mergeball.d % 2 ==0) {
								countEven+=1;
							}
							else {
								countOdd+=1;
							}
						}
						int newM = sumM/5;
						if(newM==0) continue;
						int newS = sumS/size;
						if(countEven==size || countOdd==size) {
							int newDir = 0;
							for(int potato=0; potato<4; potato++) {
								balls.add(new Fireball(i,j,newM,newS,newDir));
								newDir +=2;
								board[i][j]+=1;
							}
						}
						else {
							int newDir = 1;
							for(int potato=0; potato<4; potato++) {
								balls.add(new Fireball(i,j,newM,newS,newDir));
								newDir +=2;
								board[i][j]+=1;
							}
						}
					}
				}
			}
		}
		
		int result = 0;
		while(!balls.isEmpty()) {
			Fireball sumball = balls.removeFirst();
			result += sumball.m;
		}
		System.out.println(result);
	}
	

}
