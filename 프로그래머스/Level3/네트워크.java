import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j)
                    continue;
                if(computers[i][j]==1){
                    graph[i+1].add(j+1);
                    graph[j+1].add(i+1);
                }
            }
        }
        
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            if(!visited[i])
                answer+=bfs(i,n);
        }
        return answer;
    }
    
    private int bfs(int start,int n){
        visited[start]=true;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        
        int cnt=1;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : graph[cur]){
                if(!visited[next])
                {
                    visited[next]=true;
                    q.offer(next);
                }
            }
        }
        return cnt;
    }
}
