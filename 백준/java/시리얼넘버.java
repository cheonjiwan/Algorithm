import java.io.*;
import java.util.*;

import javax.xml.crypto.Data;

public class Main {
	
	static int n;
	static ArrayList<Data> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			list.add(new Data(br.readLine()));
		}
		
		Collections.sort(list);
		
		for(int i=0; i<n; i++) {
			System.out.println(list.get(i).input);
		}
		
	}
	
	static class Data implements Comparable<Data>{
		String input;
		Data(String input){
			this.input = input;
		}
		@Override
		public int compareTo(Main.Data o) {
			if(this.input.length() < o.input.length()) {
				return -1;
			}
			else if(this.input.length()==o.input.length()) {
				int a=0,b=0;
				for(int i=0; i<this.input.length(); i++) {
					if('0'<=this.input.charAt(i) && this.input.charAt(i)<='9')
						a+=this.input.charAt(i)-'0';
				}
				
				for(int i=0; i<o.input.length(); i++) {
					if('0'<=o.input.charAt(i) && o.input.charAt(i)<='9')
						b+=o.input.charAt(i)-'0';
				}
				
				if(a<b)
					return -1;
				else if(a==b) {
					if(this.input.compareTo(o.input)<0)
						return -1;
					else if(this.input.compareTo(o.input)==0)
						return 0;
					else
						return 1;
				}
				else
					return 1;
			}
			else
				return 1;
			
		}
		
	}
}