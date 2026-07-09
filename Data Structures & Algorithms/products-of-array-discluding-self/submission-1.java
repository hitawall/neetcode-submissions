class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] res = new int[nums.length];

        for(int i=0; i<nums.length; i++)
        {
                res[i] = 1;
                prefix[i]=1;
                suffix[i]=1;
        }
        // prefix[0] = nums[0];
        // suffix[nums.length-1] = nums[nums.length-1];

        //compute prefix and suffix
        for(int i=1; i<nums.length; i++)
        {
            prefix[i] = prefix[i-1]*nums[i-1];
        }

        //compute suffix
        for(int i=nums.length-2; i>=0; i--)
        {
            suffix[i] = suffix[i+1]*nums[i+1];
        }

        //compute answer
        for(int i=0; i<nums.length; i++)
            res[i] = prefix[i]*suffix[i];
        

        return res;
    }
}  
