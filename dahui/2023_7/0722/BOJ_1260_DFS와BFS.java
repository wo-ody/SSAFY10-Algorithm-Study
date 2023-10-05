import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1406 {
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;
    static int node, line, start;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        //노드 간 간선 연결을 표시하는 배열
        arr = new int[node+1][node+1];
        //노드 방문 체크
        check = new boolean[node+1];

        //노드 간 연결 입력받기
        for (int i=0; i<line; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(start);
        sb.append("\n");
        check = new boolean[node+1]; // bfs 수행 전 방문 체크 초기화

        bfs(start);

        System.out.println(sb);
    }

    private static void dfs(int start) {
        check[start] = true; //방문 체크하기
        sb.append(start + " "); //출력 결과에 방문한 노드 입력

        for (int i = 1; i <= node; i++) {
            if (arr[start][i] == 1 && !check[i]) // 노드가 연결 되있는지, 방문 안했던 노드인지
                dfs(i);
        }
    }

    public static void bfs(int start) {
        q.add(start); //큐에 현재 방문한 노드 넣기
        check[start] = true; //방문한 노드 방문 체크

        //큐가 빌때까지
        while(!q.isEmpty()) {
            start = q.poll(); //큐에서 현재 방문하는 노드 꺼내기
            sb.append(start + " "); //출력할 결과에 방문한 노드 입력

            for(int i=1; i<=node; i++){
                //노드가 연결 되있고, 방문 하지 않은 노드라면
                if(arr[start][i] == 1 && !check[i]){
                    q.add(i); //큐에 노드 넣기
                    check[i] = true; //노드 방문 체크하기
                }
            }
        }
    }
}
