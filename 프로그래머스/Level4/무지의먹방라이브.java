import java.io.*;
import java.util.*;

class Data implements Comparable<Data> {

    int time,num;

    public Data(int time, int num) {
        this.time = time;
        this.num = num;
    }

    @Override
    public int compareTo(Data o) {
        return this.time - o.time;
    }
}

class Solution {
    public int solution(int[] food_times, long k) {

        long summary = 0;
        for (int time : food_times) {
            summary += (long)time;
        }
        if (summary <= k) return -1;

        PriorityQueue<Data> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Data(food_times[i], i + 1));
        }

        summary = 0;
        long previous = 0;
        long length = food_times.length;

        while (summary + ((pq.peek().time - previous) * length) <= k) {
            int now = pq.poll().time;
            summary += (now - previous) * length;
            length -= 1; 
            previous = now; 
        }

        ArrayList<Data> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.sort(result, new Comparator<Data>() { 
            @Override
            public int compare(Data a, Data b) {
                return Integer.compare(a.num, b.num);
            }
        });
        return result.get((int) ((k - summary) % length)).num;
    }
}

public class Main {	
	public static void main(String[] args){
		int[] food_times = {3,1,2};
		long k = 5;
		System.out.println(new Solution().solution(food_times, k));
	}
	
}