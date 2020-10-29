import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int[][] board;
	static int N,Q,size;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	public static void rotate(int L) {
		int split = size/(int)Math.pow(2, L);
		int[][] rotated_board = new int[size][size];
		
		int x=0;
		for(int i=0; i<split; i++) {
			int y=0;
			if(i!=0) {
				x += (int)Math.pow(2, L);
			}
			for(int j=0; j<split; j++) {
				if(j!=0) {
					y+=(int)Math.pow(2, L);
				}
				for(int a=0; a<(int)Math.pow(2, L); a++)
				{
					for(int b=0; b<(int)Math.pow(2, L); b++)
					{
						rotated_board[x+b][y+(int)Math.pow(2, L)-a-1] = board[x+a][y+b];
					}
				}
			}
		}
		
		board = rotated_board;
		
	}
	
	public static void ice() {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		int count=0;
		
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++) {
				count=0;
				for(int idx=0; idx<4; idx++) 
				{
					int nx = i+dx[idx];
					int ny = j+dy[idx];
					
					if(0<=nx && nx<size && 0<=ny && ny<size) {
						if(board[nx][ny]>0)
						{
							count++;
						}
					}
				}
				if(count<3) {
					qx.add(i);
					qy.add(j);
				}
				
			}
		}
		
		while(!qx.isEmpty()) {
			int x = qx.poll();
			int y =qy.poll();
			board[x][y]-=1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		size = (int) Math.pow(2, N);
		board = new int[size][size];
		for(int i=0; i<size; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<size; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] L_board = new int[Q];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<Q; i++) {
			int L = Integer.parseInt(st.nextToken());
			rotate(L);
			ice();
		}
		
		boolean[][] visited = new boolean[size][size];
		Queue<Point> point_q = new LinkedList<>();
		
		for(int i=0; i<size; i++)
		{
			Arrays.fill(visited[i], false);
		}
		int result=0;
		int cnt = 0;
		int maxCnt = -9999;
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				if(board[i][j]>0 && !visited[i][j])
				{
					result+=board[i][j];
					visited[i][j] = true;
					cnt+=1;
					point_q.add(new Point(i,j));
					while(!point_q.isEmpty())
					{
						Point tmp = point_q.poll();
						int x = tmp.x;
						int y = tmp.y;
						for(int k=0; k<4; k++)
						{
							int nx = x + dx[k];
							int ny = y + dy[k];
							if(0<=nx && nx<size && 0<=ny && ny<size)
							{
								if(board[nx][ny]>0 && !visited[nx][ny])
								{
									result+=board[nx][ny];
									cnt+=1;
									point_q.add(new Point(nx,ny));
									visited[nx][ny]=true;
								}
								
							}
						}
					}
				}
				maxCnt = Math.max(maxCnt, cnt);
				cnt=0;
				
			}
		}
		
		System.out.println(result);
		System.out.println(maxCnt);
		
	}

}
