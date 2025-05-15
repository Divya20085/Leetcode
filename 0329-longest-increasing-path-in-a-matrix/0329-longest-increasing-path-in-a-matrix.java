class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        // DP array to cache the longest increasing path from each cell
        int[][] dp = new int[matrix.length][matrix[0].length];

        // Traverse each cell in the matrix
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                // Start DFS from cells that haven't been visited
                if(dp[i][j] == 0) {
                    longestIncreasingPathRecur(matrix, dp, i, j);
                }
            }
        }

        // Find the maximum path length from the DP table
        int longestPath = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                longestPath = Integer.max(longestPath, dp[i][j]);
            }
        }
        return longestPath;
    }

    private int longestIncreasingPathRecur(int[][] matrix, int[][] dp, int x, int y) {
        // If already computed, return the cached value
        if(dp[x][y] != 0) {
            return dp[x][y];
        }

        // Minimum path length is 1 (the cell itself)
        dp[x][y] = 1;

        // Directions: down, up, left, right
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,-1}, {0,1}};

        for(int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            // Check bounds and increasing condition
            if(isSafe(matrix, nextX, nextY)) {
                if(matrix[nextX][nextY] > matrix[x][y]) {
                    // Recur for neighbor and take max path
                    dp[x][y] = Integer.max(dp[x][y], 1 + longestIncreasingPathRecur(matrix, dp, nextX, nextY));
                }
            }
        }
        return dp[x][y];
    }

    private boolean isSafe(int[][] matrix, int x, int y) {
        // Check if the cell is within bounds
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }
}