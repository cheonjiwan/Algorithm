import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char board[][];
    static Key key[];
    static PriorityQueue<Edge> pq;
    static int parent[];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        
        key = new Key[m+1];
        board = new char[n][n];
        pq = new PriorityQueue<>();
        parent = new int[m+1];
        for(int i = 0; i <= m; i++)
            parent[i] = i;
        
        int keyIndex = 0;
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < n; j++) {
                board[i][j] = input.charAt(j);
                if(board[i][j] != '1' && board[i][j] != '0') {
                    key[keyIndex] = new Key(keyIndex, i, j);
                    keyIndex++;
                }
            }
        }
        for(int i = 0; i <= m; i++)
            getEdge(i);
        
        int weight = 0;
        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            
            if(find(now.v1) != find(now.v2)) {
                union(now.v1, now.v2);
                weight += now.weight;
            }
        }
        
        for(int i = 0; i <= m; i++) {
            if(find(i) != 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(weight);
    }
    
    public static void getEdge(int start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(key[start].x, key[start].y, 0));
        boolean visit[][] = new boolean[n][n];
        visit[key[start].x][key[start].y] = true;
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        
        while(!q.isEmpty()) {
            Point now = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if(check(nx, ny) && board[nx][ny] != '1' && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    //start or key
                    if(board[nx][ny] != '0') {
                        for(int j = 0; j <= m; j++) {
                            if(key[j].x == nx && key[j].y == ny) {
                                pq.offer(new Edge(key[start].number, j, now.count+1));
                                break;
                            }
                        }
                    }
                    q.offer(new Point(nx, ny, now.count+1));
                }
            }
        }
    }
    
    public static boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    
    public static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        
        if(p1 > p2)
            parent[p1] = p2;
        else
            parent[p2] = p1;
    }
    
    public static int find(int n) {
        if(parent[n] == n)
            return n;
        
        return parent[n] = find(parent[n]);
    }
    
    static class Key {
        int number, x, y;
        
        Key(int number, int x, int y) {
            this.number = number;
            this.x = x;
            this.y = y;
        }
    }
    
    static class Edge implements Comparable<Edge> {
        int v1, v2, weight;
        
        Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
        
        public int compareTo(Edge e) {
            return weight - e.weight;
        }
    }
    
    static class Point {
        int x, y, count;
        
        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}