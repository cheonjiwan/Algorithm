import java.io.*;
import java.util.*;

import com.sun.jdi.connect.VMStartException;
public class Main {
    
	static ArrayList<Integer>[] tree;
	static int n;
	static boolean[] visited;
	static int[] parent;
	
	public static int bfs(int remove) {
		
		int cnt=0;
		if(visited[remove]) 
			return 0;
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(remove);
		visited[remove]=true;
		while(!q.isEmpty()) {
			remove = q.poll();
			
			boolean flag = false;
			for(int nextNode : tree[remove]) {
				if(!visited[nextNode] && parent[remove]!=nextNode) {
					flag=true;
					q.offer(nextNode);
					visited[nextNode]=true;
				}
			}
			if(!flag)
				cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        parent = new int[n];
        tree = new ArrayList[n];
        visited = new boolean[n];
        for(int i=0; i<n; i++)
        	tree[i] = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	parent[i]=Integer.parseInt(st.nextToken());
        }
        
        int root=0;
        for(int i=0; i<n; i++) {
        	int v = parent[i];
        	if(v==-1) {
        		root=i;
        		continue;
        	}
        	tree[v].add(i);
        	tree[i].add(v);
        }
        
        int remove_node = Integer.parseInt(br.readLine());
        bfs(remove_node);
        System.out.println(bfs(root));
    }
}