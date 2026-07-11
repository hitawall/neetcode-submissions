class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        //create a graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=0; i<n; i++)
        {
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++)
        {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        Set<Integer> vis = new HashSet<>();

        if(!dfs(0, -1, graph, vis))
            return false;

        if(vis.size()!=n)
            return false;

        return true;
    }

    public boolean dfs(int node, int parent, Map<Integer, List<Integer>> graph, Set<Integer> vis)
    {

        if(vis.contains(node))
            return false;
        
        vis.add(node);

        List<Integer> neigh = graph.get(node);

        for(int i=0; i<neigh.size(); i++)
        {
            if(neigh.get(i)==parent)
                continue;
            
            if(!dfs(neigh.get(i), node, graph, vis))
                return false;
        }
        

        return true;
    }
}
