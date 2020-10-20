package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class Temp{
	boolean isExist;
	int naegudo;
	
	public Temp(boolean isExist, int naegudo) {
		this.isExist = isExist;
		this.naegudo = naegudo;
	}
}

class Robot{
	int idx;
	
	public Robot(int idx) {
		this.idx = idx;
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
		
		Deque<Robot> robots = new ArrayDeque<>();
		
		while(true) {
			// 벨트 회전
			step+=1;
			Temp tmp = belt.remove(belt.size()-1);
			belt.add(0, tmp);
			
			
			// 로봇 이동
			//step+=1;
			for(int i=0; i<robots.size(); i++) {
				Robot robot = robots.removeFirst();
				Temp cur = belt.get(robot.idx);
				Temp next = belt.get(robot.idx+1);
				if(!next.isExist && next.naegudo>0) {
					cur.isExist=false;
					//cur.naegudo-=1;
					next.isExist=true;
					next.naegudo-=1;
					belt.set(robot.idx, cur);
					belt.set(robot.idx+1, next);
				}
				robots.addLast(robot);
			}
			
			// 로봇 올리기
			//step+=1;
			Temp first = belt.get(0);
			if(!first.isExist) {
				first.isExist=true;
				first.naegudo-=1;
				robots.add(new Robot(0));
				//belt.set(0, first);
			}
			
			//step+=1;
			for (Temp check : belt) {
				if(check.naegudo==0) {
					count+=1;
					if(count==k) {
						System.out.println(step);
						System.exit(0);
					}
				}
			}
			count=0;
		}
		
	}

}
