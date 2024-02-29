import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_9012_gwalho {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            boolean isValid = true;

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == '(') {
                    stack.push(c);
                } else { // ')'
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!stack.isEmpty()) {
                isValid = false;
            }

            sb.append(isValid ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}
