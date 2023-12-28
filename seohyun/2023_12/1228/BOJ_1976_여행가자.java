import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] adj;
    static int[][] record;

    static int[] plan;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new int[N][N];
        record = new int[N][N];
        plan = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                adj[i][j] = num;
                record[i][j] = num;
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        // 시작
        System.out.println(simulation());
    }

    static void BFS(int start){
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            record[start][cur] = 1;
            record[cur][start] = 1;

            for (int i = 0; i < N; i++) {
                int nxt = adj[cur][i];
                if(nxt == 0 || visited[i]) continue;

                q.add(i);
                visited[i] = true;
            }
        }
    }

    static String simulation(){

        for (int i = 0; i < N; i++) {
            BFS(i);
        }

        for (int i = 0; i < M - 1; i++) {
            if(record[plan[i]][plan[i+1]] == 0){
                return "NO";
            }
        }

        return "YES";
    }
}
