import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static char[][] board;
	static int[] parent;
	static int[] dx = {-1,0,1,0}; 
	static int[] dy = {0,-1,0,1};
	
	public static int find_parent(int x) {
		if(x!=parent[x]) {
			parent[x] = find_parent(parent[x]);
		}
		return parent[x];
	}
	
	public static void union(int a, int b) {
		int x = find_parent(a);
		int y = find_parent(b);
		
		if(x<y)
			parent[y] = x;
		else
			parent[x] = y;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new char[n][m];
		int[][] num = new int[n][m];
		
		int cur=1;
		for(int i=0; i<n; i++) {
			String data = br.readLine();
			for(int j=0; j<m; j++) {
				board[i][j] = data.charAt(j);
				num[i][j]=cur++;
			}
		}
		
		parent = new int[n*m+1];
		for(int i=1; i<=n*m; i++)
			parent[i] = i;

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				int nx=0,ny=0;
				switch (board[i][j]) {
				case 'U':
					nx = i+dx[0];
					ny = j+dy[0];
					break;
				case 'D':
					nx = i+dx[2];
					ny = j+dy[2];
					break;
				case 'L':
					nx = i+dx[1];
					ny = j+dy[1];
					break;
				case 'R':
					nx = i+dx[3];
					ny = j+dy[3];
					break;
				}
				union(num[i][j],num[nx][ny]);
			}
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i=1; i<=n*m; i++)
			set.add(find_parent(i));
		System.out.println(set.size());
	}
}