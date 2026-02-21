class Solution {
    Integer[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;

        for (int num : nums) total += num;

        if (Math.abs(target) > total || (total + target) % 2 != 0)
            return 0;
            
        target = (total + target) / 2;

        dp = new Integer[nums.length][target + 1];

        return isPossible(nums, nums.length - 1, target);
    }

    public int isPossible (int[] nums, int n, int target) {
        if (n < 0) return target == 0 ? 1 : 0;
        if(target < 0) return 0;

        if(dp[n][target] != null) return dp[n][target];

        if(target - nums[n] >= 0)
            return dp[n][target] = isPossible(nums, n - 1, target - nums[n]) + isPossible(nums, n - 1, target);

        else
            return dp[n][target] = isPossible(nums, n - 1, target);
    }
}
