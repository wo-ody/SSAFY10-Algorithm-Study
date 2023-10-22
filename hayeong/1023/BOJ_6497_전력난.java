import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6497_전력난 {
    static int M, N;
    static Edge[] edgeList;

    static int[] parents;

    static void make(){
        parents = new int[M+1];
        for(int i =1; i<=M; i++){
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
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int sum = 0;
        edgeList = new Edge[N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            sum += cost;
            edgeList[i] = new Edge(from, to, cost);
        }
        br.readLine();

        Arrays.sort(edgeList);
        make();

        int result = 0;
        int cnt = 0;
        for(Edge e : edgeList){
            if(union(e.from, e.to)){
                result+=e.cost;
                if(++cnt == M-1) break;
            }
        }
        System.out.println(sum -result);

    }

    static class Edge implements Comparable<Edge>{
        int from, to, cost;
        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
}
