import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1197_최소스패닝트리 {
    static int V, E;
    static List<Edge> edgeList= new ArrayList<>();
    static int[] parents;

    static void make(){
        parents = new int[V+1];
        for(int i = 1; i<=V; i++){
            parents[i] = i;
        }
    }

    static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return false;
        parents[rootB] = rootA;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for(int i = 0; i<E; i++){
            st= new StringTokenizer(br.readLine());
            edgeList.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Collections.sort(edgeList, (e1, e2)-> e1.cost-e2.cost);
        make();

        int result = 0;
        int cnt = 0;
        for(Edge e : edgeList){
            if(union(e.from, e.to)){
                result+= e.cost;
                cnt++;
                if(cnt == V-1) break;
            }
        }
        System.out.println(result);

    }

    static class Edge{
        int to, from, cost;
        Edge(int to, int from , int cost){
            this.to =to;
            this.from = from;
            this.cost = cost;
        }
    }
}
