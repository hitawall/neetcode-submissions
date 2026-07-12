class Solution {
    public int trap(int[] height) {
        int n = height.length;

        if(n<2)
            return 0;
        
        int maxL = height[0];
        int maxR = height[n-1];
        int water = 0;
        int l=0, r=n-1;

        while(l<r)
        {
            int toAdd = 0;
            if(maxL>maxR)
            {
                r--;
                toAdd = Math.min(maxL, maxR)-height[r];
                maxR = Math.max(maxR, height[r]);
            }
            else
            {
                l++;
                toAdd = Math.min(maxL, maxR)-height[l];
                maxL = Math.max(maxL, height[l]);
            }
            water+= Math.max(0,toAdd);
        }
    return water;
    }
}
