class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();

        for(String s: strs)
        {
            String key = getKey(s);

            if(group.containsKey(key))
            {
                group.get(key).add(s);
            }
            else
            {
                List<String> lis = new ArrayList();
                lis.add(s);
                group.put(key, lis);
            }
        }

        // flatten the structure
        List<List<String>> res = new ArrayList();

        for(Map.Entry<String, List<String>> entry: group.entrySet())
            res.add(entry.getValue());
        

        return res;
    }

    public String getKey(String s)
    {
        int[] freq = new int[26];
        for(char c: s.toCharArray())
        {
            freq[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<26; i++)
        {
            sb.append((char)(i+'a'));
            sb.append(freq[i]);
        }

        return sb.toString();
    }
}
