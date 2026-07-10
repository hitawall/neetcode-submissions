class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int l=0,r=1;
        int n = prices.length;

        while(l<n && r<n)
        {
            int profit = prices[r]-prices[l];

            if(profit<0)
            {
                l=r;
                r++;
            }
            else
            {
                res = Math.max(res, profit);
                r++;
            }
        }

        return res;
    }
}
