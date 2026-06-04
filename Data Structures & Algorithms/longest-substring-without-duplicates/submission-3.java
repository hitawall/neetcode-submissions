class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> track = new HashSet();
        int res = 0;
        int i=0,j=0;

        while(j<s.length())
        {   
            char c = s.charAt(j);
            if(!track.contains(c))
            {
                track.add(c);
                j++;
            }
            else
            {
                res = Math.max(res, track.size());
                track.remove(s.charAt(i));
                i++;
            }
        }

        return Math.max(res,track.size());
    }
}
