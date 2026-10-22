import javax.swing.tree.TreeNode;

public class SymmetricTree_101 {
    public boolean isSame(TreeNode root1, TreeNode root2){
        if(root1== null && root2 == null)return true;
        if(root1 == null || root2 == null)return false;
        if(root1.val==root2.val)
        return isSame(root1.left, root2.right)&& isSame(root2.left, root1.right);
        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return isSame(root.left, root.right);
        
    }
}
