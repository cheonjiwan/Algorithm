import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m,k;
	static int[][] board;
	static int[][] copy_board;
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,-1,-1,-1,0,1,1,1};
	static PriorityQueue<Tree> pq = new PriorityQueue<>();
	static ArrayList<Tree> aliveTree = new ArrayList<>();
	static ArrayList<Tree> deadTree = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	
    	board = new int[n+1][n+1];
    	copy_board = new int[n+1][n+1];
    	for(int i=1; i<=n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=1; j<=n; j++) {
    			int energy = Integer.parseInt(st.nextToken());
    			board[i][j] = 5;
    			copy_board[i][j] = energy;
    		}
    	}
    	
    	int x,y,z;
    	for(int i=0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
    		x = Integer.parseInt(st.nextToken());
    		y = Integer.parseInt(st.nextToken());
    		z = Integer.parseInt(st.nextToken());
    		
    		pq.offer(new Tree(x,y,z));
    	}
    	
    	solve();
    	System.out.println(pq.size());
	}
	
	private static void solve() {
		while(k-->0) {
			for(int year=0; year<4; year++) {
				season(year);
			}
		}
	}
	
	private static void season(int year) {
		switch(year) {
		case 0:
			while(!pq.isEmpty()) {
				Tree cur = pq.poll();
				int x = cur.x;
				int y = cur.y;
				int age = cur.age;
				if(age<=board[x][y]) {
					board[x][y]-=age;
					aliveTree.add(new Tree(x,y,age+1));
				}
				else
					deadTree.add(cur);
			}
			
			for(Tree cur : aliveTree) {
				pq.offer(cur);
			}
			aliveTree.clear();
			break;
		case 1:
			for(Tree cur : deadTree) {
				int x = cur.x;
				int y = cur.y;
				int age = cur.age;
				board[x][y]+=(int)age/2;
			}
			deadTree.clear();
			break;
		case 2:
			ArrayList<Tree> tmp = new ArrayList<>();
			while(!pq.isEmpty()) {
				Tree cur = pq.poll();
				int x = cur.x;
				int y = cur.y;
				int age = cur.age;
				if(age%5==0) {
					int nx,ny;
					for(int idx=0; idx<8; idx++) {
						nx = x + dx[idx];
						ny = y + dy[idx];
						if(check(nx,ny)) {
							tmp.add(new Tree(nx,ny,1));
						}
					}
					tmp.add(cur);
				}
				else {
					tmp.add(cur);
				}
			}
			for(Tree now : tmp) {
				pq.offer(now);
			}
			
			tmp.clear();
			break;
			
		case 3:
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					board[i][j] += copy_board[i][j];
				}
			}
			break;
		}
	}
	
	private static boolean check(int nx,int ny) {
		if(1<=nx && nx<=n && 1<=ny && ny<=n)
			return true;
		return false;
	}
	static class Tree implements Comparable<Tree>{
		int x,y,age;
		Tree(int x, int y, int age){
			this.x=x;
			this.y=y;
			this.age=age;
		}
		
		@Override
		public int compareTo(Main.Tree o) {
			return this.age-o.age;
		}
	}

}