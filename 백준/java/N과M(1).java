import java.io.*;
import java.util.*;

public class Main {

	static boolean[] visited;
	static int n,m;
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
      
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n+1];
		list = new ArrayList<>();
		solution(0, list);
	}
   
	private static void solution(int depth,ArrayList<Integer> list) {
	   if(depth==m){
		   StringBuilder sb = new StringBuilder();
		   for(int num : list) {
			   sb.append(num).append(" ");
		   }
		   System.out.println(sb.toString());
		   return;
	   }
	   
	   for(int i=1; i<=n; i++) {
		   if(!visited[i]){
			   visited[i]=true;
			   list.add(i);
			   solution(depth+1,list);
			   list.remove(list.size()-1);
			   visited[i]=false;
		   }
	   }
	}

}