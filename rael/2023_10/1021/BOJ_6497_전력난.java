import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_6497_전력난 {
    static int N, M;
    static PriorityQueue<Edge> pq;
    static int parent[];    //서로소
    static StringBuilder sb = new StringBuilder();

    static class Edge{
        int v1, v2, c;

        public Edge(int v1, int v2, int c){
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }
    }

    static void makeSet(){
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }
    }
    static int find(int x){
        if(x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }
    static boolean union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px == py) return false;
        if(px < py) parent[py] = px;
        else parent[px] = py;
        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N==0 && M==0) break;

            pq = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);

            int sum = 0;        //전력 총 합
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                pq.add(new Edge(v1, v2, c));
                sum += c;
            }

            //서로소 초기화
            parent = new int[N+1];
            makeSet();

            //최소 찾기
            int cnt = 0;
            while(!pq.isEmpty()){
                Edge e = pq.poll();
                if(union(e.v1, e.v2)) cnt += e.c;
            }

            sb.append(sum-cnt+"\n");
        }
        System.out.println(sb);
    
    }
}
