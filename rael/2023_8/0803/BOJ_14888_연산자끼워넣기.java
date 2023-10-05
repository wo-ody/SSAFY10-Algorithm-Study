package BOJ14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int MAX = Integer.MIN_VALUE;   
    public static int MIN = Integer.MAX_VALUE;
    public static int[] opt = new int[4];
    public static int[] number;                
    public static int N;                        
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        number = new int[N];

        // 숫자 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
        	opt[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);

    }

    public static void dfs(int num, int idx) {
        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 연산자 개수가 1개 이상인 경우
            if (opt[i] > 0) {
                // 해당연산자를 1 감소시킨다
            	opt[i]--;

                if(i==0) dfs(num + number[idx], idx + 1);
                else if(i==1) dfs(num - number[idx], idx + 1);
                else if(i==2) dfs(num * number[idx], idx + 1);
                else if(i==3) dfs(num / number[idx], idx + 1);
                
                // 재귀 후 원복
                opt[i]++;
            }
        }
    }
}
