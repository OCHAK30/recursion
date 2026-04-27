/** Time: O(m * n * 4^L) -> You explore 4 directions initially
    Space: O(L) -> Maximum depth = L (length of the word); You modify the board in-place and restore it so no extra space is used.
 **/

public class WordSearch {
    static int m, n;
    static int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}}; // up, down, right, left
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board,word));
    }

    public static boolean exist(char[][] board, String word) {
        m = board.length; //rows count
        n = board[0].length; //column count

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0) && find(i, j, 0, board, word)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean find(int i, int j, int idx, char[][] board, String word){
        //Base case
        if(idx == word.length()) return true;

        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '$') return false;

        if(board[i][j] != word.charAt(idx)) return false;

        //Mark visited as '$'
        char temp = board[i][j];
        board[i][j] = '$';

        //You check all 4 directions
        for(int[] dir : directions){
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            if (find(new_i, new_j, idx+1, board, word)){
                return true;
            }
        }

        board[i][j] = temp;
        return false;
    }
}
