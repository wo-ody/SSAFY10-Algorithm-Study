import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static int[] growth;
    static boolean[] choice; // value : 운동 키트 번호
    static int[] exnum; // value : 운동 증량
    static int result = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        growth = new int[N];
        choice = new boolean[N];
        exnum = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            growth[i] = Integer.parseInt(st.nextToken());
        }
        permutation(0);

        System.out.println(result);

    }

    static void calculate(){
        int sum = 500;
        for (int i = 0; i < N; i++) {
            sum += (exnum[i] - K);
            if(sum < 500) {
                return;
            }
        }
        result++;
    }

    static void permutation(int cnt){
        if(cnt == N){
            calculate();
            return;
        }

        for (int i = 0; i < N; i++) {
            if(choice[i]) continue;
            choice[i] = true;
            exnum[cnt] = growth[i];

            permutation(cnt + 1);

            choice[i] = false;
        }
    }
}
