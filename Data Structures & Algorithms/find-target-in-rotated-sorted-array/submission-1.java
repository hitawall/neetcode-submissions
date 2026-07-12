class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l=0,r=n-1;

        while(l<=r)
        {
            int mid = (l+r)/2;
            if(nums[mid]==target)
                return mid;
            //left sorted portion
            if(nums[l]<=nums[mid])
            {
                if(target<nums[mid] && target>=nums[l])
                {
                    r = mid-1;
                }
                else
                {
                    l=mid+1;
                }
            }
            
            //right sorted portion
            if(nums[mid]<=nums[r])
            {
                if(target>nums[mid] && target<=nums[r])
                {
                    l = mid+1;
                }
                else
                {
                    r = mid-1;
                }
            }
            //neither?
        }

        return -1;
    }
}
