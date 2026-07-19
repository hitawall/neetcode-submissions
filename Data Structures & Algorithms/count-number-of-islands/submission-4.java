class Solution {
    public record Pair<K,V> (K key, V value) {}

    public int numIslands(char[][] grid) {
        int islands = 0;
        int m = grid.length, n = grid[0].length;
        final int[][] dir = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        boolean[][] vis = new boolean[m][n];

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j]=='1' && !vis[i][j])
                {
                    bfs(i,j,m,n,grid,vis,dir);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void bfs(int i, int j, int m, int n, char[][] grid, boolean[][] vis, int[][] dir)
    {

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        q.add(new Pair(i,j));

        while(!q.isEmpty())
        {
            Pair<Integer, Integer> currP = q.poll();
            int currRow = currP.key(), currCol = currP.value();

            vis[currRow][currCol] = true;

            for(int[] d: dir)
            {
                int nRow = currRow+d[0], nCol = currCol+d[1];

                if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && grid[nRow][nCol]=='1' && !vis[nRow][nCol])
                    q.add(new Pair(nRow, nCol));
            }
        }

        return;
    }
}
