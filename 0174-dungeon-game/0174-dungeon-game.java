class Solution {
    int m;
    int n;
    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;
        int[][] dp = new int[m][n];
        for(int[] it: dp) {
            Arrays.fill(it,Integer.MAX_VALUE);
        }
        int res = dfs(0,0,dungeon,dp);
        return res;
    }
    private int dfs(int r, int c, int[][] dungeon, int[][] dp) {
        if(r == m-1 && c == n-1) {
            int pow = dungeon[r][c];
            if(pow < 0) {
                return Math.abs(pow)+1;
            }
            return 1;
        }

        if(dp[r][c] != Integer.MAX_VALUE) {
            return dp[r][c];
        }

        int minPow = Integer.MAX_VALUE;
        int nr = r+1;
        int nc = c+1;
        if(nr < m) {
            minPow = Math.min(minPow, dfs(nr,c,dungeon,dp));
        }
        if(nc < n) {
            minPow = Math.min(minPow, dfs(r,nc,dungeon,dp));
        }

        int currPow = dungeon[r][c];

        if(currPow > 0) {
            if(currPow < minPow) {
                minPow -= currPow;
            }else {
                minPow = 1;
            }
        }else {
            minPow += Math.abs(currPow);
        }

        dp[r][c] = minPow;
        return minPow;
    }
}