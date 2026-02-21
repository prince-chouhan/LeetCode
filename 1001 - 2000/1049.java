class Solution {
    Boolean dp[][];

    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int num : stones) total += num;

        dp = new Boolean[stones.length][total + 1];

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= total / 2; i++) {
            if (isPossible(stones, stones.length - 1, i)) {
                min = Math.min(min, total - 2 * i);
            }
        }

        return min;
    }

    public boolean isPossible(int[] nums, int n, int target) {
        if (n < 0) return target == 0;
        if (target < 0) return false;

        if (dp[n][target] != null) return dp[n][target];

        if (target >= nums[n])
            return dp[n][target] = isPossible(nums, n - 1, target - nums[n]) || isPossible(nums, n - 1, target);

        return dp[n][target] = isPossible(nums, n - 1, target);
    }
}
