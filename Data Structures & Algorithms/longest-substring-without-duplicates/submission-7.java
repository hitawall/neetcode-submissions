class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int i=0;
        int n = s.length();
        int j=1;

        if(n<=0)
            return maxLen;
        
        set.add(s.charAt(i));

        while(i<n && j<n)
        {
            char c = s.charAt(j);
                // char c = s.charAt(j);

    while (set.contains(c)) {
        set.remove(s.charAt(i));
        i++;
    }

    set.add(c);
    maxLen = Math.max(maxLen, set.size());

    j++;
        }

        maxLen = Math.max(set.size(), maxLen);

        return maxLen;
    }
}
