package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class primsMSTalgorithm {
    public static class Edge {
        int src;
        int des;
        int wt;
        Edge(int sec , int des , int wt){
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }

    public static class Pair implements Comparable<Pair> {
        int node;
        int cost;
        Pair(int node , int cost){
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
        
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1,10));
        graph[0].add(new Edge(0, 2,15));
        graph[0].add(new Edge(0, 3,30));

        graph[1].add(new Edge(1, 0,10));
        graph[1].add(new Edge(1, 3,40));

        graph[2].add(new Edge(2, 0,15));
        graph[2].add(new Edge(2, 3,50));
        graph[3].add(new Edge(3, 1,40));
        graph[3].add(new Edge(3, 2,50));
    }


    public static void implement(ArrayList<Edge> graph[] , int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int finalCost = 0;
        boolean[] vis = new boolean[V];
        pq.add(new Pair(0,0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node] = true;
                finalCost += curr.cost;
                for(int i = 0 ; i < graph[curr.node].size() ; i++){
                    Edge e = graph[curr.node].get(i);
                    if(!vis[e.des]){
                        pq.add(new Pair(e.des, e.wt));
                    }
                }
            }
        }
        System.out.println(finalCost);
    }



    public static void main(String[] args) {
            int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        implement(graph,  V);


}
}
