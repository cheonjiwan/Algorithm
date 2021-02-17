import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int result = 0;
		
		int[] board = new int[c];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<c; i++) {
			board[i] = Integer.parseInt(st.nextToken());
		}
		int left,right;
		for(int idx=1; idx<c-1; idx++) {
			left=0; right=0;
			for(int x=0; x<idx; x++) {
				if(left<board[x])
					left = board[x];
			}
			for(int y=idx+1; y<c; y++)
			{
				if(right<board[y]) {
					right = board[y];
				}
			}
			
			if(board[idx]<left && board[idx]<right) {
				int minValue;
				if(left<right)
					minValue = left;
				else
					minValue = right;
				result += minValue - board[idx];
				
			}
		}
		
		System.out.println(result);
		
	}

}
