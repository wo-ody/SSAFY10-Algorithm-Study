import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953_AtoB {
    static int A, B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while (true) {
            if (B % 10 == 1) { // 일의 자리 수가 1일때
                B /= 10;
                cnt++;
            } else if (B % 2 == 0) { // 짝수일 때
                B /= 2;
                cnt++;
            }

            if (A == B) { // A로 B를 만들 수 있을 때
                break;
            } else if (B < A) { // A로 B를 만들 수 없을 때
                System.out.println(-1);
                return;
            } else if (B % 2 != 0 && B % 10 != 1) { // 두가지 연산으로 B를 만들 수 없을 때
                System.out.println(-1);
                return;
            }
        }
        System.out.println(cnt);
    }
}
