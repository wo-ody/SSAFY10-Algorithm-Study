import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_7465_창용마을무리의개수 {
    static int T, N, M;
    static int p[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            sb.append("#"+t+" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            //부모 배열 초기화
            p = new int[N+1];
            makeSet();

            //Node 입력받기
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                union(s, e);
            }

            int cnt = 0;
            for(int i=1; i<=N; i++){
                if(p[i]==i) cnt++;
            }

            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }

    static void makeSet(){
        for(int i=1; i<=N; i++){
            p[i] = i;
        }
    }

    static int find(int x){
        if(p[x] == x) return x;
        else return p[x] = find(p[x]);
    }

    static boolean union(int s, int e){
        int ps = find(s);
        int pe = find(e);

        if(ps == pe) return false;
        if(ps > pe) p[pe] = ps;
        else p[ps] = pe;
        return true;
    }

}
