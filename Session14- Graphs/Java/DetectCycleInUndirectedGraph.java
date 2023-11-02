//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    boolean checkCycle(int node,int parent,  ArrayList<ArrayList<Integer>> adj, int vis[],int[] parents) {
        
        vis[node] = 1; 
        
        
        for(int nbr: adj.get(node)) {
            if(nbr==parent) //the edge from a node to its parent must not be considered.
            continue;
            if(vis[nbr]==1) //means a cycle has been caught
            return true;
            
            parents[nbr]=node;
            if(checkCycle(nbr,parents[nbr], adj, vis,parents))
            return true;
        }
        
        return false; 
    }
    
    // Function to detect cycle in a directed graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        int vis[] = new int[V]; 
        
        int parents[]=new int[V];
        Arrays.fill(parents,-1);
        for(int i=0; i<V; i++) {
            if(vis[i] == 0) {
                if(checkCycle(i,parents[i], adj, vis,parents) == true){
                    return true;    
                }
            }
        }
        return false; 
    }
}
