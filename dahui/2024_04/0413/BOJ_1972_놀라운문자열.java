import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_1972_놀라운문자열 {
    static final String surprising = " is surprising.";
    static final String not = " is NOT surprising.";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("*")) break;
            int maxD = str.length() - 2;
            boolean check = true;
            for (int i = 0; i < maxD; i++) {
                HashSet<String> set = new HashSet<>();
                for (int j = 0; j < str.length() - i - 1; j++) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str.charAt(j));
                    sb2.append(str.charAt(j + i + 1));
                    if (set.contains(String.valueOf(sb2))) {
                        check = false;
                        break;
                    } else {
                        set.add(String.valueOf(sb2));
                    }
                }
                if (!check) break;
            }
            if (check) {
                sb.append(str).append(surprising);
            } else {
                sb.append(str).append(not);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
