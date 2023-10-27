package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064_카잉_달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int count = x % (m + 1);
            int tempY = x;

            for (int j = 0; j < n; j++) {
                int ty = tempY % n == 0 ? n : tempY % n;
                if (ty == y) {
                    break;
                }

                tempY = ty + m;
                count += m;
            }

            if (count > lcm(m, n)) {
                System.out.println(-1);
            } else {
                System.out.println(count);
            }
        }
    }
    static void calender(int N, int M, int x, int y) {
        int result = 1;
        int rx = 1;
        int ry = 1;
        while(!(x == rx && y == ry)) {
            if(rx == N && ry == M) {
                System.out.println(-1);
                return;
            }
            rx++;
            ry++;
            result++;
            if(rx > N) rx = 1;
            if(ry > M) ry = 1;
        }

        System.out.println(result);
    }

    /* 최소 공배수 */
    static int lcm(int x, int y) {
        return x * y / gcd(x, y);
    }

    /* 최대 공약수*/
    static int gcd(int x, int y) {
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }
}
