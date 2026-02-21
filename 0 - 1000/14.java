class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) 
            return "";

        if (strs.length == 1) 
            return strs[0];

        StringBuilder s = new StringBuilder();

        int i = 0;

        while (i < strs[0].length() && i < strs[1].length()) {
            if (strs[0].charAt(i) == strs[1].charAt(i)) {
                s.append(strs[0].charAt(i));
                i++;
            } 
            else {
                break;
            }
        }

        if (s.length() == 0) 
            return "";

        String prefix = s.toString();

        for (int j = 2; j < strs.length; j++) {

            int k = 0;
            while (k < prefix.length() && k < strs[j].length() && prefix.charAt(k) == strs[j].charAt(k)) {
                k++;
            }

            prefix = prefix.substring(0, k);

            if (prefix.isEmpty()) 
                return "";
        }

        return prefix;
    }
}
