package practiceJava.leetcode.may.challenge;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
  In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.
 */




  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
   

public class CousinsInBinaryTree {

	public static void main(String[] args) {
		
		TreeNode n4=new TreeNode(4);
		TreeNode n5=new TreeNode(5);
		TreeNode n2=new TreeNode(2,n4,null);		
		TreeNode n3=new TreeNode(3,n5,null);		
		TreeNode n1= new TreeNode(1,n2,n3);
		int x=4;
		int y=5;
		CousinsInBinaryTree c = new CousinsInBinaryTree();
		System.out.println(c.isCousins1(n1, x, y));
		

	}
	
	
	
	//BFS ,as we need to check if the two keys are at the same level or not
	// check if both are childeren of same no
	public boolean isCousins1(TreeNode root, int A, int B) {
	    if (root == null) return false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean isAexist = false;		
			boolean isBexist = false;		
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
	            if (cur.val == A) isAexist = true;
	            if (cur.val == B) isBexist = true;
				if (cur.left != null && cur.right != null) { 
					if (cur.left.val == A && cur.right.val == B) { 
						return false;
					}
					if (cur.left.val == B && cur.right.val == A) { 
						return false;
					}
				}
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			if (isAexist && isBexist)  return true;
		}
		return false;
	}

	
	
	 public boolean isCousins(TreeNode root, int x, int y) {
		 
		 LinkedList<TreeNode> nodesToVisit  = new LinkedList<TreeNode>() ;
		 nodesToVisit.add(root);
		 
		 
		 while(!nodesToVisit.isEmpty()) {
			 boolean left=false;
			 boolean right=false;
			 while(!nodesToVisit.isEmpty() ) {
				 
				 for(int i=0; i<nodesToVisit.size(); i++) {
					 TreeNode next= nodesToVisit.removeFirst();	
					 
					 if(next!=null) {
						 if(next.left!=null && next.right!=null ) {
							 int x1 = next.left.val;
							 int y1=next.right.val;
							 if((x1==x && y1==y) || (x1==y && y1==x))
								 return false;
							 
							 if(next.left!=null)
								 nodesToVisit.addLast(next.left);
								 if(next.right!=null)
								 nodesToVisit.addLast(next.right);
								 if(next.val ==x) {
									 left=true;
								 }else if(next.val==y)
									 right=true;
								 }
						 }
					 }
				 if(left && right) {
					 return true;
					 }
				 }
		 }
		 
	     
		 return false;
	    }

	 
	 public TreeNode processInput(List<Integer> values, TreeNode root, int i) {
		 if(i<values.size()) {
			 TreeNode temp=new TreeNode(values.get(i));
			 root=temp;
			 root.left=processInput(values, root.left , 2*i+1);
			 root.right=processInput(values, root.right , 2*i+1);
		 }
		 return root;
	}
		 
	 
}
