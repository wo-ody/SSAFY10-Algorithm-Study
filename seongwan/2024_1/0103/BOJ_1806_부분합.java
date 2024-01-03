import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, S, ans = Integer.MAX_VALUE, left, right = 1;
    static int[] sum;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        sum = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + num;
        }

        if (sum[N] < S)
            System.out.println(0);
        else {
            while (right <= N) {
                if (left == right) {
                    right++;
                    continue;//두 포인터가 같은 경우 right증가
                } else if (right - left >= ans) {
                    left++;//최소 길이보다 길어지는 상황은 체크 필요x
                    continue;
                }

                if (sum[right] - sum[left] >= S) {
                    ans = right - left;//최소 길이를 체크 후 left 증가
                    left++;
                } else {//S 미만인 경우 right를 증가시키며 체크
                    right++;
                }
            }
            System.out.println(ans);
        }
    }
}
