class Solution {
    public boolean isValid(String s) {
        Stack<Character> match = new Stack();

        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            int bType = bracketType(c);

            if(bType==0)
            {
                match.push(c);
            }
            else
            {
                if(!match.isEmpty() && getComplement(match.peek())==c)
                    match.pop();
                else
                    return false;
            }

        }

        return match.isEmpty();
        
    }

    public Character getComplement(Character c)
    {
        if (c=='{')
            return '}';
        else if (c=='[')
            return ']';
        else if (c=='(')
            return ')';
        else
            return ' ';
    }

    public int bracketType(Character c)
    {
        if(c=='{' || c=='(' || c=='[')
            return 0;
        else
            return 1;
    }
}
