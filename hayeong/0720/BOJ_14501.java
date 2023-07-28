import java.util.Scanner;

public class 퇴사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] time = new int[n + 1];
        int[] pay = new int[n + 1];
        for (int i = 0; i < n; i++) {
            time[i] = sc.nextInt();
            pay[i] = sc.nextInt();
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (i + time[i] <= n) { // 범위 안 일때
                dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + pay[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);

        }

        System.out.println(dp[n]);
    }
}
