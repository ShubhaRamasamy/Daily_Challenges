class Solution {

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int minutes = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        int[][] dir = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            for (int k = 0; k < size; k++) {

                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                for (int[] d : dir) {

                    int row = x + d[0];
                    int col = y + d[1];

                    if (row >= 0 && col >= 0 &&
                        row < rows && col < cols &&
                        grid[row][col] == 1) {

                        grid[row][col] = 2;
                        fresh--;
                        queue.offer(new int[]{row, col});
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
