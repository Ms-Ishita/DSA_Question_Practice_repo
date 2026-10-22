public class Lowest_Common_Ancestor_of_a_Binary_Tree_236 {
        if(root==null)return null;
        if(p== root || q==root)return root;
        TreeNode left = lowestCommonAncestor(root.left, p,q);
        TreeNode right = lowestCommonAncestor(root.right, p,q);
        if(left == null)return right;
        if(right == null)return left;
        return root;
    
}
