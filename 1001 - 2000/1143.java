class Solution {
    Integer[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        dp = new Integer[text1.length()][text2.length()];
        return helper (text1, text1.length() - 1, text2, text2.length() - 1);
    }

    public int helper (String s1, int n1, String s2, int n2) {
        if (n1 < 0 || n2 < 0) return 0;

        if(dp[n1][n2] != null) return dp[n1][n2];
        
        if (s1.charAt(n1) == s2.charAt(n2)){
            return dp[n1][n2] = 1 + helper (s1, n1 - 1, s2, n2 - 1);
        }


        return dp[n1][n2] = Math.max(helper (s1, n1, s2, n2 - 1), helper (s1, n1 - 1, s2, n2));
    }
}
