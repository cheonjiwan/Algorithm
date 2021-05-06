import java.util.*;

class Solution {
	static ArrayList<Data> list = new ArrayList<>();
	
    public int[][] solution(int n, int[][] build_frame) {
    	
    	int x,y,what,order;
        
    	for(int[] build : build_frame) {
    		x = build[0]; y = build[1]; what = build[2]; order = build[3];
    		if(order==0) { // 삭제
    			remove(x,y,what);	
        		if(!check()) {
        			list.add(new Data(x,y,what));
        		}
        	}
        	else { // 설치
        		list.add(new Data(x,y,what));
        		if(!check()) {
        			remove(x,y,what);
        		}
        	}
    	}

    	Collections.sort(list,new Comparator<Data>() {
			@Override
			public int compare(Solution.Data a, Solution.Data b) {
				if(a.x==b.x) {
					if(a.y==b.y)
						return a.what-b.what;
					else
						return a.y-b.y;
				}
				else {
					return a.x-b.x;
				}
			}
		});
        
        int[][] result = new int[list.size()][3];
        for(int i=0; i<result.length; i++) {
        	Data cur = list.get(i);
        	result[i][0] = cur.x;
        	result[i][1] = cur.y;
        	result[i][2] = cur.what;
        }
        return result;
    }
    
    public void remove(int x, int y, int what) {
    	for(Data cur : list) {
    		if(cur.x==x && cur.y==y && cur.what == what) {
    			list.remove(cur);
    			return;
    		}
    	}
    }
    
    public boolean check() {
    	for(Data cur : list) {
    		int x = cur.x;
    		int y = cur.y;
    		int what = cur.what;
    		if(what==0) {
    			if(y==0 || possible(x-1,y,1) || possible(x,y,1) || possible(x,y-1,0))
    				continue;
    			else return false;
    		}
    		else {
    			if(possible(x,y-1,0) || possible(x+1,y-1,0) || 
    					(possible(x-1,y,1) && possible(x+1,y,1)))
    				continue;
    			else return false;
    		}
    	}
    	return true;
    }
    
    public boolean possible(int x, int y, int what) {
    	for(Data cur : list) {
    		if(cur.x==x && cur.y==y && cur.what==what)
    			return true;
    	}
    	return false;
    }

    static class Data{
    	int x,y,what;
    	Data(int x, int y, int what){
    		this.x=x;
    		this.y=y;
    		this.what=what;
    	}
    }
}

public class Main {  
   public static void main(String[] args){
      int n = 5;
      int[][] build_frame = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
      int[][] result = new Solution().solution(n, build_frame);
      
      StringBuilder sb = new StringBuilder();
      for(int[] row : result) {
    	  sb.append(row[0]+" "+row[1]+ " " + row[2]+'\n');
      }
      System.out.println(sb.toString());
   }
   
}