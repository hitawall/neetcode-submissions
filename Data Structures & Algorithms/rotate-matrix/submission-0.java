class Solution {
    public void rotate(int[][] matrix) {
        int l=0, r=matrix.length-1;

        while(l<r)
        {
            for(int i=0; i<r-l; i++)
            {
                int top=l, bottom=r;

                int topLeft = matrix[top][l+i];

                // 1st move
                matrix[top][l+i] = matrix[bottom-i][l];
                //2nd move
                matrix[bottom-i][l] = matrix[bottom][r-i];
                //3rd move
                matrix[bottom][r-i] = matrix[top+i][r];
                //4th move
                matrix[top+i][r] = topLeft;
            }
            r--;
            l++;
        }
    }
}
