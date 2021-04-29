import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] data;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	n = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<n; i++) {
    		pq.offer(Integer.parseInt(st.nextToken()));
    	}
    	
    	for(int i=1; i<n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<n; j++) {
    			int cur = Integer.parseInt(st.nextToken());
    			if(pq.peek() < cur) {
    				pq.poll();
    				pq.offer(cur);
    			}
    		}
    	}
    	System.out.println(pq.peek());
    }
}