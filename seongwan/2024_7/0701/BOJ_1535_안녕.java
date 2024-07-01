import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args)throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N =Integer.parseInt(br.readLine());
       
       int[][] input = new int[N][2];
       
       StringTokenizer st = new StringTokenizer(br.readLine());
       for (int i=0 ;i<N ;i++ ){
           input[i][0]=Integer.parseInt(st.nextToken());
       } 
       
         st = new StringTokenizer(br.readLine());
       for (int i=0 ;i<N ;i++ ){
           input[i][1]=Integer.parseInt(st.nextToken());
       } 
       
       int[] dp = new int[100];
       
       for (int i =0;i<N ;i++ ) {
           int hurt = input[i][0];
           int happy = input[i][1];
             for (int j=99;j>=hurt ;j-- ) {
               dp[j]=Math.max(dp[j],dp[j-hurt]+happy);
         } 
       }
       System.out.print(dp[99]);
    }
}
