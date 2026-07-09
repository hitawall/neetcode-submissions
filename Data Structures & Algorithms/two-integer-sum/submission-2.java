class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tarMap = new HashMap<>();
        
        for(int i=0; i<nums.length; i++)
        {
            int mapKey = target-nums[i];
            Boolean isPresentInMap = tarMap.containsKey(mapKey);

            if(isPresentInMap)
            {
                return new int[]{tarMap.get(mapKey), i};
            }
            else
            {
                tarMap.put(nums[i], i);
            }
        }

        return new int[]{-1,-1};
    }
}
