import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2579_계단오르기 {
    static int n;
    static int[] stairs;

    public static void main(String[] args) throws IOException {
        // 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) { // 1일때 자기자신의 점수
                dp[1] = stairs[1];
            } else if (i == 2) { // 2일때, 계단은 자연수 점수를 가지므로 1번과 2번을 둘 다 밟은게 최댓값임
                dp[2] = stairs[1] + stairs[2];
            } else { // 현재칸에 도달하기위해 두칸을 뛰는 경우, 1칸씩 연속3번이 안되므로, 3칸전까지의 쵀댓값 + 한칸전 (=> 3칸전에서 두칸점프) 중 큰값에 현재 계단 점수 더하기
                dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
            }
        }
        System.out.println(dp[n]);
    }
}
