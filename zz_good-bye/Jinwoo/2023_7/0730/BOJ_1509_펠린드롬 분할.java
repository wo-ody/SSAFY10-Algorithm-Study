import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String args[]) throws IOException{
        String str = br.readLine();
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        
        for (int len=0;len<n;len++){
            for (int i=0; i+len<n; i++) {
                if (len==0) dp[i][i] = true;
                else if (len==1) dp[i][i+1] = str.charAt(i) == str.charAt(i+1);
                else{
                    int j = i+len;
                    dp[i][j] = dp[i+1][j-1]&&(str.charAt(i) == str.charAt(j));
                }
            }
        }
        int[] d = new int[n+1];
        for (int i=0; i<n;i++) d[i] = 2501;
        d[0] = 1;
        d[n] = 0;
        for (int j=0; j<n; j++){
            for (int i=0; i<=j; i++){
               if (dp[i][j]){
                   d[j] = Math.min(d[j], d[(i!=0)? i-1:n] + 1);
               } 
            }
        }
        bw.write(""+d[n-1]+"\n");
        bw.flush();
    }
}
