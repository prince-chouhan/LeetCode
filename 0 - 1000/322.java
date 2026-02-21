class Solution {
    Integer[][] dp;

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new Integer[n][amount+1];
        int ans = minCoinsNeeded(coins, n - 1, amount);

        return ans != Integer.MAX_VALUE ? ans : -1;
    }

    public int minCoinsNeeded(int[] coins, int n, int am) {

        if (am == 0) return 0;
        if (n < 0) return Integer.MAX_VALUE;

        if (dp[n][am] != null)
            return dp[n][am];

        if (am - coins[n] >= 0) {
            int take = minCoinsNeeded(coins, n, am - coins[n]);
            int notTake = minCoinsNeeded(coins, n - 1, am);

            if (take != Integer.MAX_VALUE)
                return dp[n][am] = Math.min(1 + take, notTake);
            else
                return dp[n][am] = notTake;
        }

        return dp[n][am] = minCoinsNeeded(coins, n - 1, am);
    }
}
