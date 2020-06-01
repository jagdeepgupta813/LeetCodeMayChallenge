package practiceJava.leetcode.may.challenge;

import java.util.Stack;

public class BinarySearchTreeFromPreOrder {

	public static void main(String[] args) {
		BinarySearchTreeFromPreOrder b = new BinarySearchTreeFromPreOrder();
		int []preorder= new int[] {8, 5, 1, 7, 40, 50};
		TreeNode root=b.bstFromPreorder(preorder);
		b.printPreOrder(root);

	}
	
	void printPreOrder(TreeNode t) {
		if(t==null) {
			System.out.println("null ");
		}
		else {
			System.out.print("root is " + t.val + " childeren are " );
			printPreOrder(t.left);
			printPreOrder(t.right);
		}
	}
	
	
    public TreeNode bstFromPreorder(int[] preorder) {
    	if(preorder==null || preorder.length<1)
    		return null;
    	
    	TreeNode root=new TreeNode(preorder[0]);
    	Stack<TreeNode> s = new Stack<>();
    	s.push(root);
    	TreeNode temp=null;
    	for(int i=1; i<preorder.length; i++) {
    		TreeNode t = new TreeNode(preorder[i]);
    		if(preorder[i]< s.peek().val) {
    			temp=s.peek();
    			temp.left=t;
    		}
    		else {
    			while(!s.isEmpty() && s.peek().val<preorder[i]) {
    				temp=s.pop();
    			}
    			if(temp!=null) {
    				temp.right=t;
    				
    			}
    		}
    		s.push(t);
    	}
    		return root;
    }
    
    TreeNode constructTree(int pre[]) { 
    	  
        // The first element of pre[] is always root 
        TreeNode root = new TreeNode(pre[0]); 
		int size=pre.length;
  
        Stack<TreeNode> s = new Stack<TreeNode>(); 
  
        // Push root 
        s.push(root); 
  
        // Iterate through rest of the size-1 items of given preorder array 
        for (int i = 1; i < size; ++i) { 
            TreeNode temp = null; 
  
            /* Keep on popping while the next value is greater than 
             stack's top value. */
            while (!s.isEmpty() && pre[i] > s.peek().val) { 
                temp = s.pop(); 
            } 
  
            // Make this greater value as the right child 
            // and push it to the stack 
            if (temp != null) { 
                temp.right = new TreeNode(pre[i]); 
                s.push(temp.right); 
            }  
              
            // If the next value is less than the stack's top 
            // value, make this value as the left child of the  
            // stack's top TreeNode. Push the new TreeNode to stack 
            else { 
                temp = s.peek(); 
                temp.left = new TreeNode(pre[i]); 
                s.push(temp.left); 
            } 
        } 
  
        return root; 
    } 
    
    public TreeNode bstFromPreorder1(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (preorder[i] < stack.peek().val) {                
                stack.peek().left = node;                
            } else {
                TreeNode parent = stack.peek();
                while (!stack.isEmpty() && preorder[i] > stack.peek().val) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);            
        }
        return root;
    }

}



