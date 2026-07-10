class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++)
        {
            int j=i+1, k=nums.length-1;
            

            while(j<k)
            {
                int sum = nums[i]+nums[j]+nums[k];

            if(sum==0)
            {
                res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                while(j+1<n && nums[j]==nums[j+1])
                    j++;
                j++;
            }
            else if(sum<0)
            {
                j++;
            }
            else
            {
                k--;
            }
            }

            // skip all duplicate i
            while(i+1<n && nums[i]==nums[i+1])
                i++;
            
        }

        return res;
    }
}
