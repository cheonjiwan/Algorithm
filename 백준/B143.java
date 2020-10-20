package 고급작품;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//class Stamp{
//	int size_x;
//	int size_y;
//	String st;
//	
//	public Stamp(int size_x, int size_y, String st) {
//		this.size_x = size_x;
//		this.size_y = size_y;
//		this.st = st;
//	}
//}

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k =Integer.parseInt(br.readLine());
		
//		ArrayList<Stamp> stamps = new ArrayList<>();
		String[][] stamps = new String[k][];
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			stamps[i] = new String[h];
			for(int j=0; j<h; j++) {
				stamps[i][j] = br.readLine();
			}
		}
		
		char[][] board = new char[n][m];
		for(int i=0; i<n; i++) {
			Arrays.fill(board[i], '.');
		}
//		for (char[] b : board) {
//			Arrays.fill(b, '.');
//		}
		
		int q = Integer.parseInt(br.readLine());
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int s_x = Integer.parseInt(st.nextToken());
			int s_y = Integer.parseInt(st.nextToken());
			int tmp_y = s_y;
//			Stamp tmp = stamps.get(idx-1);
//			int len_x = tmp.size_x;
//			int len_y = tmp.size_y;
//			String stamp = tmp.st;
			
			for(int a=0; a<stamps[idx-1].length; a++) {
				for(int b=0; b<stamps[idx-1][a].length(); b++)
				{
					board[s_x][tmp_y]=stamps[idx-1][a].charAt(b);
					tmp_y+=1;
				}
				tmp_y=s_y;
				s_x+=1;
			}
		}
		
		for(int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				bw.write(board[i][j]);
			}
			bw.write("\n");
		}
		bw.close();
		
//		for (char[] cs : board) {
//			for (char c : cs) {
//				bw.write(c);
//			}
//			bw.write("\n");;
//		}
//		bw.flush();
		bw.close();
		
		
	}

}
