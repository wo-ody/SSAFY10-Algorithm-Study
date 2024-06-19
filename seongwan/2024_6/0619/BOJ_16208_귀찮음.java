import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] input;
    static long ans;
    public static void main(String[] args)throws Exception {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        input = new int[N];

        for (int i = 0; i <N ; i++) {
            input[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        for (int i = 0; i < N-1 ; i++) {
            ans+=(long)input[i]*input[N-1];
            input[N-1]+=input[i];
        }

        System.out.print(ans);
    }
}
