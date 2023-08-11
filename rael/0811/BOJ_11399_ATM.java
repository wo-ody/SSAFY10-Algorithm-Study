import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {
    static int N, ans, sum;
    static int[] P;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            P[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(P);

        ans = sum = 0;
        for(int i=0; i<N; i++){
            sum += P[i];
            ans += sum;
        }
        System.out.println(ans);
    }
}
