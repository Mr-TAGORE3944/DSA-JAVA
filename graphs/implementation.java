package graphs;
import java.util.*;

public class implementation {
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
        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));


        // graph[1].add(new Edge(1, 0));
        // graph[1].add(new Edge(1, 3));


        // graph[2].add(new Edge(2, 0));
        // graph[2].add(new Edge(2, 4));


        // graph[3].add(new Edge(3, 1));
        // graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));


        // graph[4].add(new Edge(4, 2));
        // graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));
        // graph[5].add(new Edge(5, 6));
        // graph[5].add(new Edge(6, 5));

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(6, 0));
        graph[5].add(new Edge(6, 2));




    }

    public static void BFS(ArrayList<Edge> graph[] , int V){
        boolean[] isVisit = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if(isVisit[curr] == false){
                isVisit[curr] = true;
                System.out.print(curr + " ");
                for(int i = 0 ; i < graph[curr].size() ; i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.des);
                }
            }
        }
    }

    public static void BFSAdv(ArrayList<Edge> graph[] ,boolean[] isVisit , int start , int V){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int num = q.remove();
            if (isVisit[num] == false) {
                System.out.print(num + " ");
                isVisit[num] = true;
                for(int i = 0 ; i < graph[num].size() ; i++){
                    Edge e = graph[num].get(i);
                    q.add(e.des);
                }
            }
        }
    }

    public static void DFS(ArrayList<Edge> graph[] , boolean[] isVisit , int curr){
        System.out.print(curr + " ");
        isVisit[curr] = true;
        for(int i = 0 ; i < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(isVisit[curr] == false)
                DFS(graph, isVisit, e.des);
        }
    }
    
    public static void pathSrc2Des(ArrayList<Edge> graph[] , int curr , boolean isVisit[] , String s , int target){
        if(curr == target) {
            System.out.println("0"+ s);
            return;
        }
        for(int i = 0 ; i < graph[curr].size() ;i++){
            Edge e = graph[curr].get(i);
            if(isVisit[curr] == false){
                isVisit[curr] = true;
                pathSrc2Des(graph , e.des , isVisit , s + e.des , target);
                isVisit[curr] = false;
            }
        }
    }
  
    public static boolean findCycle(ArrayList<Edge> graph[] , int curr , boolean[] isVisit , boolean[] res){
        isVisit[curr] = true;
        res[curr] = true;
        for(int i = 0 ; i< graph[curr].size() ;i++){
            Edge e = graph[curr].get(i);
            if(res[e.des]) return true;
            else if(!isVisit[curr]){
                if(findCycle(graph, e.des, isVisit, res)){
                    return true;
                }
            }
        }
        res[curr] = false;

        return false;
    }

    public static void topplogicalOrder(ArrayList<Edge> graph[] , int curr , boolean[] isVisit , Stack<Integer> st){
        isVisit[curr] = true;
        for(int i = 0 ; i < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(!isVisit[curr]){
                topplogicalOrder(graph, e.des, isVisit, st);
            }
        }
        st.push(curr);

        
    }
  

    public static boolean cycleDetectionUndirectedGraph(ArrayList<Edge> graph[] , boolean[] isVisit , int curr  , int parent){
        isVisit[curr] = true;
        
        for(int i = 0 ; i < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(isVisit[e.des] == true && parent != e.des){
                return true;
            }
            else if(!isVisit[curr]){
                if(cycleDetectionUndirectedGraph(graph, isVisit, e.des, curr)){
                    return true;
                }
            }
        }

        return false;
    }
  
  
  
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        // for(int i = 0 ; i < V ;i++){
            //     if(isVisit[i] == false)
            //     DFS(graph, isVisit, i);
            // }
            
            // pathSrc2Des(graph, 0, isVisit, "", 5);
            // System.out.println(findCycle(graph, 0, isVisit, new boolean[V]));
            
            // Stack<Integer> st = new Stack<>();
            // for(int i = 0 ; i < V ; i++){
            //     if(isVisit[i] == false)
            //     topplogicalOrder(graph, i, isVisit, st);
            // }
            // while (!st.isEmpty()) {
            //     System.out.print(st.pop()+" ");
            // }
            boolean isVisit[] = new boolean[V];

            System.out.println(cycleDetectionUndirectedGraph(graph, isVisit, 0, -1));
    }
}
