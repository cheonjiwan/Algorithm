import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long l=0,r=(long)times[times.length-1]*n;
        long mid=0;
        
        while(l<=r){
            mid = (l+r)/2;
            long sum=0;
            for(int i=0; i<times.length; i++){
                sum += (mid/times[i]); 
            }
            if(sum>=n)
            {
                r=mid-1;
                answer=mid;
            }
            else
                l=mid+1;
        }
        return answer;
    }
}