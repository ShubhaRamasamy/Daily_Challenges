class Solution {

    int count = 0;

    public int orangesRotting(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        boolean changed = true;

        while (changed) {

            changed = false;

            
            int[][] temp = new int[row][col];

            for (int i = 0; i < row; i++) {
                temp[i] = grid[i].clone();
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {

                    if (grid[i][j] == 2) {
                        if (dfs(grid, temp, i, j)) {
                            changed = true;
                        }
                    }

                }
            }

            if (changed) {
                count++;
                grid = temp;
            }
        }

        // Check if any fresh orange remains
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return count;
    }

    public boolean dfs(int[][] grid, int[][] temp, int i, int j) {

        boolean changed = false;

        if (check(grid, i + 1, j)) {
            temp[i + 1][j] = 2;
            changed = true;
        }

        if (check(grid, i - 1, j)) {
            temp[i - 1][j] = 2;
            changed = true;
        }

        if (check(grid, i, j + 1)) {
            temp[i][j + 1] = 2;
            changed = true;
        }

        if (check(grid, i, j - 1)) {
            temp[i][j - 1] = 2;
            changed = true;
        }

        return changed;
    }

    public boolean check(int[][] grid, int i, int j) {

        return i >= 0 &&
               j >= 0 &&
               i < grid.length &&
               j < grid[0].length &&
               grid[i][j] == 1;
    }
}
