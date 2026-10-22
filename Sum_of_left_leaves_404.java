import javax.swing.tree.TreeNode;

public class Sum_of_left_leaves_404 {
    public boolean isleaf(TreeNode root){
        return (root != null && root.left == null && root.right == null);
    }
    public int sumOfLeftLeaves(TreeNode root) {
     if(root== null)return 0;
     int sum =0;
     if(isleaf(root.left)){
        sum = sum+root.left.val;
     }
     sum = sum+sumOfLeftLeaves(root.left);
     sum = sum+sumOfLeftLeaves(root.right);
     return sum;
        
    }
}
