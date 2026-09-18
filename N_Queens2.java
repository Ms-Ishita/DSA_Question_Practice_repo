import java.util.Scanner;

public class N_Queens2 {
    static int count =0;
    static int totalNQueens(int n) {
        int[][] board = new int[n][n];
        solve(n,board,0);
        return count;
    }
        static void solve(int n, int[][] board, int row){
            if(row == n){
                count++;
                return;
            }
            for(int col=0; col<n; col++){
                if(isSafe(row,col, board)){
                    board[row][col]= 1;
                    solve(n,board,row+1);
                    board[row][col] = 0;
                }
            }
        }
        static boolean isSafe(int row, int col, int[][] board){
            for(int i =0; i<row; i++){
                if(board[i][col]==1)return false;
            }
            int i = row-1;
            int j = col-1;
            while(i>=0 && j>=0){
                if(board[i][j]==1)return false;
                i--;
                j--;
            }
            i = row-1;
            j =col+1;
            int n = board.length;
            while(i>=0 &&j<n){
                if(board[i][j]==1)return false;
                i--;
                j++;

            }
            return true;


        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.println(totalNQueens(n));
        }
    
}

