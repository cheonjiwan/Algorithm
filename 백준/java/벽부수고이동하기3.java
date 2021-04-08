import java.io.*;
import java.util.*;

public class Main {
   
   static int n,m,k;
   static int[][] board;
   static int[][][][] visited;
   static int[] dx = {-1,0,1,0}; static int[] dy = {0,-1,0,1};
   static int ans=-1;
   
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       
       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());
       k = Integer.parseInt(st.nextToken());
       
       board = new int[n+1][m+1];
       visited = new int[n+1][m+1][k+1][2];
       for(int i=1; i<=n; i++) {
          String data = br.readLine();
          for(int j=1; j<=m; j++) {
             board[i][j] = data.charAt(j-1)-'0';
          }
       }
       
       bfs();
       System.out.println(ans);
   }
   
   private static void bfs() {
	   int[][] wall = new int[n+1][m+1];
	   for(int i=1; i<=n; i++) {
		   Arrays.fill(wall[i], Integer.MAX_VALUE);
	   }
	   
	   Queue<Data> q = new LinkedList<>();
	   q.offer(new Data(1,1,0,1,true));
	   wall[1][1]=0;
	   while(!q.isEmpty()) {
		   Data cur = q.poll();
		   int x,y,cnt,dist;
		   boolean flag;
		   
		   x = cur.x;
		   y = cur.y;
		   cnt = cur.cnt;
		   dist = cur.dist;
		   flag = cur.flag;
		   
		   if(x==n && y==m) {
			   ans = dist;
			   return;
		   }
		   
		   for(int idx=0; idx<4; idx++) {
			   int nx = x + dx[idx];
			   int ny = y + dy[idx];
			   if(check(nx,ny)) {
				   if(wall[nx][ny]<=cnt)
					   continue;
				   if(board[nx][ny]==1) {
					   if(cnt<k) {
						   if(flag) { // day
							   wall[nx][ny]=cnt+1;
							   q.offer(new Data(nx,ny,cnt+1,dist+1,false));
						   }
						   else { // night
							   q.offer(new Data(x,y,cnt,dist+1,true));
						   }
					   }
				   }
				   else {
					   wall[nx][ny]=cnt;
					   if(flag)
						   q.offer(new Data(nx,ny,cnt,dist+1,false));
					   else
						   q.offer(new Data(nx,ny,cnt,dist+1,true));
				   }
			   }
		   }
	   }
   }
   
   
   private static boolean check(int nx, int ny) {
      if(1<=nx && nx<=n && 1<=ny && ny<=m)
         return true;
      return false;
   }
   
   static class Data{
      int x,y,cnt,dist;
      boolean flag;
      Data(int x, int y, int cnt, int dist, boolean flag){
    	  this.x=x;
    	  this.y=y;
    	  this.cnt=cnt;
    	  this.dist = dist;
    	  this.flag = flag;
      }
   }
}