import java.util.Scanner;

public class sudoku_Solver {
    public static boolean isSolve(char[][] board){
        for(int i =0; i<9; i++){
            for(int j =0; j<9; j++){
                if(board[i][j]=='.'){
                    for(char c ='1';c<='9'; c++){
                        if(isSafe(board,i,j,c)){
                            board[i][j]=c;
                            if(isSolve(board))return true;
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static  boolean isSafe(char[][] board, int row, int col, char c){
        for(int i=0; i<9; i++){
            if(board[row][i]==c)return false;
            if(board[i][col]==c)return false;
        }
        int boxRow = (row/3)*3;
        int boxCol = (col/3)*3;
        for(int i =boxRow; i<boxRow+3; i++){
            for(int j =boxCol; j<boxCol+3; j++){
                if(board[i][j]==c)return false;
            }
        }
        return true;
    }
    public static  void solveSudoku(char[][] board) {
        isSolve(board);
    }
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    char[][] board = new char[9][9];

    // Take Sudoku input
    for (int i = 0; i < 9; i++) {
        String row = sc.next();

        for (int j = 0; j < 9; j++) {
            board[i][j] = row.charAt(j);
        }
    }
    solveSudoku(board);

    for (int i = 0; i < 9; i++) {

        for (int j = 0; j < 9; j++) {
            System.out.print(board[i][j] + " ");
        }

        System.out.println();
    }
}
}
