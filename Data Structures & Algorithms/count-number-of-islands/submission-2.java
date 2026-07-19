class Solution {

    public record Pair<K,V>(K key, V value) {}

    public int numIslands(char[][] grid) {
        int islands = 0;
        int m = grid.length;
        int n = grid[0].length;

        Set<Pair<Integer, Integer>> vis = new HashSet<>();

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j]=='1' && !vis.contains(new Pair(i,j)))
                {
                    dfs(i, j, m, n, grid, vis);
                    islands++;
                }
            }
        }
     return islands;
    }

    public void dfs(int i, int j, int m, int n, char[][] grid, Set<Pair<Integer, Integer>> vis)
    {
        // if(grid[i][j]!='1')
        //     return;
        
        int rowDel[] = new int[]{1, 0, -1, 0};
        int colDel[] = new int[]{0, 1, 0, -1};

        vis.add(new Pair(i,j));

        for(int k=0; k<4; k++)
        {
            int nRow = i+rowDel[k];
            int nCol = j+colDel[k];

            if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && !vis.contains(new Pair(nRow, nCol)) && grid[nRow][nCol]=='1')
                dfs(nRow, nCol, m, n, grid, vis);
        }

        return;

    }

}
