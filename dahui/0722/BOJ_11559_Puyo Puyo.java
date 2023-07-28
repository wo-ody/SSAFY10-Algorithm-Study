import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2606 {
    static boolean[] check; //방문 체크
    static int[][] arr; //노드 간 연결

    static int node,line;
    static int ans = 0;
    static int start = 1;

    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        arr = new int[node+1][node+1];
        check = new boolean[node+1];

        //노드 간 연결 입력받기
        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(start);
        System.out.println(ans);

    }

    public static void dfs(int start) {
        check[start] = true;
        for (int i = 1; i <= node ; i++) {
            if (arr[start][i] == 1 && !check[i]){
                ans++;
                dfs(i);
            }
        }
    }
}
