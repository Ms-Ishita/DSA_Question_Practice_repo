public class Tree_Construction {
    static class Node {
        int data;
        Node left;
        Node right;
        
        Node(){
            this.left = null;
            this.right= null;

        }
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node root;
    public static int idx= -1;
    public static Node last(int[] arr){
        idx++;
        if(arr[idx]==-1){
            return null;
        }
        Node nw = new Node(arr[idx]);
        nw.left = last(arr);
        nw.right = last(arr);
        return nw;
    }
    public static void preOrder(Node root){
        if(root == null){
            System.out.print(-1+" ");
            return;
        }
  
        System.out.print(root.data+" ");

        preOrder(root.left);
        preOrder(root.right);
        

    }
    public static void inOrder(Node root){
        if(root == null){
            System.out.print(-1+" ");
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
        

    }
    public static void postOrder(Node root){
        if(root == null){
            System.out.print(-1+" ");
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
        

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,-1,-1,4,-1,-1,4,-1,3,-1,-1};
        root = last(arr);
    
        //System.out.println(root.data);

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);

    }
    
}
