import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, maxLevel, ans;
    static List<Integer>[] levelList;
    static int[] workTime;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        levelList = new List[N + 1];
        workTime = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            levelList[i] = new ArrayList();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            levelList[level].add(i);
            workTime[i] = time;
            maxLevel = Math.max(maxLevel, level);
        }

        for (int i = 1; i < maxLevel; i++) {
            for (Integer cur : levelList[i]) {
                for (Integer next : levelList[i + 1]) {
                    int diff = next - cur;
                    dp[next] = Math.max(dp[next], dp[cur] + workTime[cur] + diff * diff);
                }
            }
        }

        for (Integer i : levelList[maxLevel]) {
            ans = Math.max(ans, dp[i] + workTime[i]);
        }

        System.out.println(ans);
    }
}