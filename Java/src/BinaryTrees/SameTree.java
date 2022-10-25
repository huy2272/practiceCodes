package BinaryTrees;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if  (p == null && q == null) return true;
        //One of p and q is null
        if  (p == null || q == null) return false;
        if  (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
