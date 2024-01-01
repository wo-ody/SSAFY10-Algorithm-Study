import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static int N,ans;

    static int[] input,dp;
    public static void main(String[] args)throws Exception {
        N=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        input=new int[N];
        dp=new int[N];

        for (int i = 0; i < N; i++) {
            input[i]=Integer.parseInt(st.nextToken());
        }

        dp[0]=1;
        for (int i = 1; i <N ; i++) {
            for (int j = 0; j <i ; j++) {
                if (input[i]>input[j]){
                   dp[i]=Math.max(dp[i],dp[j]);
                }
            }
            dp[i]++;
            ans= Math.max(ans,dp[i]);
        }
        System.out.println(ans);
    }
}