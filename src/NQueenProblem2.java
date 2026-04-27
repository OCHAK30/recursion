import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TC: O(n!) -> Q1 has 4 options, Q2 will have (n-1) options, Q3 will get (n-2) options and so on.
//https://www.youtube.com/watch?v=BdSJnIdR-4s
public class NQueenProblem2 {
    public static void main(String[] args) {
        int n = 4;
        solveNQueens(n);
    }

    public static int solveNQueens(int n) {
        //We create a board of nxn size
        char[][] board = new char[n][n];
        //Fill board array with "."
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        List<List<String>> ans = new ArrayList<>();

        // Start solving from row 0
        placeNQueens(n, 0, ans, board);
        System.out.println(ans.size());
        return ans.size();
    }

    public static void placeNQueens(int n,  int row, List<List<String>> ans, char[][] board){
        //Base case -> row becomes n
        if(row == n){
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }
            ans.add(list);
            return;
        }

        //Iterate through columns till n, basically we will store n queens in n rows
        for (int j = 0; j < n; j++) {
            if(isSafe(n, row, j, board)){
                board[row][j] = 'Q';
                //if it is safe to place the queen in current row and column, we call for the next row
                placeNQueens(n, row+1, ans, board);
                board[row][j] = '.';
            }
        }
    }

    public static boolean isSafe(int n, int row, int col, char[][] board){
        //check horizontally, usi same row mein koi aur Queen toh nahi hai? [ROW CONSTANT]
        for (int j = 0; j < n; j++) {
            if(board[row][j] == 'Q') return false;
        }

        //check vertically, usi same column mein koi aur Queen toh nahi hai? [COLUMN CONSTANT]
        for (int i = 0; i < n; i++) {
            if(board[i][col] == 'Q') return false;
        }

        //check diagonally, upper left diagonal -> row-- and col--
        for (int i = row, j = col; i >= 0 && j >= 0 ; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }

        //check diagonally, upper right diagonal -> row-- and col++
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
}
