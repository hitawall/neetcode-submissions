class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length==0)
        {
            return Arrays.asList(new ArrayList<>());
        }

        List<List<Integer>> perm = permute(Arrays.copyOfRange(nums, 1, nums.length));

        List<List<Integer>> res = new ArrayList<>();

        for(List<Integer> p: perm)
        {
            for(int i=0; i<=p.size(); i++)
            {
                List<Integer> copyP = new ArrayList<>(p);
                copyP.add(i,nums[0]);
                res.add(copyP);
            }
        }

        return res;
    }
}
