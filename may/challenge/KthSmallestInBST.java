package practiceJava.leetcode.may.challenge;

/*
  Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 */
public class KthSmallestInBST {

	int count=0;
	public static void main(String[] args) {
		int [] nodevalues=new int[] {3,1,4,5,2};
		KthSmallestInBST b = new KthSmallestInBST();
		TreeNodeBST root=null;
		for(int x:nodevalues)
			root=b.insert(root, x);
		int k=3;
		System.out.println(b.findKthSmallest(root, k));

	}
	public  TreeNodeBST insert(TreeNodeBST root, int x) 
    { 
        if (root == null) 
            return new TreeNodeBST(x); 
        if (x < root.val) 
            root.left = insert(root.left, x); 
        else if (x > root.val) 
            root.right = insert(root.right, x); 
        return root; 
    } 
	
	public int findKthSmallest(TreeNodeBST node, int k) {
		if(node==null)
			return Integer.MAX_VALUE;
		int res=Integer.MAX_VALUE;
		if(node.left!=null)
			res=findKthSmallest(node.left, k);
		if(res!=Integer.MAX_VALUE)
			return res;
		count++;
		if(count==k)
			return node.val;
				
		return findKthSmallest(node.right, k);
	}

}



  //Definition for a binary tree node.
  class TreeNodeBST {
      int val;
      TreeNodeBST left;
      TreeNodeBST right;
      TreeNodeBST() {}
      TreeNodeBST(int val) { this.val = val; }
      TreeNodeBST(int val, TreeNodeBST left, TreeNodeBST right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 