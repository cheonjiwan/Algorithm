import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			if(solve(input))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	
	}
	
	private static boolean solve(String data) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<data.length(); i++) {
			char cur = data.charAt(i);
			if(cur=='(')
				stack.push(cur);
			else if(cur==')') {
				if(stack.size()==0)
					return false;
				else
					stack.pop();
			}
		}
		if(stack.size()==0)
			return true;
		else
			return false;
	}
}
