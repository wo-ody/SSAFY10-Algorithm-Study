import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Node> graph = new ArrayList<>();
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        parent=new int[n];

        for(int i=0; i<n; i++) parent[i]=i;

        for(int i =0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int cost = Integer.parseInt(st.nextToken());
                if(i!=j) graph.add(new Node(i,j,cost));
            }
        }

        Collections.sort(graph,(o1,o2)->Integer.compare(o1.cost,o2.cost));
        long answer  =kruskal();
        System.out.println(answer);

    }

    public static long kruskal(){
        long result = 0;
        for(Node node : graph){
            if(findParent(node.x) != findParent(node.y)){
                union(node.x, node.y);
                result+= node.cost;
            }
        }
        return result;
    }

    public static void union(int x, int y){
        x=findParent(x);
        y=findParent(y);

        if(x!=y)parent[x]=y;
    }

    public static int findParent(int x){
        if(parent[x]==x) return x;
        return parent[x]= findParent(parent[x]);
    }
    static class Node{
        int x,y,cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
