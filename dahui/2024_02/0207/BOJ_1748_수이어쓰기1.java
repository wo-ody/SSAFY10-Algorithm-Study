import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1748_수이어쓰기1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        int length = 1;
        int num = 10;

        for(int i=1; i<=N; i++) {
            if(i%num == 0) {
                length++;
                num *= 10;
            }
            ans += length;
        }
        System.out.println(ans);
    }
}
