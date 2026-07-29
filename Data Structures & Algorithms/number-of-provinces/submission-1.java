class DSU {
    int[] Parent, Size;
    int components;

    public DSU(int n){
        Parent = new int[n];
        Size = new int[n];

        components = n;

        for(int i=0; i<n; i++)
        {
            Parent[i] = i;
            Size[i] = 1;
        }

    }

    public int find(int node)
    {
        if(Parent[node]!=node)
            Parent[node] = find(Parent[node]);
        
        return Parent[node];
    }

    public boolean union(int u, int v)
    {
        int pu = find(u), pv = find(v);

        if(pu==pv)
            return false;
        
        components--;

        if(Size[pu]<Size[pv])
        {
            Size[pv] += Size[pu];
            Parent[pu] = pv;
        }
        else
        {
            Size[pu] += Size[pv];
            Parent[pv] = pu;
        }

        return true;
    }

    public int getComponents() {
        return components;
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(isConnected[i][j]==1)
                    dsu.union(i,j);
            }
        }

        return dsu.getComponents();
    }
}