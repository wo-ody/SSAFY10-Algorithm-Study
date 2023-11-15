import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크연결 {
    static int N, M, res;
    static PriorityQueue<Edge> pq = new PriorityQueue<>((e1,e2)-> e1.c-e2.c);

    static class Edge{
        int v1, v2, c;

        public Edge(int v1, int v2, int c){
            super();
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }
    }
    //서로소를 위한 변수
    static int parent[];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        //초기화
        res = 0;
        parent = new int[N+1];      //0 dummy

        //간선 큐에 넣기
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Edge(v1,v2,c));
        }

        //풀이
        //서로소 부모 배열 초기화
        setParent();

        //큐 빌 때까지 최소 비용 구하기
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            //사이클 존재 x라면 연결
            if(union(curr.v1, curr.v2)){
                res += curr.c;
            }
        }

        //답 출력
        System.out.println(res);
    }

    //부모 배열 초기화
    static void setParent(){
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }
    }

    //부모 찾기
    static int find(int x){
        if(x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }

    //두 요소 합치기
    static boolean union(int x, int y){
        int px = find(x);
        int py = find(y);

        //사이클 확인
        if(px == py) return false;
        //아니라면 부모 변경
        if(px < py) parent[py] = px;
        else parent[px] = py;
        return true;
    }
}
