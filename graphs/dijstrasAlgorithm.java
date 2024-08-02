package graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijstrasAlgorithm {
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

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0 ; i < graph.length ; i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1,2));
        graph[0].add(new Edge(0, 2,4));

        graph[1].add(new Edge(1, 3,7));
        graph[1].add(new Edge(1, 2,1));

        graph[2].add(new Edge(2, 4,3));
        graph[3].add(new Edge(3, 5,1));
        graph[4].add(new Edge(4, 3,2));
        graph[4].add(new Edge(4, 5,5));
    }



    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        Pair(int num , int dist){
            this.dist = dist;
            this.node = num;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }
    }

    public static void implement(ArrayList<Edge> graph[] , int src  , int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[V];
        for(int i = 0 ; i < V ; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean[] isVisit = new boolean[V];
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!isVisit[curr.node]){
                isVisit[curr.node] = true;
                for(int i = 0 ; i < graph[curr.node].size() ; i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.des;
                    if(dist[u] + e.wt < dist[v]){
                        dist[v] = dist[u] + e.wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for(int i = 0 ; i < V ; i++){
            System.out.print(dist[i]+ " ");
        }
    }
public static void main(String[] args) {
            int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        implement(graph, 0, V);


}


}
