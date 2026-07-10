class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        int n=s.length();
        if(n<1)
            return true;
        
        int i=0;
        while(i<n)
        {
            char c = s.charAt(i);

            if(c=='(' || c=='{' || c=='[')
                stack.add(c);
            else 
                {
                   if(stack.empty())
                    return false;
                   char top = getComp(c);

                   if(stack.peek()==top){
                    stack.pop();
                   } 
                   else
                    return false;
            
                }
            
            i++;
        }

        return stack.size()==0;

    }

    public char getComp(char c)
    {
        if(c==')')
            return '(';
        else if(c==']')
            return '[';
        else
            return '{';
    }
}
