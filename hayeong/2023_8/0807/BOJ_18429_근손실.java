import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 근손실_18429 {
    static int N, K; // 운동키트 개수, 감소 중량
    static int[] kit; // 운동키트
    static boolean[] selected; // 선택여부
    static int[] ans; // 운동키트 순서

    static int cnt = 0; // 500 이상을 유지하는 운동키트의 개수

    public static void main(String[] args) throws IOException {
        // 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        kit = new int[N];
        ans = new int[N];
        selected = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            kit[i] = Integer.parseInt(st.nextToken());
        }
        // 모든 순열에 대해 500 이상을 유지하는 운동키트의 개수를 셈
        perm(0);
        System.out.println(cnt);
    }

    static void perm(int tgtIdx) {
        if (tgtIdx == N) {
            // complete code;
            int cur = 0; // 현재 중량
            boolean isMinus = false; // 음수여부
            for (int i = 0; i < N; i++) { // 한 순열에 대해
                cur = cur - K + ans[i]; // 현재 중량에서 중량 감소량을 빼고 운동키트를 통해 얻을 수 있는 중량을 더함
                if (cur < 0) { // 그게 음수면 500 이하로 내려가게 되는것이므로 조건 만족 X
                    isMinus = true;
                    break;
                }
            }
            if (!isMinus) { // 한 운동키트 조합에 대해 모두 500 이상을 유지했다면 개수 더하기
                cnt++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (selected[i]) continue;
            ans[tgtIdx] = kit[i];
            selected[i] = true;
            perm(tgtIdx + 1);
            selected[i] = false;
        }
    }
}
