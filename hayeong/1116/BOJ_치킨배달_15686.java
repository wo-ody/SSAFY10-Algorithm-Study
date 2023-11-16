
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달_15686 {
    static int N, M;
    static int[][] board;

    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();

    static int[][] target;

    static int minSum = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board  =new int[N+1][N+1];
        target = new int[M][2];

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) house.add(new int[]{i, j});
                else if(board[i][j] == 2) chicken.add(new int[]{i, j});
            }
        }

        comb(0, 0);
        System.out.println(minSum);
    }

    static void comb(int srcIdx, int tgtIdx){
        if(tgtIdx == M){
            // complete code;
            // 각 집마다 최소 치킨거리를 구함.
            // 각 집의 최소 치킨거리를 sum에 더함
            // 모든 칩의 최소 치킨거리를 더한 sum과 minSum을 비교함
            int sum = 0;
            for(int i = 0; i<house.size(); i++){
                int[] curHouse = house.get(i);
                int minDist = Integer.MAX_VALUE;
                for(int j = 0; j<M; j++){
                    int[] curChicken = target[j];
                    minDist = Math.min(minDist, Math.abs(curHouse[0]-curChicken[0]) + Math.abs(curHouse[1]-curChicken[1]));
                }
                sum += minDist;
            }
            minSum = Math.min(minSum, sum);
            return;
        }
        if(srcIdx == chicken.size()) return;

        target[tgtIdx] = chicken.get(srcIdx);
        comb(srcIdx+1, tgtIdx+1);
        comb(srcIdx+1, tgtIdx);
    }
}
