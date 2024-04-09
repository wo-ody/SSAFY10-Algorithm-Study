import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13417_카드문자열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = "";
            char first = st.nextToken().charAt(0);
            str += first;
            for (int j = 1; j < n; j++) {
                Character c = st.nextToken().charAt(0);
                if (str.charAt(0) - c >= 0) str = c + str;
                else str = str + c;
            }
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}
