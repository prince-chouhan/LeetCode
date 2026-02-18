class Solution {
    public int splitNum(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        Arrays.sort(arr);

        int n1 = 0, n2 = 0;

        for(int i = 0; i < arr.length; i++){
            if(i % 2 == 0) {
                n1 = n1 * 10 + (arr[i] - '0');
            } 
            else{
                n2 = n2 * 10 + (arr[i] - '0');
            }
        }
        return n1 + n2;
    }
}
