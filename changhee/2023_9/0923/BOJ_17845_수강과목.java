import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] v=new int[k+1];
        int[] w=new int[k+1];
        for(int i =1; i<k+1; i++){
            st=new StringTokenizer(br.readLine());
            v[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp =new int[k+1][n+1];

        for(int i =1; i<k+1; i++){
            for(int j=1; j<n+1; j++){
                if(w[i]<=j){
                    dp[i][j] = Math.max(dp[i-1][j-w[i]]+v[i],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[k][n]);
    }
}
