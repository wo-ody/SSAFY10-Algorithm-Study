import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 효율적인해킹 {
    static int n, m, cnt;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i<n+1; i++){
            list.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(end).add(start);
        }

        int[] result = new int[n+1];
        int maxCnt = Integer.MIN_VALUE;
        for(int i = 1; i<=n; i++){
            cnt = 0;
            visited = new boolean[n+1];
            bfs(i);
            result[i] = cnt;
            maxCnt = Math.max(maxCnt, cnt);
        }

        StringBuffer sb = new StringBuffer();

        for(int i = 1; i<=n; i++){
            if(result[i] == maxCnt){
                sb.append(i+" ");
            }
        }
        System.out.println(sb.toString());

    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i : list.get(cur)) {
                if(!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
    }
}
