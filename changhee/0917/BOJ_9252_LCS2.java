import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1= br.readLine();
        String str2= br.readLine();

        int n =str1.length()+1;
        int m =str2.length()+1;
        int[][] dp = new int[n][m];
        for(int i = 1; i<n; i++) {
            for (int j = 1; j < m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = n-1, j=m-1;
        StringBuilder answer = new StringBuilder();
        while(i>0 && j>0){
            if(dp[i][j] == dp[i-1][j]){
                i--;
            }else if(dp[i][j] == dp[i][j-1]){
                j--;
            }else if(dp[i][j] == dp[i-1][j-1]+1){
                i--;
                j--;
                answer.insert(0,str1.charAt(i));
            }
        }
        System.out.println(dp[n-1][m-1]);
        System.out.println(answer);
    }
}
