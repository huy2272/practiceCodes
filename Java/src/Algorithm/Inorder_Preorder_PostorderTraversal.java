package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Inorder_Preorder_PostorderTraversal {
	List<Integer> list = new ArrayList<>();
	List<Integer> list1 = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        
        if (root == null) {return list;}
        
        if  (root.left != null) {
            inorderTraversal(root.left);
        }
        
        list.add(root.val);
        
        if  (root.right !=null) {
            inorderTraversal(root.right);
        }
        
        return list;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        if  (root == null)  {return list1;}
        
        list1.add(root.val);
        
        if(root.left != null){
            preorderTraversal(root.left);
        }
        
        if(root.right != null){
            preorderTraversal(root.right);
        }
        
        return list1;
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        if  (root == null) {return list2;}
        
        if (root.left != null){
            postorderTraversal(root.left);
        }
        
        if  (root.right != null){
            postorderTraversal(root.right);
        }
        
        list2.add(root.val);
        
        return list2;
    }
}
