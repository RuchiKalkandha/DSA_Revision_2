import java.util.* ;
public class creatingGraph {
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
    // cycle detection code using dfs
    // O(V+E) time complexity
    public static boolean detectCycle(ArrayList<Edge> [] graph){
        boolean vis[] = new boolean[graph.length];
        // for connected components
        for(int i = 0; i<graph.length; i++){
            if(!vis[i]) if(detectCycleUtil(graph, vis, i, -1)) return true;
            // agr ek bhi cycle mil jae to true return krna h
            // agr he jgh dekhne k bd bhi cycle na mile tbh false return krna h
            // islia upr if cond likhi h, agr true return kra h detectCycleUtil n tbhi true hm return krenge
            // agr usne false return kra to hm aage chlte rhenge, false abhi return nhi krenge, kya pta aage cycle ho.
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par){
        vis[curr] = true;
        for(int i = 0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            // Case 3:
            if(!vis[e.dest]) {if(detectCycleUtil(graph, vis, e.dest, curr)) return true;}
            // Case 1:
            else if(vis[e.dest] && e.dest != par) return true;
            // case 2 , do nothing, continue
        }
        return false;
    }
    // class pair for dikstras algo
    static class Pair implements Comparable<Pair>{
        int n; // storing node
        int path; // storing path
        public Pair(int n, int path){
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path;
        }
    }
    // O(V+ElogV) time complexity
    // boolean, vis loops ki vjh se V time complexity aai h.
    // internal sorting jo hui h pq m   , unki vjh se additional ElogV time complexity aai h.
    // if we do it wihtout using pq, and again and again find shortest by loop, time complexity will be O(V*V)
    public static void shortest_path_using_dijkstras_algo(ArrayList<Edge>[] graph, int src){
          int dist[] = new int[graph.length]; //dist[i] -> src to i
          boolean vis[] = new boolean[graph.length];
          for(int i = 0; i<graph.length; i++){
            // src to src dist to zero hi hota h, usko kuch ni krna
            if(i != src){
                dist[i] = Integer.MAX_VALUE;   //+infinity
            }
          }
          PriorityQueue<Pair> pq = new PriorityQueue<>();
          pq.add(new Pair(src, 0));
          

          while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.n]){
                vis[curr.n] = true;
                // neighbours
                for(int i = 0; i<graph[curr.n].size(); i++){
                        Edge e = graph[curr.n].get(i);
                        int  u = e.src;
                        int v = e.dest;
                        int wt = e.wt;
                        if((dist[u] + wt) < dist[v]){ // updated dist of src to v
                            dist[v] = dist[u] + wt;
                            pq.add(new Pair(v,dist[v]));
                        }       
                }
            }
          }
        //   print all src to vertices path
        for(int i = 0; i<dist.length; i++){
            System.out.print(dist[i] + " ");
        }
    }
    public static void main(String args[]){
        int V = 5;
         ArrayList<Edge>[] graph = new ArrayList[V];
         ArrayList<Edge>[] graph2 = new ArrayList[6];
        //  abhi hr ek array index p null stored h.
        // sbse phle initailise krke hr jgh ek empty arraylist define krenge.
        for(int i = 0; i<V; i++){
            graph[i] = new ArrayList<>();
        }
        //  0 vertex
        graph[0].add(new Edge(0,1,5));
        // 1 vertex
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));
        // 2 vertex
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));
        // 3 vertex
        graph[3].add(new Edge(3,2,1));
        graph[3].add(new Edge(3,1,3));
        // 4 vertex
        graph[4].add(new Edge(4,2,2));

        // 2's neighbours
        for(int i = 0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i); //src, dest, wt
            System.out.println(e.dest);
        }
        System.out.println(detectCycle(graph));

        // graph 2(for dijkstra's algorithm)
        // sbse phle initailise krke hr jgh ek empty arraylist define krenge.
        for(int i = 0; i<6; i++){
            graph2[i] = new ArrayList<>();
        }
        graph2[0].add(new Edge(0,1,2));
        graph2[0].add(new Edge(0,2,4));

        graph2[1].add(new Edge(1,3,7));
        graph2[1].add(new Edge(1,2,1));

        graph2[2].add(new Edge(2,4,3));

        graph2[3].add(new Edge(3,5,1));

        graph2[4].add(new Edge(4,3,2));
        graph2[4].add(new Edge(4,5,5));


        shortest_path_using_dijkstras_algo(graph2, 0);
        
    }
}

