package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume
 * all four edges of the grid are all surrounded by water.
 */

public class CountNumberOfIsland {

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0' }, {'1', '1', '0', '0', '0' }, {'0', '0', '1', '0', '0' }, {'0', '0', '0', '1', '1' }};

        System.out.println("Number of Island using DFS: " + countIslandsWithDFS(grid));

        // use either BFD or DFS because we are updating the visited value.
        System.out.println("Number of Island using BFS: " + countIslandsWithBFS(grid));
    }

    private static int countIslandsWithBFS(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        //Move in Four Directions
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> qu = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    qu.add(new int[]{i, j});

                    // Mark Visited element
                    grid[i][j] = '2';

                    while (!qu.isEmpty()) {
                        int[] curr = qu.poll();

                        for (int[] direction : directions) {
                            int r = curr[0] + direction[0];
                            int c = curr[1] + direction[1];

                            if (r >= 0 && r < row && c >= 0 && c < col && grid[r][c] == '1') {
                                qu.add(new int[]{r, c});
                                grid[r][c] = '2';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    private static int countIslandsWithDFS(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    markVisitIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void markVisitIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        markVisitIsland(grid, i + 1, j);
        markVisitIsland(grid, i - 1, j);
        markVisitIsland(grid, i, j + 1);
        markVisitIsland(grid, i, j - 1);
    }
}
