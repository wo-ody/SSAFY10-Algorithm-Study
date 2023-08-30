import java.util.Arrays;
import java.util.Scanner;

public class BOJ_17212_달나라토끼를위한구매대금지불도우미 {

    static int[] money = {1, 2, 5, 7};

    public static void main(String[] args) {
        // 입력 및 초기화
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1]; // dp배열: index원을 만들 수 있는 최소 동전개수를 저장
        Arrays.fill(dp, Integer.MAX_VALUE); // 최소값으로 업데이트 하기위해 최댓값으로 초기화

        // 상항식
        for (int i = 1; i <= n; i++) {
            // 동전에 해당하는 금액이라면 최소 동전개수는 1개
            if (i == 1 || i == 2 || i == 5 || i == 7) {
                dp[i] = 1;
            }
            // 그게 아니라면, (현재금엑에서 동전 금액만큼 뺸 금액의 dp값 + 1)과 (현재 dp값) 중 최소값으로 업데이트
            else {
                for (int j = 0; j < 4; j++) {
                    if (i - money[j] <= 0) break;
                    dp[i] = Math.min(dp[i], dp[i - money[j]] + 1);
                }
            }

        }
        // 출력 
        if (dp[n] == Integer.MAX_VALUE) dp[n] = 0;
        System.out.println(dp[n]);
    }
}
