import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int t= Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; tc++){
            int n =Integer.parseInt(br.readLine());

            int[] coins=  new int[n];
            st=new StringTokenizer(br.readLine());
            for(int i =0; i<n; i++){
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            int[] dp=new int[m+1];
            dp[0]=1;
            for(int i =0; i<n; i++){
                for(int j =coins[i]; j<m+1; j++){
                    dp[j] += dp[j-coins[i]];
                }
            }
            answer.append(dp[m]).append("\n");
        }

        System.out.println(answer);
    }
}
