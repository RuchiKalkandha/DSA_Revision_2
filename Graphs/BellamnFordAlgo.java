import java.util.*;
public class BellamnFordAlgo {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-1));

    }
    static void createGraph2(ArrayList<Edge> graph){
        graph.add(new Edge(0,1,2));
        graph.add(new Edge(0,2,4));
        graph.add(new Edge(1,2,-4));
        graph.add(new Edge(2,3,2));
        graph.add(new Edge(3,4,4));
        graph.add(new Edge(4,1,-1));
    }
    public static int[] bellmanFord(ArrayList<Edge> graph[], int src){
        int dist[] = new int[graph.length];
        // initialisation
        for(int i = 0; i<dist.length; i++){
            if(i != src) dist[i] = Integer.MAX_VALUE;

        }
        int V = graph.length;
        // algorithm
        // total E times chl rha h V vala loop, so total time complexity = O(V*E)
        for(int i = 0; i<V-1; i++){ // V times chl rha h, O(V) 
            //for all edges  O(E)
            // O(E) time complexity for these two inner loops.
            // yha hme teen loop dikh rhi h, iski time complexity cube m nhi jaegi, bcz at end hm edge hi nikal rhe h ek ek in loops se, so time colpexity is O(E).
            for(int j = 0; j<graph.length; j++){
                for(int k = 0; k<graph[j].size(); k++){
                    Edge e = graph[j].get(k);
                    // u,v,wt
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    // integer.max_value vali condition hmne islia lgai bcz java, cpp m age hm max integer value m or integer add krenge to fr vo negative value m convert hojaegi.
                    // which will result in wrong results.
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){ // relaxation step
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        return dist;
    }

    // bellman ford 2
    public static int[] bellmanFord2(ArrayList<Edge> graph, int src, int V){
        int dist[] = new int[V];
        // initialisation
        for(int i = 0; i<dist.length; i++){
            if(i != src) dist[i] = Integer.MAX_VALUE;

        }s
        // algorithm
        // total E times chl rha h V vala loop, so total time complexity = O(V*E).
        for(int i = 0; i<V-1; i++){ // V times chl rha h, O(V) 
            //for all edges  O(E)
            for(int j = 0; j<graph.size(); j++){
                    Edge e = graph.get(j);
                    // u,v,wt
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    // integer.max_value vali condition hmne islia lgai bcz java, cpp m age hm max integer value m or integer add krenge to fr vo negative value m convert hojaegi.
                    // which will result in wrong results.
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){ // relaxation step
                        dist[v] = dist[u] + wt;
                    }
            }
        }

        return dist;
    }
    // -------- //

    public static void print(int arr[]){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String args[]){
            int V = 5;
            ArrayList<Edge> graph[] = new  ArrayList[V];
            createGraph(graph);
            int arr[] = bellmanFord(graph, 0);
            print(arr);

            ArrayList<Edge> edges = new ArrayList<>();
            createGraph2(edges);
            int arr2[] = bellmanFord2(edges, 0,V);
            print(arr2);


    }
}
