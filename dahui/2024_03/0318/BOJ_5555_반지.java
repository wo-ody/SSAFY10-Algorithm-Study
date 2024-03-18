import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_5555_반지 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int l = s.length();
            s += s.substring(0, str.length());
            for (int j = 0; j < l; j++) {
                if (s.startsWith(str, j)) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
