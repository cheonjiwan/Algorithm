import java.io.*;
import java.util.*;

class Solution {
   static ArrayList<Integer>[] graph;
   static int[] before,after;
   static boolean[] visited;
    public boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        
        graph = new ArrayList[n];
        before = new int[n];
        after = new int[n];
        visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        for(int[] row : path) {
           int cur = row[0], next = row[1];
           graph[cur].add(next);
           graph[next].add(cur);
        }
        
        for(int[] row : order) {
           int pre = row[0], next = row[1];
           before[next] = pre;
        }
        
        if(before[0]!=0)
        	return false;
        
        visited[0] = true;
        for(int next : graph[0])
           q.offer(next);
        
        while(!q.isEmpty()) {
           int cur = q.poll();
           
           if(visited[cur])
              continue;
           
           if(!visited[before[cur]]) {
              after[before[cur]] = cur;
              continue;
           }
           
           visited[cur]=true;
           before[cur]=0;
           for(int next : graph[cur]) {
              if(!visited[next])
                 q.offer(next);
           }
           q.offer(after[cur]);
        }
        for(int i=0; i<n; i++)
           if(!visited[i])
              return false;
        
        return true;
    }
}

public class Main {
   
   public static void main(String[] args){
      int n = 9;
      int[][] path = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
      int[][] order = {{4,1},{8,7},{6,5}};
      int[][] order2 = {{8,5},{6,7},{4,1}};
      System.out.println(new Solution().solution(n,path,order2));
   }
   
}