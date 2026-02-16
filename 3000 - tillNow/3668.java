class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int f : friends){
            set.add(f);
        }

        int j = 0;
        for(int i : order){
            if(set.contains(i)){
                friends[j] = i;
                j++;
            }
        }
        return friends;
    }
}