class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int l=0, r=ROWS*COLS-1;

        while(l<=r)
        {
            int m = l + (r-l)/2;

            int tarRow = m / COLS;
            int tarCol = m % COLS;

            if(target>matrix[tarRow][tarCol])
            {
                
                l = m+1;
            }
            else if(target<matrix[tarRow][tarCol])
            {
                r = m-1;
            }
            else
            {
                return true;
            }
        }

        return false;
    }
}
