import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과사다리게임 {
    static int N, M;
    static int[] board;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[101];
        visited = new int[101];

        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        int x = 0;
        int y = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }

        bfs(1);

        System.out.println(visited[100]);

    }

    public static void bfs(int startNode){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        visited[startNode] = 0;

        while(!queue.isEmpty()){
            int visitedNum = queue.poll();
            for(int i = 1; i<=6; i++){
                int nextNode =  visitedNum + i;
                if(nextNode <=100 && visited[board[nextNode]] == 0){
                    queue.add(board[nextNode]);
                    visited[board[nextNode]] = visited[visitedNum]+1;
                }
            }
        }
    }

}
