import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        Deque<Character> queue = new ArrayDeque<>();

        for (int i = 0; i < S.length(); i++) {
            queue.add(S.charAt(i));
        }

        int ans = 1;

        while (!queue.isEmpty()) {
            String temp = String.valueOf(ans);
            for (int i = 0; i < temp.length(); i++) {
                char num = temp.charAt(i);

                if (num == queue.peek()) {
                    queue.poll();
                    if (queue.isEmpty())
                        break;
                }
            }
            ans++;
        }

        System.out.println(ans - 1);
    }
}