import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2018_수들의합5 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for(int i = 1; i<=N; i++){
            arr[i] = i;
        }
        int left = 1;
        int right = 1;
        int sum = 1;
        int ans = 1;
        while(right!=N){
            if(left>N || right>N) break;
            if(sum == N){
                ans++;
                right++;
                sum+=arr[right];
            }
            else if(sum >N){
                sum-=arr[left];
                left++;

            } else{
                right++;
                sum+=arr[right];

            }
        }
        System.out.println(ans);

    }
}
