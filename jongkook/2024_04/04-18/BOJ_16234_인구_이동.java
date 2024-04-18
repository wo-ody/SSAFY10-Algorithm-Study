package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 길을 만들어준 다음에 BFS로 어디어디 연결 되었는지 확인
public class BOJ_16234_인구_이동 {
    static int N, lower, upper, diff;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static Queue<Node> queue = new ArrayDeque<>();
    static boolean isMove;
    static ArrayList<Node> lst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        lower = Integer.parseInt(st.nextToken());
        upper = Integer.parseInt(st.nextToken());
        diff = upper - lower;

        map = new int[N][N];


        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < N; k++){
                map[n][k] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(findStartIndex());
    }

    // map을 전부 다 돌면서 BFS를 실행
    // BFS에서 나의 인접한 면을 확인 후 개방할 수 있는 곳이라면 visited에 true
    // 모든 곳을 전부 다 확인하기
    // 모든 곳을 다 돌았고 true로 되어있는 면이 모두 같은 값일때 종료
    static int findStartIndex(){
        int cnt = 0;
        while(true){
            visited = new boolean[N][N];
            isMove = false;
            // 모든 면을 돌았는데 BFS를 아무것도 안했다면 끝?
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(visited[i][j]) continue;
                    lst = new ArrayList<>();
                    BFS(i, j);
                    if(lst.size() > 1) popularCalculate();

                }
            }
            if(!isMove) break;
            cnt++;
        }
        return cnt;
    }

    static void popularCalculate(){
        int sum = 0;
        for(Node node: lst) sum += map[node.x][node.y];
        sum /= lst.size();
        for(Node node: lst) map[node.x][node.y] = sum;
    }

    // 큐의 첫번째 값에 뭘 넣어야하지?
    // 무조건 0,0은 아닌데
    static void BFS(int x, int y){
        visited[x][y] = true;
        queue.add(new Node(x, y));
        lst.add(new Node(x, y));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int d = 0; d < 4; d++){
                int nx = dx[d] + node.x;
                int ny = dy[d] + node.y;

                if(isRange(nx, ny)) continue;

                int value = map[node.x][node.y];
                int nValue = map[nx][ny];

                if(Math.abs(nValue - value) >= lower && Math.abs(nValue - value) <= upper){
                    isMove = true;
                    lst.add(new Node(nx, ny));
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
    // 값을 벗어나면 return true;
    static boolean isRange(int nx, int ny){
        return (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]);
    }
    static class Node{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
