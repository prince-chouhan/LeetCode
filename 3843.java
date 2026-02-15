class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean[] bool = new boolean[100001];
        Arrays.fill(bool, true);
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();

        for(int num : map.keySet()){
            int freq = map.get(num);
            
            if(set.contains(freq)){
                bool[freq] = false;
            }
            set.add(map.get(num));
        }

        for(int num : nums){
            if(bool[map.get(num)]){
                return num;
            }
        }
        return -1;
    }
}