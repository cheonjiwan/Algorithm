package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

class Student implements Comparable<Student>{
	String name;
	int kor;
	int eng;
	int math;
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	@Override
	public int compareTo(Student o) {
		
		if(this.kor>o.kor) return -1;
		else if(this.kor == o.kor) {
			if(this.eng<o.eng) return -1;
			else if(this.eng==o.eng) {
				if(this.math>o.math) return -1;
				else if(this.math==o.math) {
					return this.name.compareTo(o.name);
					// 내림차순
					//return o.name.compareTo(this.name);
				}
				else return 1;
			}
			else return 1;
		}
		else return 1;
		
		
	}
}
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Student> arr = new ArrayList<>();
		int n = Integer.parseInt(st.nextToken());
		for(int i=0; i<n; i++)
		{
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			arr.add(new Student(name,kor,eng,math));
		}
		Collections.sort(arr);
		for (Student student : arr) {
			System.out.println(student.name);
		}
	}
	

}
