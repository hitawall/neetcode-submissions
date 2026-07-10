class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;

        int l=0, r=heights.length-1;

        while(l<r)
        {
            maxWater = Math.max(maxWater, (r-l)*Math.min(heights[l], heights[r]));
            
            if(heights[l]<=heights[r])
                l++;
            else
                r--;
        }

        return maxWater;
    }
}
