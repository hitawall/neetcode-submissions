class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int res=0;
        int i=0,j=0;
        int maxFreq=0;

        while(j<s.length() && i<=j)
        {
            char c = s.charAt(j);
            freq[c-'A']++;
            maxFreq = Math.max(maxFreq, freq[c-'A']);
            int testVal = j-i+1-maxFreq;

            if(k>=testVal)
            {
                  res = Math.max(res, j-i+1);
                  j++;
            }
            else
            {
                c = s.charAt(i);
                freq[c-'A']--;
                i++;
                j++;
                maxFreq = calculateMaxFreq(freq);

            }
        }
        return res;
    }

    public int calculateMaxFreq(int[] freq)
    {
        int res = 0;
        for(int i=0; i<freq.length; i++)
        {
            res = Math.max(res, freq[i]);
        }

        return res;
    }
}
