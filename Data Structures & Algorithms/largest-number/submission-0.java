class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] stringNums = new String[n];

        for(int i=0; i<n; i++)
            stringNums[i] = (String.valueOf(nums[i]));
        
        Arrays.sort(stringNums, new StringComp());
        
        if (stringNums[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++)
            sb.append(stringNums[i]);
        
        return sb.toString();

    }

    class StringComp implements Comparator<String> {
        public int compare(String s1, String s2)
        {
            return  (s1+s2).compareTo(s2+s1)*-1;

           
        }
    }
}