class Solution {
    public int maxProfit(int[] prices) {
        int b=0, s=1;
        int res=0;
        while(b<prices.length && s<prices.length)
        {
            if(prices[b]<prices[s])
            {
                res = Math.max(res, prices[s]-prices[b]);
            }
            else
            {
                b = s;
            }
            s++;
        }

        return res;
    }
}
