package graph;

/**
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'},
                          {'X', 'O', 'O', 'X'},
                          {'X', 'X', 'O', 'X'},
                          {'X', 'O', 'X', 'X'}};

        int row = board.length;
        int col = board[0].length;
        print(board,row,col);

        // Marking 'O' at the boundaries of matrix.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == 0 || i == row - 1 || j == 0 || j == col - 1) && board[i][j] == 'O')
                    dfs(board, row, col, i, j);
            }
        }
        // Replace marked entity
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j]=='O')
                    board[i][j]='X';
                else if (board[i][j]=='$') {
                    board[i][j]='O';
                }
            }
        }
        System.out.println("After Surrounding.");
        print(board,row,col);
    }

    private static void print(char[][] mat, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }

    private static void dfs(char[][] board, int row, int col, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] == 'X')
            return;
        if (board[i][j] == 'O') {
            board[i][j] = '$';
            dfs(board, row, col, i + 1, j);
            dfs(board, row, col, i - 1, j);
            dfs(board, row, col, i, j + 1);
            dfs(board, row, col, i, j - 1);
        }
    }
}
