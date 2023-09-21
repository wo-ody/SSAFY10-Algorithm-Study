import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1940_주몽 {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i = 0; i<N-1; i++){
            for(int j = i+1; j<N; j++){
                if(arr[i]+arr[j] == M){
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }
}
