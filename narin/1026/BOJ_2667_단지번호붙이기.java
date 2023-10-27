import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    private static int[][] map;
    private static boolean[][] isVisited;
    private static int N, count;
    private static PriorityQueue<Integer> result;
    private static int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static void dfs(int x, int y){
        isVisited[x][y] = true;

        for(int[] d:delta){
            int nx = x+d[0];
            int ny = y+d[1];

            if(nx<0||ny<0||nx>=N||ny>=N) continue;
            if(isVisited[nx][ny]) continue;
            if(map[nx][ny] == 0) continue;

            count++;
            dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N][N];
        result = new PriorityQueue<>();

        for(int i =0; i<N; i++){
            String str = br.readLine();
            for(int j = 0; j<N; j++){
                map[i][j] = str.charAt(j) -'0';
            }
        }

        // dfs로 1인 곳만 세고..
        for(int i =0; i<N; i++){
            for(int j =0; j<N; j++){
                if(!isVisited[i][j] && map[i][j] == 1){
                    count =1;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }


        System.out.println(result.size());

        while(!result.isEmpty()){
            System.out.println(result.poll());
        }
    }
}
