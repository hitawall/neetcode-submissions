class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s: strs)
        {
            int n = s.length();
            sb.append(n);
            sb.append('#');
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> res = new ArrayList<>();

        //find the first # and then get the number splice and then get the length of string, repeat and flush
        int j=0;
        for(int i=0; i<str.length(); i++)
        {
            if(str.charAt(i)=='#')
            {
                String numSlice = str.substring(j, i);
                int len = Integer.parseInt(numSlice);

                res.add(str.substring(i+1, i+1+len));
                
                i = i+1+len;
                j = i;
            }
        }

        return res;
    }
}
