class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charCount = new int[26];
        int m = s.length();
        int n = t.length();

        if(m!=n)
            return false;
        
        for(int i=0; i<m; i++)
        {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            charCount[sChar-'a']++;
            charCount[tChar-'a']--;
        }

        for(int i=0; i<26; i++)
        {
            System.out.println(String.valueOf(charCount[i]));
            if(charCount[i]!=0)
                return false;
        }
        

        return true;
    }
}
