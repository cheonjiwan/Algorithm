import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static int[][] distance;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	distance = new int[n+1][n+1];
    	for(int i=1; i<=n; i++) {
    		Arrays.fill(distance[i], 987654321);
    	}
    	for(int i=1; i<=n; i++) {
    		distance[i][i]=0;
    	}
    	
    	int a,b;
    	for(int i=0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
    		a = Integer.parseInt(st.nextToken());
    		b = Integer.parseInt(st.nextToken());
    		distance[a][b]=1;
    		distance[b][a]=1;
    	}
    	
    	floyd();
    	int sum=0;
    	int result = Integer.MAX_VALUE;
    	ArrayList<Pos> list = new ArrayList<>();
    	
    	for(int i=1; i<=n; i++) {
    		for(int j=i+1; j<=n; j++) {
    			sum=0;
    			for(int idx=1; idx<=n; idx++) {
    				if(idx==i || idx==j) 
    					continue;
    				sum+=Math.min(distance[i][idx]*2, distance[j][idx]*2);
    			}
    			list.add(new Pos(i,j,sum));
    		}
    	}
    	Collections.sort(list);
    	StringBuilder sb = new StringBuilder();
    	sb.append(list.get(0).x).append(" ").append(list.get(0).y).append(" ").append(list.get(0).cost);
    	System.out.println(sb.toString());
	}
	
	private static void floyd() {
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					distance[i][j] = Math.min(distance[i][j],distance[i][k]+distance[k][j]);
				}
			}
		}
	}
	
	static class Pos implements Comparable<Pos>{
		int x,y,cost;
		Pos(int x,int y,int cost){
			this.x=x;
			this.y=y;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(Main.Pos o) {
			if(this.cost<o.cost) {
				return -1;
			}
			else if(this.cost==o.cost) {
				if(this.x<o.x) {
					return -1;
				}
				else if(this.x==o.x) {
					if(this.y<o.y) 
						return -1;
					else if(this.y==o.y)
						return 0;
					else return 1;
				}
				else
					return 1;
			}
			else
				return 1;
		}
	}
}