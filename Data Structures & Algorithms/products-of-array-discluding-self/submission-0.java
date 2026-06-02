class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] res = new int[nums.length];
        int prodSoFar = 1;
        prefix[0] = 1;
        suffix[nums.length-1] = 1;

        for(int i=1; i<nums.length; i++)
        {
            prefix[i] = prodSoFar*nums[i-1];
            prodSoFar = prefix[i];
        }

        prodSoFar = 1;

        for(int i=nums.length-2; i>=0; i--)
        {
            suffix[i] = prodSoFar*nums[i+1];
            prodSoFar = suffix[i];
        }

        for(int i=0; i<nums.length; i++)
        {
            res[i] = prefix[i]*suffix[i];
        }

        return res;

    }
}  
