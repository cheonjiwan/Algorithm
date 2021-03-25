import java.io.*;
import java.util.*;

public class Main {
	
	static int k;
	static int[] data;
	static ArrayList<Integer> list = new ArrayList<>();
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	while(true) {
    		String input = br.readLine();
    		if(input.equals("0"))
    			break;
    		
    		st = new StringTokenizer(input);
    		k = Integer.parseInt(st.nextToken());
    		visited = new boolean[50];
    		data = new int[k+1];
    		for(int i=1; i<=k; i++) {
    			data[i] = Integer.parseInt(st.nextToken());
    		}
    		
    		solution(0);
    		System.out.println();
    	}
	}
	
	private static void solution(int depth) {
		if(depth==6)
		{
			StringBuilder sb = new StringBuilder();
			for(int num : list) {
				sb.append(num).append(" ");
			}
			
			System.out.println(sb.toString());
			return;
		}
		
		for(int i=1; i<=k; i++) {
			if(!visited[data[i]]) {
				visited[data[i]]=true;
				if(list.size()==0) {
					list.add(data[i]);
					solution(depth+1);
					list.remove(list.size()-1);
				}
				else if(list.get(list.size()-1)<data[i]) {
					list.add(data[i]);
					solution(depth+1);
					list.remove(list.size()-1);
				}
				visited[data[i]]=false;
			}
		}
		
		
	}

}