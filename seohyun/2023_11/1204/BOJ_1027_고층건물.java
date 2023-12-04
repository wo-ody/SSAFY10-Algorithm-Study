package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1027_고층건물 {
    static int N;
    static int[] building;

    static int result = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        building = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }

        cal();
        System.out.println(result);

    }

    static void cal(){
        for (int i = 0; i < N; i++) {
            long x1 = i + 1;
            long y1 = building[(int) x1 - 1];

            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if(i == j) continue;
                long x2 = j + 1;
                long y2 = building[(int) x2 - 1];

                long a = (y2 - y1) / (x2 - x1);
                long b = y2 - a * x2;

                // 이제, 사이값의 빌딩들 확인
                int low = Math.min(i,j);
                int high = Math.max(i,j);

                boolean isPass = true;
                for (int k = low + 1; k <= high - 1; k++) {

                    long x = k + 1;
                    long y = building[k]; // 꼭대기 좌표만 통과하면 지나지 않는것으로 간주

                    if(y <= (a * x + b)){
                        isPass = false;
                        break;
                    }
                }

                if(isPass) cnt++;
            }
            result = Math.max(result,cnt);

        }

    }


}
