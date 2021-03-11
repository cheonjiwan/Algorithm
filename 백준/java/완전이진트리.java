import java.io.*;
import java.util.*;

public class Main { 
	
	static int[] data = new int[1024];
	static int[][] tree = new int[11][512];
	static int[] depth_idx = new int[10];
	
	public static void buildTree(int start, int end, int depth) {
		if(end-start<0)
			return;
		
		int mid = (start+end)/2;
		tree[depth][depth_idx[depth]++] = data[mid];
		buildTree(start,mid-1,depth+1);
		buildTree(mid+1,end,depth+1);
		
	}
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int k = Integer.parseInt(br.readLine());
		int end=2;
		for(int i=1; i<k; i++)
			end*=2;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<end; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		buildTree(1,end-1,0);
		
		for(int i=0; i<k; i++) {
			end=1;
			for(int j=0; j<i; j++) {
				end*=2;
			}
			for(int j=0; j<end; j++) {
				System.out.print(tree[i][j]+" ");
			}
			System.out.println();
		}
	}
}