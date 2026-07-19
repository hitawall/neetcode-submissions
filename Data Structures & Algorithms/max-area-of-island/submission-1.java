class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxIsland = 0;

        int m = grid.length, n=grid[0].length;

        boolean vis[][] = new boolean[m][n];
        final int[][] dir = new int[][]{{0,1}, {1,0}, {-1,0}, {0, -1}};

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(!vis[i][j] && grid[i][j]==1)
                {
                    maxIsland = Math.max(maxIsland, dfs(i,j,m,n,grid,vis,dir));
                }
            }

        }

        return maxIsland;
    }

    public int dfs(int i, int j, int m, int n, int[][] grid, boolean[][] vis, int[][] dir)
    {
        vis[i][j]=true;
         int area = 1;

        for(int[] d: dir)
        {
            int nRow = i+d[0], nCol = j+d[1];

            if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && !vis[nRow][nCol] && grid[nRow][nCol]==1)
                area+= dfs(nRow, nCol, m, n, grid, vis, dir);
        }

        return area;
    }
}
