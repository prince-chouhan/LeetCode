class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 == 1) return false;

        int target = sum / 2;

        dp = new Boolean[nums.length][target + 1];
        return isPossible(nums, nums.length - 1, target);
    }

    public boolean isPossible(int[] nums, int n, int target) {
        if (n < 0) return target == 0;

        if(dp[n][target] != null){
            return dp[n][target];
        }

        if(target - nums[n] >= 0) {
            return dp[n][target] = isPossible(nums, n - 1, target - nums[n]) || isPossible(nums, n - 1, target);
        }
        else {
            return dp[n][target] = isPossible(nums, n - 1, target);
        }
    }
}
