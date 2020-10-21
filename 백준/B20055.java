package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Temp{
	boolean isExist;
	int naegudo;
	
	public Temp(boolean isExist, int naegudo) {
		this.isExist = isExist;
		this.naegudo = naegudo;
	}
}

class Robot implements Comparable<Robot>{
	int idx;
	
	public Robot(int idx) {
		this.idx = idx;
	}
	
	@Override
	public int compareTo(Robot o) {
		// TODO Auto-generated method stub
		if(this.idx > o.idx) return -1;
		else if(this.idx==o.idx)return 0;
		else return 1;
		
	}
}

public class Main {
	
	static int count = 0;
	static int step = 0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		ArrayList<Temp> belt = new ArrayList<>();
		for(int i=0; i<2*n; i++) {
			belt.add(new Temp(false,Integer.parseInt(st.nextToken())));
		}
		
//		PriorityQueue<Robot> robots = new PriorityQueue<>();
		Deque<Robot> robots = new ArrayDeque<>();
		
		while(true) {
			// 벨트 회전
			
			step+=1;
			Temp tmp = belt.remove(belt.size()-1);
			belt.add(0, tmp);
			int len = robots.size();
			for(int i=0; i<len; i++) {
				Robot robot = robots.removeLast();
				robot.idx+=1;
				if(robot.idx>=n-1) {
					belt.get(robot.idx).isExist=false;
					//robots.remove(robot);
				}else {
					robots.addFirst(robot);
				}
			}
			
			// 로봇 이동
			
			len = robots.size();
			for(int i=0; i<len; i++) {
				Robot robot = robots.removeLast();
				Temp cur = belt.get(robot.idx);
				Temp next = belt.get(robot.idx+1);
				if(!next.isExist && next.naegudo>0) {
					cur.isExist=false;
					next.isExist=true;
					next.naegudo-=1;
					robot.idx +=1;
					if (robot.idx<n-1) {
						robots.addFirst(robot);
					}
					else {
						belt.get(robot.idx).isExist=false;
					}
				}
				else {
					robots.addFirst(robot);
				}
				
			}
			
			// 로봇 올리기
			Temp first = belt.get(0);
			if(!first.isExist && first.naegudo>0) {
				first.isExist=true;
				first.naegudo-=1;
				robots.addFirst(new Robot(0));
			}
			
			
			// 내구도 확인
			for(int i=0; i<belt.size(); i++) {
				if(belt.get(i).naegudo==0)
					count+=1;
			}
			if(count>=k) {
				System.out.println(step);
				System.exit(0);
			}
			count=0;
		}
		
	}

}
