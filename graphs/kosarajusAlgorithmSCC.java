package graphs;

import java.util.ArrayList;
import java.util.Stack;

public class kosarajusAlgorithmSCC {
        public static class Edge {
        int src;
        int des;
        Edge(int sec , int des){
            this.src = src;
            this.des = des;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void topsort(ArrayList<Edge> graph[] , int curr , boolean[] vis , Stack<Integer> st){
        vis[curr] =  true;
        for(int i = 0 ; i < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(!vis[curr]){
                topsort(graph, e.des, vis, st);
            }
        }
        st.push(curr);
    }

    public static void DFS(ArrayList<Edge> graph[] , int curr , boolean[] vis){
        vis[curr] = true;
        System.out.print(curr + " ");
        for(int i = 0 ; i < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(!vis[curr]){
                DFS(graph, e.des, vis);
            }
        }
    }


    public static void implementation(ArrayList<Edge> graph[], int V){
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        // step -1

        for(int i =  0; i  < V ; i++){
            if(!vis[i]){
                topsort(graph , i , vis , st);
            }
        }




        //step -2

        ArrayList<Edge> trans[] = new ArrayList[V];
        for(int i = 0 ; i < graph.length ; i++){
                        vis[i ] = false;
             trans[i] = new ArrayList<Edge>();
        }




        for(int i = 0 ; i < V ; i++){
            for(int j = 0 ; i < graph[i].size() ; i++){
                Edge e = graph[i].get(j);
                trans[e.des].add(new Edge(e.des, e.src));
            }
        }

        while (!st.isEmpty()) {
            int curr = st.pop();
            if(!vis[curr]){
                DFS(trans, curr, vis);
                System.out.println();
            }
        }
    }

        public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        implementation(graph, V);

    }
}
