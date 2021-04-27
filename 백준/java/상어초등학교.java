import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][]board;
    static ArrayList<Node> list=new ArrayList<>();
    static Set<Integer>[] set;
    static int[] dx = {-1,0,1,0}; static int[] dy = {0,-1,0,1};   
    static int []point={0,1,10,100,1000};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        board=new int[n+1][n+1];
        set=new HashSet[n*n+1];
        for(int i=0;i<=n*n;i++){
            set[i]=new HashSet<>();
        }
        
        for(int i=1;i<=n*n;i++){
            st = new StringTokenizer(br.readLine());
            int id=Integer.parseInt(st.nextToken());
            list.clear();
            for(int j=0;j<4;j++){
                set[id].add(Integer.parseInt(st.nextToken()));
            }
            find(id);
        }
        System.out.println(result());
    }

    static private void find(int id){
        for(int x=1;x<=n;x++){
            for(int y=1;y<=n;y++){
            	if(board[x][y]==0) {
            		Node now = new Node(x,y);
                    for(int idx=0;idx<4;idx++){
                        int nx=x+dx[idx];
                        int ny=y+dy[idx];
                        if(check(nx,ny)){
                        	if(set[id].contains(board[nx][ny])){
                                now.like++;
                            }else if(board[nx][ny]==0){
                                now.empty++;
                            }
                        }
                    }
                    list.add(now);
            	}
            }
        }

        Collections.sort(list);
        Node here=list.get(0);
        board[here.x][here.y]=id;
    }
    
    static private int result(){
        int score=0;
        for(int x=1;x<=n;x++){
            for(int y=1;y<=n;y++){
                int id=board[x][y];
                int cnt=0;
                for(int idx=0;idx<4;idx++){
                    int nx=x+dx[idx];
                    int ny=y+dy[idx];
                    if(check(nx,ny)) {
                    	if(set[id].contains(board[nx][ny])){
                            cnt++;
                        }
                    }
                }
                score+=point[cnt];
            }
        }
        return score;
    }
    
    static private boolean check(int nx, int ny) {
    	if(1<=nx && nx<=n && 1<=ny && ny<=n)
    		return true;
    	return false;
    }
    
    static class Node implements Comparable<Node>{
        int x,y;
        int like;
        int empty;
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public int compareTo(Main.Node o) {
        	if(o.like-this.like==0) {
        		if(o.empty-this.empty==0) {
        			if(this.x-o.x==0)
        				return this.y-o.y;
        			else
        				return this.x-o.x;
        		}
        		else
        			return o.empty-this.empty;
        	}
        	else
        		return o.like-this.like;
        }
    }
}