package graphs;

import java.util.ArrayList;

import trees.minimumdepth;

public class tarjansalgorithm {
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
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));


        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));

    }
    public static void dfs(ArrayList<Edge> graph[] , int  curr , boolean[] vis , int[] dt , int low[] , int time , int par){
        vis[curr] = true;
        low[curr] = dt[curr] = ++time;
        for(int i= 0 ; i < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(e.des == par){
                continue;
            }else if(!vis[e.des]){
                dfs(graph, e.des, vis, dt, low, time, curr);
                low[curr] = Math.min(low[curr], low[e.des]);
                if(dt[curr] < low[e.des]){
                    System.out.println(curr + "---------" + e.des);
                }
            }else{
                low[curr] = Math.min(low[curr], dt[e.des]);
            }
        }
    }





    public static void getBridge(ArrayList<Edge> graph[] , int V){
        int[] dt = new int[V];
        int[] low = new int[V];
        boolean[] vis = new boolean[V];
        for(int i = 0 ; i < V ; i++){
            if(!vis[i]){
                dfs(graph , i , vis , dt , low , 0 , -1);
            }
        }

    }


    public static void tarjanAlgorithm(ArrayList<Edge> graph[] , int curr ,boolean[] vis ,int[] dt , int[] low , int par , int time , boolean[] ap){
        vis[curr] = true;
        low[curr] = dt[curr] = ++time;
        int child = 0;

        for(int i = 0 ; i < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            int neigh = e.des;
            if(neigh == par){
                continue;
            }else if(vis[neigh]){
                low[curr] = Math.min(low[curr], dt[neigh]);
            }else{
                tarjanAlgorithm(graph, neigh, vis, dt, low, curr, time, ap);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(dt[curr] <= low[neigh] && par != -1){
                    ap[curr] = true;
                }
                child++;
            }
        }
        if(par == -1 && child > 1){
            ap[curr] = true;
        }
    }




    public static void getArticulation(ArrayList<Edge> graph[] , int V){
        int[] dt = new int[V];
        int[] low = new int[V];
        boolean[] vis = new boolean[V];
        int time = 0;
        boolean[] ap = new boolean[V];
        for(int i = 0 ; i < V ; i++){
            if(!vis[i]){
                tarjanAlgorithm(graph, i , vis , dt , low , -1, time , ap);
            }
        }
        for(int i = 0 ; i < V ; i++){
            if(ap[i]){
                System.out.println(i);
            }
        }

    }


            public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        // getBridge(graph, V);
        getArticulation(graph, V);


    }
}
