package Algorithm;

public class SrchBinaryTree {
	public TreeNode searchBST(TreeNode root, int val) {
        //If key is found or root is null return the root
        if (root == null || root.val == val) {return root;}
        
        //For a BST the right node is always bigger than the root
        //While the left node is smaller than the root
        //Therefore if the key if bigger than the root we go right
        if  (root.val < val){
            return searchBST(root.right, val);
        }
        
        //If the key is not bigger, then it is smaller
        //We go search the left hand side
        return searchBST(root.left, val);
    }
}
