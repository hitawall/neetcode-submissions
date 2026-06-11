class Solution {
    Map<Integer, Integer> mem = new HashMap();

    public int climbStairs(int n) {
        if(mem.containsKey(n))
            return mem.get(n);

        if(n<0)
            return 0;
        
        if(n==0)
            return 1;

        int val = climbStairs(n-1) + climbStairs(n-2);

        mem.put(n,val);
        return val;

    }
}
