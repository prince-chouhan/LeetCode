class Solution {
    Integer[][]  dp;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new Integer[n][amount + 1];

        return countWays(coins, amount, n - 1);
    }

    public int countWays(int[] coins, int am, int n) {
        if (n < 0) return 0;
        if(am == 0) return 1;

        if(dp[n][am] != null) return dp[n][am];

        if(am - coins[n] >= 0){
            return dp[n][am] = countWays(coins, am - coins[n], n) + countWays (coins, am, n - 1);
        }

        else{
            return dp[n][am] = countWays(coins, am, n - 1);
        }
    }
}
