class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length()==0)
            return 0;
        
        int[] freq = new int[26];

        char currMaxChar=s.charAt(0);
        int currMaxFreq=1;
        int res=1;
        freq[currMaxChar-'A']+=1;



        int i=0,j=1, n=s.length();

        while(j<n && i<j)
        {
            char curChar = s.charAt(j);
            freq[curChar-'A']+=1;

            if(freq[curChar-'A']>currMaxFreq)
            {
                currMaxFreq = freq[curChar-'A'];
                currMaxChar = curChar;
            }

            int winSize = j-i+1;

            int reqRep = winSize-currMaxFreq;

            if(reqRep<=k)
            {
                res = Math.max(res, winSize);
            }
            else
            {
                while(i<j && reqRep>k)
                {
                    char toRemC = s.charAt(i);
                    freq[toRemC-'A']--;
                    if(toRemC==currMaxChar)
                    {
                        currMaxChar = getMaxFromFreq(freq);
                        currMaxFreq = freq[currMaxChar-'A'];
                    }
                    i++;
                    winSize = j-i+1;
                    reqRep = winSize-currMaxFreq;
                }
            }
            j++;
        }

        return res;
        
    }

    public static char getMaxFromFreq(int[] freq)
    {
        int res = 0;
        Character resChar=null;
        for(int i=0; i<freq.length; i++)
        {
            if(freq[i]>res)
            {
                res = freq[i];
                resChar = (char) (i+'A');
            }
        }

        return resChar;
    }
}
