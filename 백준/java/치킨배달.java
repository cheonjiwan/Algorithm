import java.util.*;
import java.io.*;

public class Main
{	
	static int n,m;
	static boolean[] visited;
	static ArrayList<Pos> chicken = new ArrayList<>();
	static ArrayList<Pos> home = new ArrayList<>();
	static Stack<Pos> selected = new Stack<>();
	static Iterator<Pos> ite;
	static int ans=Integer.MAX_VALUE;
	
	public static void main(String args[]) throws IOException
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==2)
					chicken.add(new Pos(i,j));
				else if(num==1)
					home.add(new Pos(i,j));
			}
		}
		
		solve(0,0);
		System.out.println(ans);
    }
	
	private static void solve(int depth,int start) {
		if(depth==m) {
			int sum=0;
			for(Pos curHome : home) {
				int mindist=Integer.MAX_VALUE;
				
				ite = selected.iterator();
				while(ite.hasNext()) {
					Pos curChi = ite.next();
					mindist = Math.min(mindist, Math.abs(curChi.x-curHome.x)+Math.abs(curChi.y-curHome.y));
				}
				
				sum+=mindist;
				if(sum>ans)
					return;
			}
			
			ans = Math.min(ans, sum);
			return;
		}
		
		for(int i=start; i<chicken.size(); i++) {
			selected.push(chicken.get(i));
			solve(depth+1,i+1);
			selected.pop();
		}
	}
	
	static class Pos{
		int x,y;
		Pos(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
}