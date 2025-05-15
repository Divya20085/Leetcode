class Solution {
    public boolean match(int i, int j, String s, String p,Boolean[][] dp) {
        if (i < 0 && j < 0) return true;
        if (j < 0) return false;
      
        if (i < 0) return p.charAt(j) == '*' && match(i, j - 1, s, p,dp);
        if(dp[i][j]!=null)return dp[i][j];
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dp[i][j]= match(i - 1, j - 1, s, p,dp);
        }
        if (p.charAt(j) == '*') {
            return dp[i][j]=match(i, j - 1, s, p,dp) || match(i - 1, j, s, p,dp);
        }
        return dp[i][j]=false;
    }
    public boolean isMatch(String s, String p) {
        Boolean[][] dp=new Boolean[s.length()][p.length()];
        return match(s.length() - 1, p.length() - 1, s, p,dp);
    }
}