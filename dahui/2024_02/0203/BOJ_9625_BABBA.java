import java.util.Scanner;

public class BOJ_9625_BABBA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        int A = 1;
        int B = 0;

        for (int i = 0; i < K; i++) {
            int aCnt = A;
            int bCnt = B;

            A -= aCnt;
            B += aCnt;
            A += bCnt;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(A).append(" ").append(B);
        System.out.println(sb);
    }
}
