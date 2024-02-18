package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 모든 경우를 다 봐줘야 함 , 0.5초라 효율적으로 봐줘야함
// 투포인터로 현재 수에서 0번째 수부터 하나씩 빼줌으로써 누적합 계산
public class boj_2003_수들의합2 {
    static int N,M;
    static int[] map;

    static int result = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        simulation();

        System.out.println(result);
    }

    static void simulation(){
        long sum = 0;

        for (int i = 0; i < N; i++) {
            sum += map[i];

            long temp = sum;
            for (int j = 0; j <= i; j++) {
                if(temp == M) {
                    result++;
                    break; // 자연수
                }
                temp -= map[j];
            }
        }
    }
}
