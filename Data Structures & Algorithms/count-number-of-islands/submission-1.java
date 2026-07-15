class Solution {
    public int numIslands(char[][] grid) {
        int[][] directions = {{0,1}, {1,0}, {-1, 0}, {0, -1}};

        int m = grid.length, n = grid[0].length;
        int islands = 0;

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j]=='1')
                {
                    bfs(i,j,m,n,grid,directions);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void bfs(int i, int j, int m, int n, char[][] grid, int[][] directions) {
        Queue<int[]> q = new LinkedList<>();
        grid[i][j] = '0';

        q.add(new int[]{i, j});

        while(!q.isEmpty())
        {
            int[] node = q.poll();
            int row = node[0], col = node[1];

            for(int[] dir: directions)
            {
                int nr = row+dir[0], nc = col+dir[1];

                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1')
                {
                     q.add(new int[]{nr, nc});
                     grid[nr][nc] = '0';
                }
            }
        }
    }
}
