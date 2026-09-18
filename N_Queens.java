import java.util.*;

public class N_Queens {
    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solve(0, n, board, ans);
        return ans;
    }

    public static void solve(int row, int n, char[][] board,List<List<String>> ans) {

        if (row == n) {

            List<String> current = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                current.add(new String(board[i]));
            }
            ans.add(current);
            return;
        }
        for (int col = 0; col < n; col++) {

            if (isSafe(row, col, n, board)) {
                board[row][col] = 'Q';
                solve(row + 1, n, board, ans);
                board[row][col] = '.';
            }
        }
    }

    public static boolean isSafe(int row, int col, int n,char[][] board) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        List<List<String>> ans = solveNQueens(n);
        for (List<String> board : ans) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }

        System.out.println(ans.size());

        sc.close();
    }

    
}