import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Binary_Tree_Level_Order_Traversal_II_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)return result;
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr == null){
                
                result.add(0,new ArrayList<>(list));
                while(!list.isEmpty())list.remove(list.size()-1);
                if(q.isEmpty())break;
                else {
                    q.offer(null);
                }
            }
            else {
                list.add(curr.val);
                
                if(curr.left!=null)q.offer(curr.left);
                if(curr.right!=null)q.offer(curr.right);            
            }

        }
        return result;
        
    }
    
}
