import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] power;
    static int[] wei;
    static boolean[] broke;
    static int result = -1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        power = new int[N];
        wei = new int[N];
        broke = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            power[i] = Integer.parseInt(st.nextToken());
            wei[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        System.out.println(result);
    }

    static void dfs(int cnt, int brokeCnt){
        if(cnt == N){
            result = Math.max(result,brokeCnt);
            return;
        }

        if(broke[cnt]){
            dfs(cnt + 1, brokeCnt);
            return;
        }
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            if(i == cnt || broke[i]) continue;
            // 칠 계란을 선택한 것임
            flag = true;
            int self = power[cnt] - wei[i];
            int other = power[i] - wei[cnt];

            // 내구도 power 갱신
            power[cnt] -= wei[i];
            power[i] -= wei[cnt];
            if(self <= 0 && other <= 0){
                broke[cnt] = true;
                broke[i] = true;
                dfs(cnt + 1, brokeCnt + 2);
                broke[cnt] = false;
                broke[i] = false;
            }
            else if(self <= 0){
                broke[cnt] = true;
                dfs(cnt + 1, brokeCnt + 1);
                broke[cnt] = false;
            }
            else if(other <= 0){
                broke[i] = true;
                dfs(cnt + 1, brokeCnt + 1);
                broke[i] = false;
            }
            else{ // 둘 다 깨지지 않았음
                dfs(cnt + 1, brokeCnt);
            }

            // 내구도 power 복구
            power[cnt] += wei[i];
            power[i] += wei[cnt];

        }
        if(flag == false)
            dfs(N, brokeCnt);
    }
}
