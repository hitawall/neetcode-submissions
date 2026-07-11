class Solution {
    public int countComponents(int n, int[][] edges) {
        //make a graph first
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> vis = new HashSet<>();
        int comp = 0;

        for(int i=0; i<n; i++)
        {
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++)
        {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        for(int i=0; i<n; i++)
        {
            if(!vis.contains(i))
            {
                comp++;
                dfs(i, graph, vis);
            }
        }
        return comp;
    }

    public void dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> vis)
    {
        if(vis.contains(node))
            return;

        vis.add(node);
        List<Integer> neigh = graph.get(node);

        for(int i=0; i<neigh.size(); i++)
            dfs(neigh.get(i), graph, vis);
        
        return;
    }
}
