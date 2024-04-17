import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6550_부분문자열 {
    static final String yes = "Yes";
    static final String no = "No";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = "";
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);

            String s = st.nextToken();
            String t = st.nextToken();
            int sIdx = 0;
            int tIdx = 0;

            while (true) {
                if (sIdx == s.length()) {
                    sb.append(yes).append("\n");
                    break;
                }
                if (tIdx >= t.length()) {
                    sb.append(no).append("\n");
                    break;
                }
                if (s.charAt(sIdx) == t.charAt(tIdx)) sIdx++;
                tIdx++;
            }
        }
        System.out.println(sb);
    }
}
