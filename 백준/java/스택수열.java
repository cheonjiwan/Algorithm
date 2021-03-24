import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		int top=0;
		while(n-->0) {
			int num = Integer.parseInt(br.readLine());
			if(num>top) {
				for(int i=top+1; i<=num; i++) {
					stack.push(i);
					sb.append('+').append('\n');
				}
				top = num;
			}
			else if(stack.peek()!=num) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append('-').append('\n');
		}
		
		System.out.println(sb.toString());
		
	}
		
}