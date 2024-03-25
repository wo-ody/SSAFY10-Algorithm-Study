import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15565_귀여운라이언 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int cnt = arr[right]==1?1:0;

        while(true) {
            if (cnt == K) {
                if (arr[left] == 1 && arr[right] == 1){
                    ans = Math.min(ans, right-left+1);
                    left++;
                    cnt--;
                }else if (arr[right] == 1) {
                    left++;
                }
            }else {
                right++;
                if (right >= N) break;
                if (arr[right] == 1) cnt++;
            }
        }
        System.out.println(ans==Integer.MAX_VALUE?-1:ans);
    }
}
