import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m;
	static String[] name ;
	static HashMap<String,Integer> name2int = new HashMap<>();
	static int[] indegree;
	static Queue<Integer> q = new LinkedList<>();
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	n = Integer.parseInt(br.readLine());
    	indegree = new int[n];
    	name = new String[n];
    	graph = new ArrayList[n];
    	for(int i=0; i<n; i++) {
    		graph[i] = new ArrayList<>();
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<n; i++) {
    		name[i] = st.nextToken();
    	}
    	
    	Arrays.sort(name);
    	for(int i=0; i<n; i++) {
    		name2int.put(name[i], i);
    	}
    	
    	m = Integer.parseInt(br.readLine());
    	String a, b;
    	for(int i=0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
    		a = st.nextToken();
    		b = st.nextToken();
    		graph[name2int.get(b)].add(name2int.get(a));
    		indegree[name2int.get(a)]++;
    	}
    	
    	
    	ArrayList<Integer> root = new ArrayList<>();
    	for(int i=0; i<n; i++) {
    		if(indegree[i]==0) {
    			q.offer(i);
    			root.add(i);
    		}
    	}
    	
    	ArrayList<Integer> result[] = new ArrayList[n];
    	for(int i=0; i<n; i++) {
    		result[i] = new ArrayList<>();
    	}
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		for(int next : graph[cur]) {
    			indegree[next]--;
    			if(indegree[next]==0) {
    				q.offer(next);
    				result[cur].add(next);
    			}
    			Collections.sort(result[cur]);
    		}
    	}
    	StringBuilder sb = new StringBuilder();
    	sb.append(root.size()).append('\n');
    	for(int r : root) {
    		sb.append(name[r]).append(" ");
    	}
    	sb.append('\n');
    	for(int i=0; i<n; i++) {
    		sb.append(name[i]).append(" ").append(result[name2int.get(name[i])].size()).append(" ");
    		
    		for(int j=0; j<result[name2int.get(name[i])].size(); j++) {
    			sb.append(name[result[name2int.get(name[i])].get(j)]).append(" ");
    		}
    		sb.append('\n');
    	}
    	
    	System.out.println(sb.toString());
	}

}