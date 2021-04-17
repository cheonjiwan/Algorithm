import java.util.*;

class Solution {
	
	public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] distance = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
        	Arrays.fill(distance[i], 1000000);
        	distance[i][i]=0;
        }
        
        for(int[] fare : fares) {
        	int start,end,cost;
        	start = fare[0];
        	end = fare[1];
        	cost = fare[2];
        	
        	distance[start][end]=cost;
        	distance[end][start]=cost;
        }
        
        for(int k=1; k<=n; k++) {
        	for(int i=1; i<=n; i++) {
        		for(int j=1; j<=n; j++) {
        			distance[i][j] = Math.min(distance[i][j], distance[i][k]+distance[k][j]);
        		}
        	}
        }
        
        answer = distance[s][a]+distance[s][b];
        for(int i=1; i<=n; i++) {
        	answer = Math.min(answer, distance[s][i]+distance[i][a]+distance[i][b]);
        }
        return answer;
    }
}

public class Main {
	public static void main(String[] args){
		
		Solution solution = new Solution();
		int n=7;
		int s=3;
		int a=4;
		int b=1;
		int[][] fares = {{5,7,9},{4,6,4},{3,6,1},{3,2,3},{2,1,6}};
		
		System.out.println(solution.solution(n,s,a,b,fares));
		
	}
}