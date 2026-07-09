class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[k];

        List<Integer>[] bucket = new List[n+1];

        Map<Integer, Integer> freq = new HashMap<>();

        for(int i=0; i<n; i++)
        {
            if(freq.containsKey(nums[i]))
                freq.put(nums[i], freq.get(nums[i])+1);
            else
                freq.put(nums[i], 1);
        }

        //making buckets
        for(Map.Entry<Integer, Integer> entry: freq.entrySet())
        {
            int count = entry.getValue();
            int num = entry.getKey();

            if(bucket[count]!=null)
            {
                bucket[count].add(num);
            }
            else
            {
                bucket[count] = new ArrayList<>();
                bucket[count].add(num);
            }
        }

        //fetching top k
        int m = 0;
        for(int i=n; i>0; i--)
        {
            if(m!=k)
            {
                int j=0;
                while(m<k && bucket[i]!=null && j<bucket[i].size())
                {
                    res[m++] = bucket[i].get(j);
                    j++;
                }
            }
            else
            {
                break;
            }
        }

        //converting array to list
        return res;
    }
}
