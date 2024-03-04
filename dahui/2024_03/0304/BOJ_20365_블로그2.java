import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_20365_블로그2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int r = 0;
        int b = 0;
        char pre = '\0';
        for (int i = 0; i < N; i++) {
            char now = str.charAt(i);
            if (now != pre) {
                if (now == 'R') r++;
                else b++;
            }
            pre = now;
        }
        System.out.println(Math.min(r,b) + 1);
    }
}
