package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16194_카드_구매하기_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // dp로 해결하면 될 것 같음

        int [] cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int [] dp = new int [N];

        for(int i = 0 ; i < N ; i ++){
            dp[i] = cards[i];
        }

        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < i ; j ++){
                if (dp[i] > dp[i-(j+1)] + cards[j])
                    dp[i] = dp[i-(j+1)] + cards[j];
            }
        }
        // 0 1 2 3
        // 1 5 6 7
        // 1 2 6 7
        // 1 2 3 7
        // 1 2 3 4
        System.out.println(dp[N-1]);




    }
}
