import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*; 

public class Main {
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
static int N,ans;
static int[] dp;
public static void main(String[] args) throws Exception {
N=Integer.parseInt(br.readLine());
StringTokenizer st=new StringTokenizer(br.readLine()); 

dp=new int[N];
dp[0]=Integer.parseInt(st.nextToken());
ans=dp[0];

for(int i=1; i<N;i++){
dp[i]=Integer.parseInt(st.nextToken());
if(dp[i-1]>0)
dp[i]+=dp[i-1];
ans=Math.max(dp[i],ans);
}
System.out.print(ans);
}
}
