import java.util.*;

class Solution {
	static int[][] answer;
	static int idx;
	
    public int[][] solution(int[][] nodeinfo) {
        ArrayList<Node> tree = new ArrayList<>();
        int num=1;
        for(int[] node : nodeinfo) {
        	tree.add(new Node(num++,node[0],node[1]));
        }
        
        Collections.sort(tree);
        Node root = tree.get(0);
        
        for(int i=1; i<tree.size(); i++) {
        	Node child = tree.get(i);
        	makeTree(root,child);
        }
        
        answer = new int[2][tree.size()];
        preOrder(root);
        idx=0;
        postOrder(root);
        
        return answer;
    }
    
    public void preOrder(Node cur) {
    	if(cur!=null) {
    		answer[0][idx++] = cur.num;
    		preOrder(cur.left);
    		preOrder(cur.right);
    	}
    }
    
    public void postOrder(Node cur) {
    	if(cur!=null) {
    		postOrder(cur.left);
    		postOrder(cur.right);
    		answer[1][idx++] = cur.num;
    	}
    }
    
    public void makeTree(Node root, Node child) {
    	if(root.x>child.x) {
    		if(root.left==null) {
    			root.left = child;
    		}
    		else {
    			makeTree(root.left, child);
    		}
    	}
    	else {
    		if(root.right==null) {
    			root.right = child;
    		}
    		else
    			makeTree(root.right,child);
    	}
    }
    
    static class Node implements Comparable<Node>{
    	int num,x,y;
    	Node left,right;
    	
    	Node(int num, int x, int y){
    		this.num=num;
    		this.x=x;
    		this.y=y;
    	}
    	
    	@Override
    	public int compareTo(Solution.Node o) {
    		return o.y-this.y;
    	}
    }
}

public class Main {  
   public static void main(String[] args){
      int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
      System.out.println(new Solution().solution(nodeinfo));
   }
   
}