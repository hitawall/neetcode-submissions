class Solution {
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;

        while(i<j)
        {
            char frontChar = Character.toLowerCase(s.charAt(i));
            char backChar = Character.toLowerCase(s.charAt(j));

            if(Character.isLetterOrDigit(frontChar) && Character.isLetterOrDigit(backChar))
            {
                if(frontChar!=backChar)
                    return false;
                i++;
                j--;
            }

            if(!Character.isLetterOrDigit(frontChar))
                i++;
            
            if(!Character.isLetterOrDigit(backChar))
                j--;

        }

        return true;
    }

    
}
