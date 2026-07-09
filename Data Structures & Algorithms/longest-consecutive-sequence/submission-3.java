class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for(int num: nums)
            numSet.add(num);
        
        int maxLen = 0;

        for(int i=0; i<nums.length; i++)
        {
            int currNum = nums[i];
            int prevNum = currNum-1;

            if(!numSet.contains(prevNum))
            {
                int len=0;
                while(numSet.contains(currNum))
                {
                    currNum++;
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}
