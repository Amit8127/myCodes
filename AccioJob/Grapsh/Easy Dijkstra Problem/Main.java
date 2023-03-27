import java.util.*;

class Node{
    int v, wt;
    Node(int v, int wt){
        this.v = v;
        this.wt = wt;
    }
}
class nodeComparator implements Comparator<Node>{
    public int compare(Node node1, Node node2){
        return node1.wt - node2.wt;
    }
}
class graph{
    ArrayList<ArrayList<Node>> g = new ArrayList<ArrayList<Node>>();
    graph(int n){
        for(int i=0; i<n; i++){
            g.add(new ArrayList<Node>());
        }
    }
    void addNode(int u, int v, int wt){
        g.get(u).add(new Node(v, wt));
    }

    void findPath(int start, int end){
        // Write your code here
		int n = g.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new nodeComparator());
        pq.add(new Node(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int u = node.v;
            for(Node neighbor: g.get(u)){
                int v = neighbor.v;
                int wt = neighbor.wt;
                if(dist[v] > dist[u] + wt){
                    dist[v] = dist[u] + wt;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
        if(dist[end] == Integer.MAX_VALUE){
            System.out.println("NO");
        }else{
            System.out.println(dist[end]);
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        graph g = new graph(n);
        for(int i=0; i < m; i++){
            int u = input.nextInt(), v = input.nextInt();
            int wt = input.nextInt();
            g.addNode(u-1, v-1, wt);
        }
        int start = input.nextInt(), end = input.nextInt();
        g.findPath(start-1, end-1);

        input.close();
    }
}