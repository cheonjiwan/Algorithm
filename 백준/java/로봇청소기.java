import java.io.*;
import java.util.*;
public class Main {
    static int w,h;
    static char map [][];
    static int dust=0;
    static boolean dfs_visited[];
    static int tmp[];
    static int dist[][];
    static int start_x, start_y;
    static int min =Integer.MAX_VALUE;
    
    static int dx[] = {-1,0,1,0}; static int dy[] = {0,-1,0,1};
    static ArrayList<Node> list = new ArrayList<>();
    static class Node{
    	int x,y;
    	Node(int x,int y){
    		this.x=x;
    		this.y=y;
    	}
    }
    public static boolean isPossible(int x, int y) {
        int copy_map [][] = new int[h][w];
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                copy_map[i][j] = map[i][j];
            }
        }
        
        boolean[][] visited = new boolean[h][w];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        
        while(!q.isEmpty()) {
            Node a = q.poll();
            for(int i=0; i<4; i++) {
                int nx = a.x+dx[i];
                int ny = a.y+dy[i];
                if(nx>=0 && ny>=0 && nx<h && ny<w) {
                    if(!visited[nx][ny] && copy_map[nx][ny]!='x') {
                        visited[nx][ny] = true;
                        copy_map[nx][ny]='.';
                        q.add(new Node(nx,ny));
                    }
                }
            }
        }
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(copy_map[i][j]=='*')
                    return false;
            }
        }
        return true;
    }
    
    public static int[][] bfs(Node o) {
        int[][] temp = new int[h][w];
        boolean visited[][] = new boolean[h][w];
        Queue<Node>q = new LinkedList<>();
        q.add(o);
        while(!q.isEmpty()) {
            Node a = q.poll();
            for(int i=0; i<4; i++) {
                int nx = a.x+dx[i];
                int ny = a.y+dy[i];
                if(nx>=0 && ny>=0 && nx<h && ny<w) {
                    if(!visited[nx][ny]&& map[nx][ny]!='x') {
                        visited[nx][ny] = true;
                        q.add(new Node(nx,ny));
                        temp[nx][ny] = temp[a.x][a.y]+1;
                    }
                }
            }
        }
        return temp ;
    }
    
    public static void dfs(int level) {
        if(level == list.size()) {
            int sum =0;
            int left=0;
            int right=1;
            while(right!=level) {
                sum+=dist[tmp[left]][tmp[right]];
                left++;
                right++;
            }
            min = Math.min(min, sum);
            return ;
        }
        for(int i=1; i<list.size(); i++) {
            if(!dfs_visited[i]) {
                dfs_visited[i] = true;
                tmp[level]=i;
                dfs(level+1);
                dfs_visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            min =  Integer.MAX_VALUE;
            dust=0;
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0) {
                break;
            }
            
            map = new char[h][w];
            for(int i=0; i<h;i ++) {
                String data = br.readLine();
                for(int j=0; j<w; j++) {
                    map[i][j] = data.charAt(j);
                    if(map[i][j]=='o') {
                        start_x=i; start_y=j;
                        list.add(new Node(i,j));
                    }
                }
            }
            for(int i=0; i<h; i++) {
            	for(int j=0; j<w; j++) {
            		if(map[i][j]=='*') {
                    	dust++;
                        list.add(new Node(i,j));
                    }
            	}
            }
            
            if(!isPossible(start_x,start_y)) {
                System.out.println(-1);
            }
            else {
	            dist = new int[dust+1][dust+1];
	            for(int i=0; i<list.size(); i++) {
	                int temp[][] = bfs(list.get(i));
	                for(int j=i+1; j<list.size(); j++) {
	                    dist[i][j] = temp[list.get(j).x][list.get(j).y];
	                    dist[j][i] = temp[list.get(j).x][list.get(j).y];
	                }
	            }
	            
	            tmp = new int[dust+1];
	            tmp[0]=0;
	            dfs_visited = new boolean[dust+1];
	            dfs_visited[0] = true;
	            dfs(1);
	            System.out.println(min);
            }
            list.clear();
        }
    }
}