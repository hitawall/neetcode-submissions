class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet();
        int res = 0;
        for(int i=0; i<nums.length; i++)
        {
            numSet.add(nums[i]);
        }

        for(int i=0; i<nums.length; i++)
        {
            if(!numSet.contains(nums[i]-1))
            {
                if(numSet.contains(nums[i]))
            {
                int track = 1;
                int currNum = nums[i]+1;
                while(numSet.contains(currNum))
                {
                    track++;
                    currNum++;
                }
                res = Math.max(res, track); 
            }
            }
            
        }

        return res;
    }
}
