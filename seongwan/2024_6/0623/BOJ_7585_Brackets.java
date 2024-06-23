import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        final String yes = "Legal";
        final String no = "Illegal";

        while (true) {
            stack.clear();
            String s = br.readLine();

            if (s.equals("#")) {
                System.out.println(sb);
                break;
            }

            for (int i = 0; i < s.length(); i++) {
                char temp = s.charAt(i);

                if (temp == '(' || temp == '[' || temp == '{') {
                    stack.push(temp);
                }

                if (temp == ')') {
                    if (stack.isEmpty()) {
                        sb.append(no).append("\n");
                        break;
                    }

                    char pre = stack.pop();

                    if (pre != '(') {
                        sb.append(no).append("\n");
                        break;
                    }
                }

                if (temp == ']') {
                    if (stack.isEmpty()) {
                        sb.append(no).append("\n");
                        break;
                    }

                    char pre = stack.pop();

                    if (pre != '[') {
                        sb.append(no).append("\n");
                        break;
                    }
                }

                if (temp == '}') {
                    if (stack.isEmpty()) {
                        sb.append(no).append("\n");
                        break;
                    }

                    char pre = stack.pop();

                    if (pre != '{') {
                        sb.append(no).append("\n");
                        break;
                    }
                }

                if (i == s.length() - 1) {
                    if (stack.isEmpty())
                        sb.append(yes).append("\n");
                    else
                        sb.append(no).append("\n");
                }
            }
        }
    }
}