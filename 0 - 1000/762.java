class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        HashSet<Integer> prime = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19)); 

        while(left <= right) {
            if(prime.contains(Integer.bitCount(left)))
                ans++;
            left++;
        }
        return ans;
    }
}
